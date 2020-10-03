package basicauth.demo.services;

import basicauth.demo.models.User;
import basicauth.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean insertUser(User user) {
        if(userRepository.findUserByUsername(user.getUsername())==null && userRepository.findUserByEmail(user.getEmail())==null){
            userRepository.save(user);
            return true;
        };
        return false;
    }
}
