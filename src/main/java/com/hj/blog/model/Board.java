package com.hj.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // board 클래스가 자동으로 MySQL 테이블에 생성이 된다. 
public class Board {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 사용할 것임. <html> 태그가 섞여서 디자인됨

	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne // Many = Board, User = one 즉 한명의 유저는 여러개의 보드를 쓸 수 있다.
	@JoinColumn(name="userId")
	private User user; //DB에는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있고
	
	@CreationTimestamp //데이터가 insert 될때 자동으로 시간 들어감
	private Timestamp createDate;
}
