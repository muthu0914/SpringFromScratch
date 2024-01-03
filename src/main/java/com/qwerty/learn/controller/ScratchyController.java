package com.qwerty.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/scratchy")
public class ScratchyController {
	
	public ScratchyController() {
		System.out.println("ScratchyController Initiated");
	}
	
	@GetMapping("/getZero")
	public String getZero(@RequestParam("data")String data) {
		return "Sent Data is "+data+",You Got 0";
	}
	

}
