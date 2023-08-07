package com.benny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

	//測試用 例外處理
	@GetMapping("/exception.controller")
	public void processAction() throws Exception {
		throw new Exception();
	}

}
