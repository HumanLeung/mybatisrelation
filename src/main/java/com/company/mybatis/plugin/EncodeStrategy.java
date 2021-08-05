package com.company.mybatis.plugin;

import java.util.Locale;

public enum EncodeStrategy {
    TEST(String::toUpperCase);
    private final Encrypt encrypt;
    EncodeStrategy(Encrypt encrypt) {
        this.encrypt = encrypt;
    }

    public Encrypt getEncrypt() {
        return encrypt;
    }
}
