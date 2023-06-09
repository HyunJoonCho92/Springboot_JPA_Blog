package com.hj.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // getter setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 자동으로 MySQL에 테이블이 생성이 된다.
// @DynamicInsert //insert시에 null인 필드를 제외시켜준다.
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //시퀀스, auto_increment
	
	@Column(nullable=false, length = 30)
	private String username; // 아이디
	
	@Column(nullable=false, length = 100) // length 길게한 이유 나중에 해쉬로 암호화 하려고
	private String password;
	
	@Column(nullable=false, length = 50)
	private String email;
	
	// @ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; // 나중에는 enum을 쓰는게 좋다. //admin, manager, user
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
}
