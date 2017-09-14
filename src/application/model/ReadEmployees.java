package application.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadEmployees {

	
	public ObservableList<String> readEmployeesFromExcel() {
		ObservableList<String> employees = FXCollections.observableArrayList();
		String firstName = "";
		String lastName = "";
		String nNumber = "";
		

		
		
		

		try {
			FileInputStream excelFile = new FileInputStream(new File("EMPLOYEE-UPLOAD.xlsx"));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			Iterator<Row> iterator = datatypeSheet.iterator();
			Row currentRow = iterator.next();


			for (int rowIndex = 1; rowIndex <= datatypeSheet.getLastRowNum(); rowIndex++) 
			{
				currentRow = datatypeSheet.getRow(rowIndex);
				if (currentRow != null) {
					Cell firstNameCell = currentRow.getCell(0);
					Cell lastNameCell = currentRow.getCell(1);
					Cell nNumberCell = currentRow.getCell(2);
					firstName = formatter.formatCellValue(firstNameCell);
					lastName = formatter.formatCellValue(lastNameCell);
					nNumber = formatter.formatCellValue(nNumberCell);
					//s2[rowIndex] = firstname.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
							//+ nNumber.getStringCellValue().toString();
					
					//employees.add(firstNameCell.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
							//+ nNumber.getStringCellValue().toString());
					
					employees.add(firstName + " " + lastName + " "
							+ nNumber);

				}
			}
		} catch (Exception e) {
System.out.print(e.toString());		}
		return employees;

	}

}
