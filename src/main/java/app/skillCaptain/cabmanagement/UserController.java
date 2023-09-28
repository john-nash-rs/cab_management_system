package app.skillCaptain.cabmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/rider")
    public ResponseEntity<?> registerRider(@RequestBody RiderRegistrationRequest riderRequest) {
        // Perform validation and create a new Rider entity
        Rider rider = new Rider();
        rider.setUsername(riderRequest.getUsername());
        rider.setEmail(riderRequest.getEmail());
        rider.setPassword(riderRequest.getPassword());
        rider.setRiderId(UUID.randomUUID().toString());
        // You can set other Rider-specific properties here

        userService.registerRider(rider);

        return ResponseEntity.ok("Rider registered successfully");
    }

    @PostMapping("/register/driver")
    public ResponseEntity<?> registerDriver(@RequestBody DriverRegistrationRequest driverRequest) {
        // Perform validation and create a new Driver entity
        Driver driver = new Driver();
        driver.setUsername(driverRequest.getUsername());
        driver.setEmail(driverRequest.getEmail());
        driver.setPassword(driverRequest.getPassword());
        driver.setDriverId(UUID.randomUUID().toString());
        // You can set other Driver-specific properties here

        userService.registerDriver(driver);

        return ResponseEntity.ok("Driver registered successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        // Validate the user's credentials and perform authentication
        // You can implement this logic in the UserService
        User user = userService.authenticate(signInRequest.getUsername(), signInRequest.getPassword());

        if (user != null) {
            // Generate a JWT token or session for authentication and return it
            // We are not doing it here for the reason of simplicity
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}
