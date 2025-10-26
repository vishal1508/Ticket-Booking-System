package org.booking.entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private Date dateOfDeparture;
    private Date dateOfArrival;

    private List<List<Integer>> seats;

    private Map<String, Time> station;
}
