package by.serialnumber.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import by.serialnumber.dao.BasicDao;
import by.serialnumber.domain.entity.Product;

public class DaoExcell implements BasicDao {
	
	private static final String FILE_BASE = "d:/jd1/SerialNumber/xlsx/base.xls";
	private static final String SHEET_BASE = "base";

	@Override
	public List<Product> readProductsList() {
		List<Product> list = new ArrayList<Product>();
		HSSFWorkbook book = null;
		try {
			
			//TODO to add check for file exists
			
			FileInputStream fis = new FileInputStream( FILE_BASE );
			book = new HSSFWorkbook( fis );
			//System.out.println( "book: " + book.toString() );
			HSSFSheet sheet = book.getSheet( SHEET_BASE );
			int rowCount = sheet.getLastRowNum();
			
			for ( int i = 0; i < rowCount; i++ ) {
				HSSFRow row = sheet.getRow( i );
				if ( row != null ) {
					Product product = null;
					String title = row.getCell( 0 ).getStringCellValue();
					String serial = row.getCell( 1 ).getStringCellValue();
					if ( title != null && serial != null ) {
						product = new Product( title, serial );
						list.add( product );
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				book.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/*private List<String> fakeList() {
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("234");
		list.add("345");
		list.add("456");
		list.add("567");
		list.add("678");
		list.add("789");
		return list;
	}*/

}
