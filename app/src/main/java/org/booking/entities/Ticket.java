package org.booking.entities;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTrivel;
    private Train train;

    public Ticket() {
    }

    public Ticket(String ticketId, String userId, String source, String destination, Date dateOfTrivel, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        source = source;
        destination = destination;
        this.dateOfTrivel = dateOfTrivel;
        this.train = train;
    }

    public String getTicketInfo() {
        return String.format("Ticket ID : %s belong to User %s from %s to %s on %s", ticketId, userId, source,destination,dateOfTrivel);
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        destination = destination;
    }

    public Date getDateOfTrivel() {
        return dateOfTrivel;
    }

    public void setDateOfTrivel(Date dateOfTrivel) {
        this.dateOfTrivel = dateOfTrivel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }


}
