package Generic_Utilities;
/**
 * This class related to generic method from property file
 * @author dipta
 */
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel file and return value to the caller
	 * @param sheetname
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ReadDataExcel (String sheetname,int row, int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String val = book.getSheet(sheetname).getRow(row).getCell(cel).getStringCellValue();
		return val;
	}

}
