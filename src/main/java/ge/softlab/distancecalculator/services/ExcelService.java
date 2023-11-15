package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.Data;
import ge.softlab.distancecalculator.repositories.DataRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExcelService {
    private final DataRepository dataRepository;
    public List<Data> readExcelFile(InputStream inputStream) throws IOException {
        List<Data> dataList = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Data data = new Data();
                data.setLatitude(row.getCell(0).getNumericCellValue());
                data.setLongitude(row.getCell(1).getNumericCellValue());
                data.setVehicleNumber(row.getCell(2).getStringCellValue());
                dataList.add(data);
            }
        }

        return dataList;
    }
}

