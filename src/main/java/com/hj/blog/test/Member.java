package com.hj.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter 롬북
//@AllArgsConstructor // 전체 매개변수 생성자 롬북
@NoArgsConstructor // 빈 생성자 롬북
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
