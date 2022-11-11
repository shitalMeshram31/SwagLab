package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {

	public static String getExcelData(String Sheetname,int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream("D:\\velocity\\SwagLabs\\src\\test\\resources\\TestData.xlsx");
	String value = WorkbookFactory.create(file).getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
	}
}
