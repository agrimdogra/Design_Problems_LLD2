package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepository {
    private List<User> users = new ArrayList<>();
    public User save(User user){
        this.users.add(user);
        return user;
    }

    public Optional<User> getUserByEmail(String eMail){
        return this.users.stream()
                .filter(user->eMail.equals(user.getEmail()))
                .findFirst();
    }
}
