package com.liss.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

import com.liss.PasswordEncryptDecrypt;


@Configuration
//@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER)//ACCESS_OVERRIDE_ORDER
@Import(PasswordEncryptDecrypt.class)
public class ServerSecurity /*extends WebSecurityConfigurerAdapter */{
	

    
	
}
