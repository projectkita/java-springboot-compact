package com.adrianaden.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.adrianaden.app.response.ResponseBody;
import com.adrianaden.app.response.ResponseCode;
import com.adrianaden.app.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping("api/auth/login")
public class AuthController {
	
	@Autowired
	JwtUtil jwtUtil;
	
	@RequestMapping(method = { RequestMethod.GET })
	public ResponseEntity<ResponseBody> getLoginAuth() {
		String token = jwtUtil.createJWT("1", "adrianaden", "token", System.currentTimeMillis()); 
		ResponseBody body = new ResponseBody(ResponseCode.SUCCESS, "Login Success", token);
		return ResponseEntity.ok().body(body);
	}
}
