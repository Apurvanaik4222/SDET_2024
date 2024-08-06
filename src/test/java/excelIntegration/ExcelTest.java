package excelIntegration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelTest {


    @Test(dataProvider = "getData")
    public void excelTest1(String id,String name,String location){
        System.out.println(id + " "+ name +" "+location);


    }
@DataProvider
    public Object[][] getData() throws IOException {

        DataFormatter formatter =new DataFormatter();
        FileInputStream fis =new FileInputStream("C:\\Users\\91762\\IdeaProjects\\SDET_2024\\excelDempTest.xlsx");
        XSSFWorkbook workbook =new XSSFWorkbook(fis);
        XSSFSheet sheet =workbook.getSheetAt(0);
       int rowCount = sheet.getPhysicalNumberOfRows();
       XSSFRow row =sheet.getRow(0);
      int columCount = row.getLastCellNum();

      Object [][] data =new Object[rowCount-1][columCount];

      for (int i=0;i<rowCount-1;i++){

        row =  sheet.getRow(i+1);

          for (int j=0;j<columCount;j++){
             XSSFCell cell = row.getCell(j);
             data[i][j] =formatter.formatCellValue(cell);


          }
      }
      return data;
    }
}
