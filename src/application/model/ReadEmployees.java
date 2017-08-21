package application.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadEmployees {

	
	public ObservableList<String> readEmployeesFromExcel() {
		ObservableList<String> employees = FXCollections.observableArrayList();
		

		
		

		try {
			FileInputStream excelFile = new FileInputStream(new File("EMPLOYEE-UPLOAD.xlsx"));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			Row currentRow = iterator.next();


			for (int rowIndex = 1; rowIndex <= datatypeSheet.getLastRowNum(); rowIndex++) 
			{
				currentRow = datatypeSheet.getRow(rowIndex);
				if (currentRow != null) {
					Cell firstname = currentRow.getCell(0);
					Cell lastName = currentRow.getCell(1);
					Cell nNumber = currentRow.getCell(2);
					//s2[rowIndex] = firstname.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
							//+ nNumber.getStringCellValue().toString();
					
					employees.add(firstname.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
							+ nNumber.getStringCellValue().toString());

				}
			}
		} catch (Exception e) {
System.out.print(e.toString());		}
		return employees;

	}

}
