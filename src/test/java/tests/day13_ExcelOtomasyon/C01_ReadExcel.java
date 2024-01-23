package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
7. Dosya yolunu bir String degiskene atayalim
8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
10. WorkbookFactory.create(fileInputStream)
11. Worksheet objesi olusturun workbook.getSheetAt(index)
12. Row objesi olusturun sheet.getRow(index)
13. Cell objesi olusturun row.getCell(index)
 */

public class C01_ReadExcel  {
	@Test
	public void readExcelTest() throws IOException {
		String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
		FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sayfa1 = workbook.getSheet("Sayfa1");
		Row row = sayfa1.getRow(7); //index kullanır 0 'dan başlarlar
		Cell cell = row.getCell(1);  //index kullanır 0 'dan başlarlar

		System.out.println(cell);



	}
}
