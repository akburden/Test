import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelReader {

    public static Map<String, ArrayList<String>> read(String filename) throws IOException {

        FileInputStream fis = new FileInputStream(new File(filename));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
        ArrayList<String> headers = new ArrayList<String>();
        ArrayList<ArrayList<String>> pureData = new ArrayList<ArrayList<String>>();
        for (Cell cell : rows.next()) {
            headers.add(cell.getStringCellValue());
            pureData.add(new ArrayList<String>());
        }

        while (rows.hasNext()) {
            Iterator<Cell> cellIterator = rows.next().cellIterator(); {
                int i = 0;
                while (cellIterator.hasNext()){
                    pureData.get(i).add(cellIterator.next().getStringCellValue());
                }
            }
        }
        int i = 0;
        for(String header: headers){
            data.put(header, pureData.get(i));
        }
        return data;
    }
}
