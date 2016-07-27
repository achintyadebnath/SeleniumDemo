package Hello;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class MercuryTours_Login {

	public void readExcel() throws Exception {
		
		Workbook wb = Workbook.getWorkbook(new File("C:/Selenium/MercuryTours.xls"));
		Sheet s1 = wb.getSheet("Login");
		
		int totalrows = s1.getRows();
		int totalcols = s1.getColumns();
		
		for(int row=0;row<totalrows;row++){
			
			for(int col=0;col<totalcols;col++){
				
				System.out.println(s1.getCell(col, row).getContents());
			}
			
			System.out.println("\t");
		}
	}

	public static void main(String args[]) throws Exception {
		MercuryTours_Login mylogin = new MercuryTours_Login();
		mylogin.readExcel();
	}
}