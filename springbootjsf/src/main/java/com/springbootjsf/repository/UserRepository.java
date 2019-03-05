package com.springbootjsf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootjsf.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsernameAndPassword(String username,String password);
	
	public static final String FIND_PROJECTS = "SELECT password FROM public.user";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
	List<String> findAllPassword();
	
	User findByPassword(String password);

}
