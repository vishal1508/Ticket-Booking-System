package org.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Seat {
    @JsonProperty("seat_number")
    private String seatNumber; // e.g., "1A", "1B"
    @JsonProperty("is_booked")
    private boolean isBooked;
    @JsonProperty("booked_by_user_id")
    private String bookedByUserId;
    // ✅ Jackson needs this
    public Seat() {
    }
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.bookedByUserId = null;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book(String userId) {
        this.isBooked = true;
        this.bookedByUserId = userId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getBookedByUserId() {
        return bookedByUserId;
    }


    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }


    public void setBooked(boolean booked) {
        isBooked = booked;
    }


    public void setBookedByUserId(String bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
    }
    @Override
    public String toString() {
        if (isBooked) {
            return "[" + seatNumber + "❌]"; // booked
        } else {
            return "[" + seatNumber + "✅]"; // available
        }
    }
}
