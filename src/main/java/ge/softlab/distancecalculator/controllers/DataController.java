package ge.softlab.distancecalculator.controllers;

import ge.softlab.distancecalculator.entities.Data;
import ge.softlab.distancecalculator.services.DataService;
import ge.softlab.distancecalculator.services.ExcelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/excel")
public class DataController {

    private final ExcelService excelService;
    private final DataService dataService;


    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("select an Excel file to upload.");
        }

        try {
            List<Data> dataList = excelService.readExcelFile(file.getInputStream());
            dataService.saveDataToDatabase(dataList);

            return ResponseEntity.status(HttpStatus.OK).body("File uploaded and data saved to the database.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the file.");
        }
    }

    @GetMapping("/calculate")
    public ResponseEntity<List<Data>> calculateDistance(@RequestParam("latitude")double latitude, @RequestParam("longitude")double longitude){
        List<Data> dataList = dataService.getData();
        for (Data data : dataList) {
            double distance = calculateHaversineDistance(
                    latitude, longitude, data.getLatitude(), data.getLongitude()
            );
            data.setDistance(distance);
        }
        dataList.sort(Comparator.comparingDouble(Data::getDistance));
        return new ResponseEntity<>(dataList, HttpStatus.OK);




    }

    private double calculateHaversineDistance (double lat1, double lon1, double lat2, double lon2){
            // degrees to radians
            lon1 = Math.toRadians(lon1);
            lon2 = Math.toRadians(lon2);
            lat1 = Math.toRadians(lat1);
            lat2 = Math.toRadians(lat2);

            // Haversine formula
            double dlon = lon2 - lon1;
            double dlat = lat2 - lat1;
            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(lat1) * Math.cos(lat2)
                    * Math.pow(Math.sin(dlon / 2),2);

            double c = 2 * Math.asin(Math.sqrt(a));

            // Radius of earth in kilometers.
            double r = 6371;

            // calculate the result
            return(c * r);

        }
    }





