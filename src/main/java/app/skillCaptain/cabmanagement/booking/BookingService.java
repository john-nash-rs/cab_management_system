package app.skillCaptain.cabmanagement.booking;

import app.skillCaptain.cabmanagement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to book a ride
    public Long bookRide(String riderId) {
        Optional<Rider> rider = userRepository.findByRiderId(riderId);

        // Create a new Booking entity
        Booking booking = new Booking();
        booking.setRider(rider.get());
        booking.setStatus("scheduled");

        // Save the booking to the database
        Booking savedBooking = bookingRepository.save(booking);

        return savedBooking.getBookingId();
    }

    public void confirmRide(String riderId, String driverId, Long bookingId, String pickupLocation, String dropoffLocation) {
        // Retrieve the booking by ID
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));

        // Update the booking's state to "confirmed"
        booking.setStatus("confirmed");

        // Save the updated booking to the database
        bookingRepository.save(booking);

        // Create a ride entry only when the booking is confirmed
        if (booking.getStatus().equals("confirmed")) {
            // Create a new Ride entity and set ride details
            Ride ride = new Ride();
            Optional<Rider> rider = userRepository.findByRiderId(riderId);
            Optional<Driver> driver = userRepository.findByDriverId(driverId);
            ride.setRider(rider.get());
            ride.setDriver(driver.get());
            ride.setPickupLocation(pickupLocation);
            ride.setDropoffLocation(dropoffLocation);
            ride.setStatus("booked"); // You can set the initial status here

            // Save the ride to the database
            rideRepository.save(ride);
            // Update the booking's state to "confirmed"
            booking.setStatus("confirmed");

            // Save the updated booking to the database
            booking.setRide(ride);
            bookingRepository.save(booking);

        }
    }


// Method to cancel a ride
    public void cancelBooking(Long bookingId) {
        // Retrieve the ride by ID
        // Retrieve the booking associated with the ride
        Optional<Booking> booking = bookingRepository.findByBookingId(bookingId);
        // Update the booking's status to "canceled"
        if (booking.isPresent()) {
            booking.get().setStatus("canceled");
            bookingRepository.save(booking.get());
        }
        Ride ride = booking.get().getRide();
        // Update the ride's status to "canceled"
        ride.setStatus("canceled");

        // Save the updated ride to the database
        rideRepository.save(ride);
    }

    // Method to make a payment
    public void makePayment(Long bookingId, BigDecimal amount) {
        // Create a new Payment entity
        Optional<Booking> booking = bookingRepository.findByBookingId(bookingId);
        if(booking.isEmpty()){
            throw new RuntimeException("Booking is not found.");
        }
        Payment payment = new Payment();
        payment.setRide(booking.get().getRide());
        payment.setAmount(amount);
        booking.get().setPayment(payment);
        // Save the payment to the database
        paymentRepository.save(payment);
    }
        }
