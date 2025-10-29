package org.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.booking.entities.Train;
import org.booking.entities.User;
import org.booking.utils.UserServiceUtil;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingServices {

    private User user1;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "/Users/vishalrajendrakerlekar/Documents/IRCTC/app/src/main/java/org/booking/localDB/users.json";

    public UserBookingServices(User user) throws IOException {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        this.user1 = user;
        this.userList = loadUser();
    }

    public UserBookingServices() throws IOException {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        this.userList = loadUser();
    }

    public List<User> loadUser() throws IOException {
        File users = new File(USERS_PATH);
        return (objectMapper.readValue(users, new TypeReference<List<User>>() {
        }));
    }

    public Boolean loginUser() {
        Optional<User> foundUSer = userList.stream().filter(user -> {
            return user.getName().equals(user1.getName()) && UserServiceUtil.checkPassword(user1.getPassword(), user.getHashPassword());
        }).findFirst();
        return foundUSer.isPresent();
    }

    public Boolean signUp(User user) {
        try {
            Boolean isUserMatch = userList.stream().anyMatch(usr -> usr.getName().equals(user.getName()));
            if (isUserMatch) {
                return Boolean.FALSE;
            }
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;

        } catch (Exception e) {
            System.out.println(e);
            return Boolean.FALSE;
        }

    }

    private void saveUserListToFile() throws IOException {
        File userFile = new File(USERS_PATH);
        objectMapper.writeValue(userFile, userList);
    }

    public void fetchBooking() {
        user1.printTickets();
    }

    public Boolean cancelBooking(String ticketId) {
        return Boolean.FALSE;
    }

    public List<Train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrain(source, destination);
        } catch (IOException e) {
            System.out.println(e);
            return new ArrayList<Train>();
        }
    }
}
