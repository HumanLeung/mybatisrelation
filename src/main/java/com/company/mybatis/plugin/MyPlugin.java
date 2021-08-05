package com.company.mybatis.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.List;


@Intercepts(@Signature(type= ResultSetHandler.class, method = "handleResultSets", args = Statement.class))
public class MyPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> records = (List<Object>)invocation.proceed();
        records.forEach(this::encode);
        return null;
    }

    private void encode(Object o) {
//        o.getClass()
    }
}
