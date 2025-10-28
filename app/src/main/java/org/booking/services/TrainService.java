package org.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.booking.entities.Train;
import org.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {
    private Train train;
    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAINS_PATH = "/Users/vishalrajendrakerlekar/Documents/IRCTC/app/src/main/java/org/booking/localDB/trains.json";

    public TrainService() throws IOException {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        loadTrains();
    }

    public TrainService(Train train) throws IOException{
        this.train = train;
        loadTrains();
    }
    public void loadTrains() throws IOException {
        File trains = new File(TRAINS_PATH);
        trainList = (objectMapper.readValue(trains, new TypeReference<List<Train>>() {
        }));
    }
    public List<Train> searchTrain(String source, String destination) {
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    public Boolean validTrain(Train train, String source, String destination) {
        List<String> stationOrder = train.getStations();
        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }

}
