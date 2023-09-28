package app.skillCaptain.cabmanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverRegistrationRequest {
    private String username;
    private String password;
    private String email;
}
