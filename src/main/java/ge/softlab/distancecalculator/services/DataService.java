package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.Data;
import ge.softlab.distancecalculator.repositories.DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataService {
    private final DataRepository dataRepository;


    public void saveDataToDatabase(List<Data> dataList) {
        this.dataRepository.saveAll(dataList);
    }


    public List<Data> getData() {
        return dataRepository.findAll();
    }
}
