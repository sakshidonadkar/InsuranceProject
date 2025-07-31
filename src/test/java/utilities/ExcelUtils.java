package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

	@DataProvider(name = "PlanData")
	public static Object[][] getFlightData() throws IOException {
		String filePath = "testData/TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(1);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][colCount];
        DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				//if (j > 1 && j < 6) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = formatter.formatCellValue(cell);
			}
		}

		workbook.close();
		fis.close();
		return data;
	}
}
