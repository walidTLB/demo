package com.example.demo.Service;

import com.example.demo.Exception.UserAlreadyExistsException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

import com.example.demo.Repository.IUserRepository;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
    public class UserService implements  IUserService {
        @Autowired
        private IUserRepository userRepository;

        public User createUser(User user) {
            // Check if user with same username or email already exists
            if (userRepository.findByUsername(user.getUsername()) != null ||
                    userRepository.findByEmail(user.getEmail()) != null) {
                throw new UserAlreadyExistsException("Username or email already exists.");
            }

            // Set role to USER by default
            user.setRole(Role.USER);

            // Set create time to current time
            user.setCreateTime(LocalDateTime.now());

            // Save user to database
            return userRepository.save(user);
        }

    public User updateUser(User user) {
        // Check if user exists in the database
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found.");
        }

        // Get the existing user from the database
        User existingUser = optionalUser.get();

        // Update the user's properties
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());

        // Save the updated user to the database
        return userRepository.save(existingUser);
    }




    public void deleteUser(Long id) {
        // Check if user exists in the database
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found.");
        }

        // Delete the user from the database
        userRepository.deleteById(id);
    }

    public void activateUser(Long id) {
        // Check if user exists in the database
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found.");
        }

        // Activate the user
        User user = optionalUser.get();
        user.setActive(true);
        userRepository.save(user);
    }

    public void deactivateUser(Long id) {
        // Check if user exists in the database
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found.");
        }

        // Deactivate the user
        User user = optionalUser.get();
        user.setActive(false);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        // Retrieve all users from the database
        return userRepository.findAll();
    }
    public void setUserValidationPeriodAndInterim(Long userId, Integer validationPeriod, boolean interim, User authenticatedUser) {
        // Check if authenticated user is admin_ce
        if (authenticatedUser.getRole() != Role.ADMIN_CE) {
            throw new AccessDeniedException("Only admin_ce can set validation period.");
        }
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setValidationPeriod(validationPeriod);
        user.setInterim(interim);
        userRepository.save(user);
    }
    }

