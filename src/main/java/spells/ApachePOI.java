package spells;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOI {

    public static final String SAMPLE_XLSX_FILE_PATH = "D:\\Pasta1.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        FileInputStream file = new FileInputStream(SAMPLE_XLSX_FILE_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFCreationHelper creationHelper = workbook.getCreationHelper();
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        workbook.forEach(sheet -> System.out.println(sheet.getSheetName()));
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell x : row) {
                XSSFHyperlink oldValue = (XSSFHyperlink) x.getHyperlink();
                System.out.println(oldValue.getAddress());
                Cell cell = row.createCell(x.getColumnIndex());
                XSSFHyperlink newValue = creationHelper.createHyperlink(HyperlinkType.FILE);
                newValue.setAddress("D:/Codes");
                cell.setHyperlink(newValue);
            }
        }

        file.close();
        FileOutputStream outFile =new FileOutputStream(new File(SAMPLE_XLSX_FILE_PATH));
        workbook.write(outFile);
        outFile.close();
    }
}
