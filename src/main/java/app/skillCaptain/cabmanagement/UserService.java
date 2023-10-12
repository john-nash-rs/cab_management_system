package app.skillCaptain.cabmanagement;

import app.skillCaptain.cabmanagement.rating.Rating;
import app.skillCaptain.cabmanagement.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private RatingRepository ratingRepository;

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

    public Rating postRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsForUser(Long userId) {
        return ratingRepository.findByUserId(userId);
    }
}
