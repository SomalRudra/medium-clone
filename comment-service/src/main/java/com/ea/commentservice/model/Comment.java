package com.ea.commentservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	
	@Lob
	private String content;
	
	private Long articleId;
	private Long userId;
	
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;


}
