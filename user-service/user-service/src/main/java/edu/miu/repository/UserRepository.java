package edu.miu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.miu.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.username=?1")
	User findByUserName(String userName);

}
