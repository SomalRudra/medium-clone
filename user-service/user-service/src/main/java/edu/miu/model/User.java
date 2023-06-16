package edu.miu.model;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Setter(AccessLevel.NONE)
	private Long id;
	@NotEmpty(message = "username is mandatory")
	private String username;
	@NotBlank(message = "username is mandatory")
//	at least 1 digit, at least one small letter, at least one big letter, min=6, max=12
	@Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[A-Z])(?=.*[@%#$]).{6,12})")
	private String password;
	@Email
	private String email;
	private Date created_at;
	private Date updated_at;
	
	
}
