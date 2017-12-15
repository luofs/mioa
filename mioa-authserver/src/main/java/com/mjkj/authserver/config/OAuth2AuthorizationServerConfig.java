/**  
 * Project Name:mioa-web  
 * File Name:OAuth2AuthorizationServerConfig.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月20日下午3:20:56  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.config;  

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.mjkj.authserver.service.CustomTokenEnhancer;
import com.mjkj.authserver.service.CustomUserService;

/**  
 * ClassName:OAuth2AuthorizationServerConfig   
 * Date:     2017年11月20日 下午3:20:56 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        OAuth认证配置类，将token存储在数据库
 */
@Configuration
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
	@Autowired
    private Environment env;
	
	
	@Autowired
	private MioaAuthenticationProvider authenticationProvider;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception
	{
		final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		endpoints.userDetailsService(new CustomUserService());
		endpoints.setClientDetailsService(clientDetails());
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain)
		.authenticationManager(new AuthenticationManager()
		{
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException
			{
				return authenticationProvider.authenticate(authentication);
			}
		});
		// 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30)); // 30天
        endpoints.tokenServices(tokenServices);
	}
	
	@Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }
	
	@Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource());//表结构详见http://andaily.com/spring-oauth-server/db_table_description.html
//		.withClient("client") // client_id
//        .secret("secret") // client_secret
//        .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
//        .scopes("app"); // 允许的授权范围;
	} 
	
	@Bean
	public TokenStore tokenStore()
	{
		//采用数据库方式存储token，共有4中方式存储，后续可更改
		return new JdbcTokenStore(dataSource());
	}
	
	@Bean // 声明 ClientDetails实现
    public ClientDetailsService clientDetails() 
	{
        return new JdbcClientDetailsService(dataSource());
    }
	
	@Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
	
	@Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
}
  
