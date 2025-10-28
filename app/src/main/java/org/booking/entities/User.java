package org.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String userId;
    private String name;
    private String password;
    private String hashPassword;
    private List<Ticket> ticketbooked;
    public User(){};
    public User(String name, String password, String hashPassword, List<Ticket> ticketbooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.ticketbooked = ticketbooked;
        this.userId = userId;
    }

    public void printTickets() {
        System.out.println(ticketbooked.size());
        for (int i = 0; i < ticketbooked.size(); i++) {
            System.out.println(ticketbooked.size());
            System.out.println(ticketbooked.get(i).getTicketInfo());
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getHashPassword() {
        return this.hashPassword;
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
