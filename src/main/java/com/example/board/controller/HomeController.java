package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	//메인페이지 이동
	@GetMapping("/")
  public String home() {
		
		log.info("index 페이지 출력");
	  return "index";
  }
	
	
}
