package com.spinic.market.controller;

import com.spinic.market.entities.User;
import com.spinic.market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/market/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws NoSuchElementException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found for this ID" + userId));
        userRepository.delete(user);
        Map<String, Boolean> responseMap = new HashMap<>();
        responseMap.put("Deleted", Boolean.TRUE);
        return responseMap;
    }
}
