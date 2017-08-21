package application.model;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javafx.scene.control.TableView;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class SavedExcelData {

  private WritableCellFormat timesBoldUnderline;
  private WritableCellFormat times;
  private WritableCellFormat times1;
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
  Date date = new Date();
  String currentDate = dateFormat.format(date);
  



  public void write2(TableView<Spot> releaseTable) throws IOException, WriteException {

	   File file = new File("ReleasedData.xls");
	   JFileChooser fileChooser = new JFileChooser();
	   fileChooser.setDialogTitle("Specify a file to save"); 
	   fileChooser.setSelectedFile(file);	    
	   int userSelection = fileChooser.showSaveDialog(null);
	   if (userSelection == JFileChooser.APPROVE_OPTION) {
	        file = fileChooser.getSelectedFile();
	   }
	   

	    WorkbookSettings wbSettings = new WorkbookSettings();
	    wbSettings.setLocale(new Locale("en", "EN"));
	    
	    
	    
	    WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
	    workbook.createSheet("SEDO OUTPUT", 0);
	    WritableSheet excelSheet = workbook.getSheet(0);
	    
	   
	    
	    WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
	    WritableFont times13pt = new WritableFont(WritableFont.TIMES, 13);
	
	    // Define the cell format
	    times = new WritableCellFormat(times12pt);
	    times.setWrap(true);
	    times .setAlignment(jxl.format.Alignment.CENTRE);
	    times .setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
	    times .setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
	    times.setBackground(jxl.format.Colour.GRAY_25);
	    
	    times1 = new WritableCellFormat(times13pt);
	    times1.setWrap(true);
	    times1 .setAlignment(jxl.format.Alignment.CENTRE);
	    times1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
	    times1 .setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
	    times1.setBackground(jxl.format.Colour.GREY_40_PERCENT);
	    
	   
	   
	  
	    
	    // create create a bold font with unterlines
	    WritableFont times12ptBoldUnderline = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD, false,
	        UnderlineStyle.SINGLE);
	    timesBoldUnderline = new WritableCellFormat(times12ptBoldUnderline);
	    // Lets automatically wrap the cells
	    
	    

	    CellView cv = new CellView();
	    cv.setFormat(times);
	    cv.setFormat(timesBoldUnderline);
	    cv.setFormat(times1);
	    
	    

	    int col0 = 0;
	    int widthInChars0 = 12;
	    
	    int col1 = 1;
	    int widthInChars1 = 10;
	    
	    int col2 = 2;
	    int widthInChars2 = 10;
	    
	    int col3 = 3;
	    int widthInChars3 = 14;
	    
	    int col4 = 4;
	    int widthInChars4 = 14;
	    
	    int col5 = 5;
	    int widthInChars5 = 14;
	    
	    int col6 = 6;
	    int widthInChars6 = 13;
	    
	    int col7 = 7;
	    int widthInChars7 = 16;
	    
	    int col8 = 8;
	    int widthInChars8 = 12;
	    
	    int col9 = 9;
	    int widthInChars9 = 12;
	    
	    int col10 = 10;
	    int widthInChars10 = 15;
	    
	    int col11 = 11;
	    int widthInChars11 = 20;
	   
		      
		int row0 = 0;
	    int rowhight0 = 2200;
	    
	    
	    
	    excelSheet.setColumnView(col0, widthInChars0);
	    excelSheet.setRowView(row0, rowhight0);
	    excelSheet.setColumnView(col1, widthInChars1);
	    excelSheet.setColumnView(col2, widthInChars2);
	    excelSheet.setColumnView(col3, widthInChars3);
	    excelSheet.setColumnView(col4, widthInChars4);
	    excelSheet.setColumnView(col5, widthInChars5);
	    excelSheet.setColumnView(col6, widthInChars6);
	    excelSheet.setColumnView(col7, widthInChars7);
	    excelSheet.setColumnView(col8, widthInChars8);
	    excelSheet.setColumnView(col9, widthInChars9);
	    excelSheet.setColumnView(col10, widthInChars10);
	    excelSheet.setColumnView(col11, widthInChars11);

	    // Write a few headers
	    addCaption1(excelSheet, 0, 0, "Date");
	    addCaption1(excelSheet, 1, 0, "Aircraft");
	    addCaption1(excelSheet, 2, 0, "FLIGHT\nNumber");
	    addCaption1(excelSheet, 3, 0, "Aircraft Identificaton Number");
	    addCaption1(excelSheet, 4, 0, "Type 1 Freez Point Type 4 % of Mixture");
	    addCaption1(excelSheet, 5, 0, "Final Step Type Fluid Used Type 1 Type 4");
	    addCaption1(excelSheet, 6, 0, "Final Fluid Application Start Time");
	    addCaption1(excelSheet, 7, 0, "Aircraft Specific Check Accomplished");
	    addCaption1(excelSheet, 8, 0, "Employee Completed Post Check");
	    addCaption1(excelSheet, 9, 0, "Spot");
	    addCaption1(excelSheet, 10, 0, "Release Time");
	    

	    for (int i = 0 ; i < releaseTable.getItems().size(); i++) {
	    	
	    	
	    	
	    	//SavedFlightData item = existingdata.get(i);
	    	
	    	addCaption(excelSheet, 0, i+1, dateFormat.format(date));	
	    	addCaption(excelSheet, 1, i+1, releaseTable.getItems().get(i).getFlight().getAircraftType());
	    	addCaption(excelSheet, 2, i+1, releaseTable.getItems().get(i).getFlight().getFlightNumber());
	    	addCaption(excelSheet, 3, i+1, releaseTable.getItems().get(i).getFlight().getTailNumber());
	    	addCaption(excelSheet, 4, i+1, releaseTable.getItems().get(i).getDeicing().getFluidType());
	    	addCaption(excelSheet, 5, i+1, releaseTable.getItems().get(i).getDeicing().getFluidType());
	    	addCaption(excelSheet, 6, i+1, releaseTable.getItems().get(i).getDeicing().getStartTime());
	    	addCaption(excelSheet, 7, i+1, releaseTable.getItems().get(i).getDeicing().getAircraftCheck());
	    	addCaption(excelSheet, 8, i+1, releaseTable.getItems().get(i).getSprayer1());
	    	addCaption(excelSheet, 9, i+1, releaseTable.getItems().get(i).getSpotNumber());
	    	addCaption(excelSheet, 10, i+1, releaseTable.getItems().get(i).getDeicing().getEndTime());
	   
	    	
	    }
	    
	    
	  
	    
	    
	    workbook.write();
	    workbook.close();
	    

	    
	  }
  




  

  

  private void addCaption(WritableSheet excelSheet, int column, int row, String s)
      throws RowsExceededException, WriteException {
    Label label;
    
    label = new Label(column, row, s,times);
    excelSheet.addCell(label);
  }
  
  private void addCaption1(WritableSheet excelSheet, int column, int row, String s)
	      throws RowsExceededException, WriteException {
	    Label label;
	    
	    label = new Label(column, row, s,times1);
	    excelSheet.addCell(label);
	  }




}