package org.booking.entities;

import java.util.List;

public class User {

    private String userId;
    private String name;
    private String password;
    private String hashPassword;
    private List<Ticket> ticketbooked;

    public User(String name, String password, String hashPassword, List<Ticket> ticketbooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.ticketbooked = ticketbooked;
        this.userId = userId;
    }

    public void printTickets() {
        for (int i = 0; i < ticketbooked.size(); i++) {
            System.out.println(ticketbooked.get(i).getTicketInfo());
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public List<Ticket> getTicketbooked() {
        return ticketbooked;
    }

    public String getUserId() {
        return userId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setTicketbooked(List<Ticket> ticketbooked) {
        this.ticketbooked = ticketbooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
