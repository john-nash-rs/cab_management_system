package app.skillCaptain.cabmanagement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "driver")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Driver extends User {

    private String driverId;
    private boolean is_on_duty;
}
