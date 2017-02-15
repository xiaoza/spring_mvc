package com.zaikejian.lecture.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by xiaoz on 2017/2/15.
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	/**
	 * 当DispatcherServlet注册到Servlet容器后,就会调用该方法
	 * 我们可以在这里对DispatcherServlet进行额外的配置
	 */
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads"));
	}
}
