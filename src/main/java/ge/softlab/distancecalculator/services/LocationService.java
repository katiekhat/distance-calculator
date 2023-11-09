package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.DataHistory;

import java.util.List;

public interface LocationService {
    void updateLocation(double longitude, double latitude, String vehicleNumber);

    List<DataHistory> getAllHistoryData();
}
