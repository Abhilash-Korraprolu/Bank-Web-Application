package com.rmb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByPno(String username);

	User findByEmail(String email);

	List<User> findByPnoLike(String pno);

	List<User> findByFirstNameLike(String firstName);

	List<User> findByLastNameLike(String string);

	List<User> findByCityLike(String string);

	List<User> findByEmailLike(String string);

	List<User> findByPhoneNumberLike(String string);
}
