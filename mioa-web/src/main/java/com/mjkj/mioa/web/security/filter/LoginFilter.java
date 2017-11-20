/**  
 * Project Name:mioa-web  
 * File Name:LoginFilter.java  
 * Package Name:com.mjkj.mioa.web.security.filter  
 * Date:2017年11月20日下午5:00:13  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.security.filter;  

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjkj.mioa.org.entity.TOrgUser;

/**  
 * ClassName:LoginFilter   
 * Date:     2017年11月20日 下午5:00:13 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        登录过滤器
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter
{
	
	private AuthenticationManager authenticationManager;
	
	public LoginFilter(AuthenticationManager authenticationManager)
	{
		this.authenticationManager = authenticationManager;
	}
	
	// 接收并解析用户凭证  
    @Override  
    public Authentication attemptAuthentication(HttpServletRequest req,  
                                                HttpServletResponse res) throws AuthenticationException {  
        try {  
            TOrgUser user = new ObjectMapper().readValue(req.getInputStream(), TOrgUser.class);  
  
            return authenticationManager.authenticate(  
                    new UsernamePasswordAuthenticationToken(  
                            user.getName(),  
                            user.getPassword(),  
                            new ArrayList())  
            );  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token  
    @Override  
    protected void successfulAuthentication(HttpServletRequest req,  
                                            HttpServletResponse res,  
                                            FilterChain chain,  
                                            Authentication auth) throws IOException, ServletException {  
  
    	String token = "";
//        String token = Jwts.builder()  
//                .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())  
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))  
//                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")  
//                .compact();  
        res.addHeader("Authorization", "Bearer " + token);  
    }  
}
  
