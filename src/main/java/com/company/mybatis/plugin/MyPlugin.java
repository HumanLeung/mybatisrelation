package com.company.mybatis.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;


@Intercepts(@Signature(type= ResultSetHandler.class, method = "handleResultSets", args = Statement.class))
@Component
public class MyPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> records = (List<Object>)invocation.proceed();
        records.forEach(this::encode);
        return records;
    }

    private void encode(Object o) {
//        o.getClass()
        Class<?> sourceClass = o.getClass();
        MetaObject metaObject = SystemMetaObject.forObject(o);
        Stream.of(sourceClass.getDeclaredFields()).filter(field ->
                field.isAnnotationPresent(Encoder.class)).forEach(field -> doEncode(metaObject,field));
    }

    private void doEncode(MetaObject metaObject, Field field) {
        String name = field.getName();
        Object value = metaObject.getValue(name);
        if(String.class == metaObject.getGetterType(name) && value != null) {
           Encoder encoder = field.getAnnotation(Encoder.class);
           EncodeStrategy type = encoder.strategy();
           Object o = type.getEncrypt().apply((String)value);
           metaObject.setValue(name,o);
        }
    }
}
