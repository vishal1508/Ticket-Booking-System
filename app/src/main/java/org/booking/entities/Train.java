package org.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Train {
    private String trainId;
    private String trainNo;
    private Map<String, String> stationTimes;
    private List<String> stations;
    private Seat[][] seats;
    private transient int[][] seatNumbers;
    public Train() {
    }

    public Train(String trainId, String trainNo, Map<String, String> stationTimes, List<String> stations,int rows,int cols) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.stationTimes = stationTimes;
        this.stations = stations;
        this.seats = new Seat[rows][cols];

        // Create seat numbers like 1A, 1B, 1C...
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char colLetter = (char) ('A' + j);
                String seatNumber = (i + 1) + String.valueOf(colLetter);
                seats[i][j] = new Seat(seatNumber);
            }
        }
    }

    public String getTrainId() {
        return this.trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public Map<String, String> getStationTimes() {
        return stationTimes;
    }

    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public void showSeats() {
        System.out.println("\n🚆 Seat Map for Train " + trainId + ":");
        for (Seat[] row : seats) {
            for (Seat s : row) {
                System.out.print(s.toString() + " ");
            }
            System.out.println();
        }
    }
    public void bookSeat(String seatNumber, String userId) {
        for (Seat[] row : seats) {
            for (Seat s : row) {
                if (s.getSeatNumber().equalsIgnoreCase(seatNumber)) {
                    if (!s.isBooked()) {
                        s.setBooked(true);
                        s.setBookedByUserId(userId);
                        System.out.println("✅ Seat " + seatNumber + " booked for " + userId);
                    } else {
                        System.out.println("❌ Already booked by " + s.getBookedByUserId());
                    }
                    return;
                }
            }
        }
        System.out.println("⚠️ Seat not found: " + seatNumber);
    }

    public String getTrainInfo() {
        return String.format("Train Id : %s Train No. %s", this.trainId, this.trainNo);
    }
}
