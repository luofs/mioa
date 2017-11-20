/**  
 * Project Name:mioa-web  
 * File Name:OAuth2AuthorizationServerConfig.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月20日下午3:20:56  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.security.config;  

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.mjkj.mioa.web.security.service.CustomTokenEnhancer;

/**  
 * ClassName:OAuth2AuthorizationServerConfig   
 * Date:     2017年11月20日 下午3:20:56 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        OAuth认证配置类
 */
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
	@Autowired
    private Environment env;
	
	@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception
	{
		final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain).authenticationManager(authenticationManager);
	}
	
	@Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
	
	@Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource());
	} 
	
	@Bean
	public TokenStore tokenStore()
	{
		//采用数据库方式存储token，共有4中方式存储，后续可更改
		return new JdbcTokenStore(dataSource());
	}
	
	@Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }
	
	@Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
}
  
