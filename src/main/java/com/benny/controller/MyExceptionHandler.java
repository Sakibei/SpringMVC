package com.benny.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

//	//可以抓專案中所有的Exception
//	@ExceptionHandler(Exception.class)
//	public Object exceptHandle(Exception e) {
//		String errMsg = "Error: Exception";
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg);
//	}

}
