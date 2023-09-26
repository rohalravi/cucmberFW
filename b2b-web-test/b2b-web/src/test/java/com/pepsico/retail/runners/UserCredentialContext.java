package com.pepsico.retail.runners;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-default.properties")
public class UserCredentialContext {
    @Value("${co.phoneNumber}")
    private String coPhoneNumber;

    @Value("${co.password}")
    private String coPassword;

    @Value("${multistore.PhoneNumber}")
    private String multiStorePhoneNumber;

    @Value("${multistore.Password}")
    private String multiStorePassword;

    @Bean("coPhoneNumber")
    public String getPhoneNumber() {
        return coPhoneNumber;
    }

    @Bean("coPassword")
    public String getPassword() {
        return coPassword;
    }

    @Bean("multiStorePhoneNumber")
    public String getMultiStorePhoneNumber() {
        return multiStorePhoneNumber;
    }

    @Bean("multiStorePassword")
    public String getMultiStorePassword() {
        return multiStorePassword;
    }

}
