package com.bank.repository;
import java.util.List;

import com.bank.models.User;
import com.bank.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>  {
   
	@Query("select p from User p where p.username = :username")
  	User findByUsername(@Param("username") String username);

	@Query("select p from User p where p.username = :username and p.password = :password")
	User searchLoginUsername(@Param("username") String username, @Param("password") String password);

  	User findByEmail(@Param("email") String email);

  	@Query("SELECT p FROM User p WHERE p.username LIKE :searchTerm OR p.email LIKE :searchTerm")
  	public List<User> search(@Param("searchTerm") String searchTerm);

}
