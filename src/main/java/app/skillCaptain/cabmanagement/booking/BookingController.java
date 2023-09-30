package app.skillCaptain.cabmanagement.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // API to book a ride
    @PostMapping("/book-ride")
    public ResponseEntity<String> bookRide(@RequestBody BookingRequest bookingRequest) {
        try {
            Long bookingId = bookingService.bookRide(bookingRequest.getRiderId());
            return ResponseEntity.status(HttpStatus.CREATED).body("Ride booked successfully. Booking ID: " + bookingId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to book the ride: " + e.getMessage());
        }
    }

    @PostMapping("/confirm-ride")
    public ResponseEntity<String> confirmRide(@RequestParam String riderId, @RequestParam String driverId, @RequestParam Long bookingId, @RequestParam String pickupLocation, @RequestParam String dropoffLocation) {
        try {
            bookingService.confirmRide(riderId, driverId, bookingId, pickupLocation, dropoffLocation);
            return ResponseEntity.status(HttpStatus.OK).body("Ride confirmed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to confirm the ride: " + e.getMessage());
        }
    }


    // API to cancel a ride
    @PostMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> cancelRide(@PathVariable Long bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return ResponseEntity.status(HttpStatus.OK).body("Ride canceled successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to cancel the ride: " + e.getMessage());
        }
    }

    // API to make a payment
    @PostMapping("/make-payment/{bookingId}")
    public ResponseEntity<String> makePayment(@PathVariable Long bookingId, @RequestBody PaymentRequest paymentRequest) {
        try {
            bookingService.makePayment(bookingId, paymentRequest.getAmount());
            return ResponseEntity.status(HttpStatus.OK).body("Payment made successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to make the payment: " + e.getMessage());
        }
    }
}
