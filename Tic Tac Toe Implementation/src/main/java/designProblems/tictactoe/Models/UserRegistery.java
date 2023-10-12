package designProblems.tictactoe.Models;

import lombok.Synchronized;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserRegistery {
    private Map<String, User> userMap = new HashMap<>();
    public static UserRegistery Instance = null;
    static Lock lock = new ReentrantLock();

    private UserRegistery() {
    }

    public User getUser(String email) {
        return userMap.getOrDefault(email, null);
    }

    public void addUser(User user) {
        userMap.putIfAbsent(user.email, user);
    }

    public static UserRegistery getInstance(){
        if(Instance == null){
            lock.lock();
                if (Instance == null){
                    Instance = new UserRegistery();
                }
            lock.unlock();

        }
        return Instance;
    }
}
