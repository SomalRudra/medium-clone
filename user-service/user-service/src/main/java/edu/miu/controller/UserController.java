package edu.miu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.dto.UserRequest;
import edu.miu.dto.UserResponse;
import edu.miu.model.User;
import edu.miu.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	@PostMapping()
	public ResponseEntity<String> addUser(@RequestBody @Valid UserRequest userRequest){
		String response = userService.addUser(userRequest);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
		UserResponse user = userService.findUserById(userId);
		
		return ResponseEntity.status(HttpStatus.FOUND)
							 .body(user);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserResponse>> getAll(){
		List<UserResponse> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping()
	public ResponseEntity<User> editUser(@RequestBody @Valid User user) {
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		String result = userService.deleteUserById(userId);
		
		return ResponseEntity.status(HttpStatus.FOUND)
							 .body(result);
	}
	
}
