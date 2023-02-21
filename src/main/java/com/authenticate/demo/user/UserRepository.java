package com.authenticate.demo.user;

import com.authenticate.demo.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
     UserModel findByEmail(String email);
}
