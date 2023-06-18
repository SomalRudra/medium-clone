package edu.miu.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

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
