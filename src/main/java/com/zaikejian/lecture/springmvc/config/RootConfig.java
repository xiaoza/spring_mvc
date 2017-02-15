package com.zaikejian.lecture.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

/**
 * Created by xiaoz on 2017/2/15.
 */
@Configuration
@ComponentScan(
		basePackages = {"com.zaikejian.lecture.springmvc"},
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
		}
)
public class RootConfig {
	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("com.zaikejian.lecture.springmvc\\.web"));
		}
	}
}
