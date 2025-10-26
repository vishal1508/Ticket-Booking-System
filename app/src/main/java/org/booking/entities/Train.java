package org.booking.entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private Map<String, String> stationTimes;
    private List<String> stations;
    private List<List<Integer>> seats;

    public Train() {
    }

    public Train(String trainId, String trainNo, Map<String, String> stationTimes, List<String> stations, List<List<Integer>> seats) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.stationTimes = stationTimes;
        this.stations = stations;
        this.seats = seats;
    }

    public String getTrainId() {
        return trainId;
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

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public String getTrainInfo(){
        return String.format("Train Id : %s Train No. %s",this.trainId,this.trainNo);
    }
}
