package app.skillCaptain.cabmanagement.rating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    // Add custom queries if needed
    List<Rating> findByUserId(Long userId);
}
