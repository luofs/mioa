/**  
 * Project Name:mioa-sys  
 * File Name:WebDto.java  
 * Package Name:com.mjkj.mioa.common  
 * Date:2017年9月14日下午5:11:46  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common;  
/**  
 * ClassName:WebDto   
 * Date:     2017年9月14日 下午5:11:46 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class WebDto
{
	 //网站名称
    private String name;

    //网址
    private String url;

    //用户名
    private String username;

    //密码
    private String password;

    //日均访问量
    private Integer readCount;

    public WebDto(String name, String url, String username, String password, Integer readCount) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
        this.readCount = readCount;
    }

    public WebDto() {}

    @Override
    public String toString() {
        return "WebDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", readCount=" + readCount +
                '}';
    }

    @ExcelResources(excelTitle="网站名称",order=1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ExcelResources(excelTitle="网址",order=2)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ExcelResources(excelTitle="用户名",order=3)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ExcelResources(excelTitle="密码",order=4)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ExcelResources(excelTitle="日均访问量",order=5)
    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
}
}
  
