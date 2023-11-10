package designproblem.parkinglot.services;

import designproblem.parkinglot.models.User;
import designproblem.parkinglot.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public User saveUser(User user){
        User persistedUser =  userRepository.save(user);
        return persistedUser;
    }

    public Optional<User> fetchUser(String email){
        Optional<User> user =  userRepository.getUserByEmail(email);
        return user;
    }
}
