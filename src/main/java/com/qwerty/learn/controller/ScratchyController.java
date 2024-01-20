package com.qwerty.learn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
    @GetMapping("/restricted")
    public ResponseEntity<?> getRestrictedMessage() {
        return new ResponseEntity<>("This is a restricted message", HttpStatus.OK);
    }
	

}
