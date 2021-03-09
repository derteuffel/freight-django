package com.liss.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;



@Configuration
//@EnableResourceServer
public class ResourceServer /*extends ResourceServerConfigurerAdapter*/ {
	
/*	private static final String RESOURCE_ID = "resource-server-freight-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/secured/**";
    private static final String WS_PATTERN = "/sec/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	 http.httpBasic().disable()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      
        http
        .csrf()
            	// ignore our stomp endpoints since they are protected using Stomp headers
            .ignoringAntMatchers(WS_PATTERN,SECURED_PATTERN)
            .and()
          .headers()
            	// allow same origin to frame our site to support iframe SockJS
            .frameOptions().sameOrigin().disable()
            .authorizeRequests()
            .antMatchers(WS_PATTERN).permitAll()
            .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
            .antMatchers(HttpMethod.PUT, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
            .antMatchers(HttpMethod.DELETE, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
            .antMatchers(HttpMethod.GET, SECURED_PATTERN).access(SECURED_READ_SCOPE)
            .anyRequest().access(SECURED_READ_SCOPE);
      
    }*/
	
}
