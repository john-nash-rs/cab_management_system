package app.skillCaptain.cabmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerRider(Rider rider) {
        userRepository.save(rider);
    }

    public void registerDriver(Driver driver) {
        // Add driver-specific logic if needed
        userRepository.save(driver);
    }

    public User authenticate(String username, String password) {
        // Implement your authentication logic here
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
