package com.gs.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroJDBCRealmTest {
	
	public static void main(String... args) {  
	    Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbcrealm.ini");  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("abc@126.com", "123456");  
	    try {  
	        subject.login(token);  
	        System.out.println(subject.getPrincipal()); // 获取身份（用户，邮箱，手机号）
	    } catch (UnknownAccountException e) { // 未知的账户异常
	    	System.out.println("不存在该账户");
	    } catch (IncorrectCredentialsException e) { // 不正确的凭证异常
	    	System.out.println("密码错误");
	    } catch (AuthenticationException e) {
	    	e.printStackTrace();
	    	System.out.println("身份验证失败，账号或密码错误");
	    } 
	    subject.logout();  
	}  

}
