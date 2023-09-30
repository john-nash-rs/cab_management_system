package app.skillCaptain.cabmanagement.booking;

import app.skillCaptain.cabmanagement.Rider;
import app.skillCaptain.cabmanagement.booking.Ride;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "riderId")
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "ride_id", referencedColumnName = "ride_id")
    private Ride ride;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private Payment payment;

    @Column(name = "status")
    private String status;

    @Column(name = "booking_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingTime;

    @Column(name = "cancel_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelTime;
}
