package com.liss.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;



import com.liss.PasswordEncryptDecrypt;
import com.liss.exception.CustomOauthException;


@Configuration
//@EnableAuthorizationServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(ServerSecurity.class)
public class AuthServerOauth2 /*extends AuthorizationServerConfigurerAdapter*/ {


	
}
