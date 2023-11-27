package com.example.board.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.board.filter.LogFilter;
import com.example.board.filter.LoginCheckFilter;
import com.example.board.interceptor.LogInterceptor;
import com.example.board.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private String[] excludePaths = {"/", "/member/join", "/member/login", "/member/logout", "/*.css", 
																	"/*.js", "/*.ico", "/error"};
	
//	@Bean
	public FilterRegistrationBean<Filter> logfilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		// 등록할 필터를 지정
		filterRegistrationBean.setFilter(new LogFilter());
		// 필터의 우선순위 설정(숫자가 낮을수록 먼저 실행)
		filterRegistrationBean.setOrder(1);
		// 필터를 적용할 URL 패턴을 지정.
		filterRegistrationBean.addUrlPatterns("/*"); // 최상위 경로 밑으로 들어오는 모든 경로에 필터를 적용
		///////////
		return filterRegistrationBean;
	}
	
//	@Bean
	public FilterRegistrationBean<Filter> loginCheckFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		// 등록할 필터를 지정
		filterRegistrationBean.setFilter(new LoginCheckFilter());
		// 필터의 우선순위 설정(숫자가 낮을수록 먼저 실행)
		filterRegistrationBean.setOrder(2);
		// 필터를 적용할 URL 패턴을 지정.
		filterRegistrationBean.addUrlPatterns("/*"); // 최상위 경로로 들어오는 모든 경로에 필터를 적용
		
		return filterRegistrationBean;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터 등록
//		registry.addInterceptor(new LogInterceptor())
//		.order(1) // 인터셉터 호출 순서를 지정
//		.addPathPatterns("/**") // 인터셉터를 적용할 URL 설정
//		.excludePathPatterns("/*.css", "/error"); // 인터셉터에서 제외할 패턴을 지정
		
		// 로그인 인터셉터
		registry.addInterceptor(new LoginCheckInterceptor())
		.order(2) // 인터셉터 호출 순서를 지정
		.addPathPatterns("/**") // 인터셉터를 적용할 URL 설정
		.excludePathPatterns(excludePaths); // 인터셉터에서 제외할 패턴을 지정
	}
	
	
	
	
	
	
	
	
	
	
}
