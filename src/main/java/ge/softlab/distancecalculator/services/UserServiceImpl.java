package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.UserDomain;
import ge.softlab.distancecalculator.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDomain addUser(UserDomain user) {
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);
        return userRepository.save(user);
    }
}
