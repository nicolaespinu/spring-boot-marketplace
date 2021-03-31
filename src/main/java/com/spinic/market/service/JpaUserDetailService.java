package com.spinic.market.service;

import com.spinic.market.model.SecurityUser;
import com.spinic.market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userRepository.findUserByUsername(username);
        var securityUser = user.orElseThrow(() -> new UsernameNotFoundException("Error!"));
        return new SecurityUser(securityUser);
    }
}
