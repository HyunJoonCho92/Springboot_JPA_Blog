package com.hj.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일) 일때 -> controller

// 사용자가 요청 -> 응답(data) 일 때 -> restController

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest: ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("name").password("1234").email("abc@e.com").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("HJ");
		System.out.println(TAG + "getter : " + m.getUsername());
		
		return "lombok test 완료";
	}
	
	// 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청" + m.getId() + ", " + m.getUsername();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트) 개념 확실히 알자
		return "post 요청" + m.getId() + ", " + m.getUsername()+ ", " + m.getPassword()+ ", " + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청" + m.getId() + ", " + m.getUsername()+ ", " + m.getPassword()+ ", " + m.getEmail();
	}

	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
	
}