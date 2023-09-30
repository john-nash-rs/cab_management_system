package app.skillCaptain.cabmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<Rider> findByRiderId(String riderId);

    Optional<Driver> findByDriverId(String driverId);
}
