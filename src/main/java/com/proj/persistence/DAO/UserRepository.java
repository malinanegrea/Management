package com.proj.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proj.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByNameAndUsername(String name, String username);

	@Modifying
	@Query("UPDATE User u SET u.name = :name ,  u.username = :username,  u.password = :password WHERE u.identifier = :identifier")
	int updateNameAndUsernameAndPassword(@Param("identifier") int identifier, @Param("name") String name,
			@Param("username") String username, @Param("password") String password);
}
