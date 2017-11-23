/**  
 * Project Name:mioa-web  
 * File Name:CustomTokenEnhancer.java  
 * Package Name:com.mjkj.mioa.web.security.service  
 * Date:2017年11月20日下午4:47:59  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.service;  

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**  
 * ClassName:CustomTokenEnhancer   
 * Date:     2017年11月20日 下午4:47:59 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        自定义token参数
 */
public class CustomTokenEnhancer implements TokenEnhancer
{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
			OAuth2Authentication authentication)
	{
		final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("organization", authentication.getName() + randomAlphabetic(4));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
	}
	
}
  
