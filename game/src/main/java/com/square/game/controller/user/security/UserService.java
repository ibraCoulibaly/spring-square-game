package com.square.game.controller.user.security;

import com.square.game.controller.product.ProductDAO;
import com.square.game.controller.user.User;
import com.square.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

        private BCryptPasswordEncoder passwordEncoder;
        private final UserRepository userRepository;

        public void inscription(User user){
                String mdpCrypt = this.passwordEncoder.encode(user.getPassword());
        }
        @Autowired
        public UserService(UserRepository userRepository) {

                this.userRepository = userRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String username) {
            return this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }

}
