package basicauth.demo.repositories;

import basicauth.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByUsername(String username);

    public User findUserByEmail(String email);
}
