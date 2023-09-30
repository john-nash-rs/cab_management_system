package app.skillCaptain.cabmanagement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rider")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rider extends User {
    @Column(unique=true)
    private String riderId;

}
