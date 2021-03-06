/**  
 * Project Name:mioa-web  
 * File Name:GlobalExceptionHandler.java  
 * Package Name:com.mjkj.mioa.web.exception  
 * Date:2017年8月18日下午3:34:11  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.exception;  

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mjkj.mioa.common.result.MioaResult;

/**  
 * ClassName:GlobalExceptionHandler <br/>  
 * Date:     2017年8月18日 下午3:34:11 <br/>  
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7  
 * @see       全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        e.printStackTrace();
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("mioaException");
        return mav;
    }

    @ExceptionHandler(value = MioaException.class)
    @ResponseBody
    public MioaResult jsonErrorHandler(HttpServletRequest req, MioaException e) throws Exception {
    	MioaResult ret = new MioaResult();
    	ret.setMsg(e.getMessage());
    	ret.setCode(MioaResult.ERROR);
        return ret;
    }

}

  
