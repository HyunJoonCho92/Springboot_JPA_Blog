package com.hj.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	// http://localhost:8080/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		
		// 파일 리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		//------------------------------ 그런데 application.yml에서 prefix, suffix를 설정해서
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		// 풀경로 : /WEB-INF/views/a.img.jsp 라서 오류뜸
		return "/a.img";
	}
}
