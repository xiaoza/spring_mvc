package com.zaikejian.lecture.springmvc.web;

import com.zaikejian.lecture.springmvc.DuplicateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiaoz on 2017/2/15.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "error", defaultValue = "0") int error) {
		if (error > 0) {
			throw new DuplicateException();
		}
		return "home";
	}
}
