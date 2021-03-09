package com.liss.exception;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * Created by jaudric
 * Catch the exception when have bad credentials
 */
@JsonSerialize/*(using = CustomOauthExceptionSerializer.class)*/
public class CustomOauthException /*extends OAuth2Exception */{
   /* public CustomOauthException(String msg) {
        super(msg);
    }*/
    
}