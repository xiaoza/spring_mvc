package com.zaikejian.lecture.springmvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by xiaoz on 2017/2/15.
 */
@ControllerAdvice
public class DealExceptions {

	@ExceptionHandler(DuplicateException.class)
	public String duplicateHandler() {
		return "error/duplicate";
	}
}
