package com.example.demo.Repository;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IUserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("UPDATE User user SET user.role = :newRole WHERE user.id = :userId")
    void updateUserRole(@Param("userId") Long userId, @Param("newRole") Role newRole);
    List<User> findByRole(Role role);

        User findByUsername(String username);
        User findByEmail(String email);

    }

