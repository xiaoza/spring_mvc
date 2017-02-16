package com.zaikejian.lecture.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by xiaoz on 2017/2/15.
 *
 * 在Servlet3.0中,容器会在类路径中查找实现了javax.servlet.ServletContainerInitializer接口的类
 * 如果能发现,就会用它来配置Servlet容器。
 * Spring已经帮我们实现了该接口,名为SpringServletContainerInitializer
 * 而这个类反过来会查找实现了WebApplicationInitializer接口的类,并将配置的任务交给它们来配置
 * 在Spring3.2中,引入了一个便利的WebApplicationInitializer实现,也就是
 * AbstractAnnotationConfigDispatcherServletInitializer
 *
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
