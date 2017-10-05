package application.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadFlights {
	public ArrayList<Flight> readFlightsFromExcel2() {
		
		ArrayList<Flight> flights = new ArrayList<Flight>();
			try {
				FileInputStream excelFile = new FileInputStream(new File("FLIGHTS-UPLOAD.xlsx"));
				Workbook workbook = new XSSFWorkbook(excelFile);
				Sheet datatypeSheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter();
				Iterator<Row> iterator = datatypeSheet.iterator();
				Row currentRow = iterator.next();


				for (int rowIndex = 1; rowIndex <= datatypeSheet.getLastRowNum(); rowIndex++) 
				{
					currentRow = datatypeSheet.getRow(rowIndex);
					if (currentRow != null) {
						Cell flightNumberCell = currentRow.getCell(0);
						Cell tailNumberCell = currentRow.getCell(1);
						Cell aircraftTypeCell = currentRow.getCell(2);
						Cell carrierCell = currentRow.getCell(3);
						
		                
		                
		                Flight f = new Flight();
		                
						f.setFlightNumber(formatter.formatCellValue(flightNumberCell));
						f.setTailNumber(formatter.formatCellValue(tailNumberCell));
						f.setAircraftType(formatter.formatCellValue(aircraftTypeCell));
						f.setCarrier(formatter.formatCellValue(carrierCell));
						flights.add(f);

					}
				}
			} catch (Exception e) {
	System.out.print(e.toString());		}
			return flights;

		}
		
		
		

	public ObservableList<String> readFlightsFromExcel() {
		ObservableList<String> flights = FXCollections.observableArrayList();
		 String flightNumber;
		 String tailNumber;
		 String aircraftType;
		 String carrier;
		

		
		
		

		try {
			FileInputStream excelFile = new FileInputStream(new File("FLIGHTS-UPLOAD.xlsx"));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			Iterator<Row> iterator = datatypeSheet.iterator();
			Row currentRow = iterator.next();


			for (int rowIndex = 1; rowIndex <= datatypeSheet.getLastRowNum(); rowIndex++) 
			{
				currentRow = datatypeSheet.getRow(rowIndex);
				if (currentRow != null) {
					Cell flightNumberCell = currentRow.getCell(0);
					Cell tailNumberCell = currentRow.getCell(1);
					Cell aircraftTypeCell = currentRow.getCell(2);
					Cell carrierCell = currentRow.getCell(3);
					flightNumber = formatter.formatCellValue(flightNumberCell);
					tailNumber = formatter.formatCellValue(tailNumberCell);
					aircraftType = formatter.formatCellValue(aircraftTypeCell);
					carrier = formatter.formatCellValue(carrierCell);
					//s2[rowIndex] = firstname.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
							//+ nNumber.getStringCellValue().toString();
					
					//employees.add(firstNameCell.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
							//+ nNumber.getStringCellValue().toString());
					
					flights.add("FLIGHT:"+flightNumber + "\nTAIL:" + tailNumber + "\nA/c:"
							+ aircraftType + "\nCarrier:"+carrier);

				}
			}
		} catch (Exception e) {
System.out.print(e.toString());		}
		return flights;

	}
	
	
	
	public ObservableList<Flight> readFlightsFromExcel3() {
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		
			try {
				FileInputStream excelFile = new FileInputStream(new File("FLIGHTS-UPLOAD.xlsx"));
				Workbook workbook = new XSSFWorkbook(excelFile);
				Sheet datatypeSheet = workbook.getSheetAt(0);
				DataFormatter formatter = new DataFormatter();
				Iterator<Row> iterator = datatypeSheet.iterator();
				Row currentRow = iterator.next();


				for (int rowIndex = 1; rowIndex <= datatypeSheet.getLastRowNum(); rowIndex++) 
				{
					currentRow = datatypeSheet.getRow(rowIndex);
					if (currentRow != null) {
						Cell flightNumberCell = currentRow.getCell(0);
						Cell tailNumberCell = currentRow.getCell(1);
						Cell aircraftTypeCell = currentRow.getCell(2);
						Cell carrierCell = currentRow.getCell(3);
						
		                Flight f = new Flight();
		                
		                
		                
						f.setFlightNumber(formatter.formatCellValue(flightNumberCell));
						f.setTailNumber(formatter.formatCellValue(tailNumberCell));
						f.setAircraftType(formatter.formatCellValue(aircraftTypeCell));
						f.setCarrier(formatter.formatCellValue(carrierCell));
						flights.add(f);
						//s2[rowIndex] = firstname.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
								//+ nNumber.getStringCellValue().toString();
						
						//employees.add(firstNameCell.getStringCellValue().toString() + " " + lastName.getStringCellValue().toString() + " "
								//+ nNumber.getStringCellValue().toString());
						
						//flights.add("FLIGHT: "+f.getFlightNumber() + "\nTAIL: " + f.getTailNumber() + "\nA/c: "
								//+ f.getAircraftType() + "\nCarrier: "+f.getCarrier());

					}
				}
			} catch (Exception e) {
	System.out.print(e.toString());		}
			return flights;

		}
	
	
	
	
	

}
