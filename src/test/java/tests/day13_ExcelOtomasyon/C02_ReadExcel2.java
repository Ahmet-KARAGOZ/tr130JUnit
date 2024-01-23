package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
/*
- 1.satirdaki 2.hucreye gidelim ve yazdiralim
 - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
 - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
 - Satir sayisini bulalim
 - Fiziki olarak kullanilan satir sayisini bulun
 - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
 */

public class C02_ReadExcel2 {
	@Test
	public void readExcelTEsti() throws IOException {
		String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
		FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sayfa1 = workbook.getSheet("Sayfa1");

		System.out.println(sayfa1.getRow(0).getCell(1));
		String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
		System.out.println(istenenHucre);

		String expHucreDegeri = "Kabil";
		String actHucreDegeri = sayfa1.getRow(1).getCell(3).toString();

		Assert.assertEquals(expHucreDegeri,actHucreDegeri);

		System.out.println(sayfa1.getLastRowNum());  //son satır index degerini verir.

		System.out.println(sayfa1.getPhysicalNumberOfRows()); // görülen reel olarak görünen satır sayısını verir.

		Sheet sayfa2 = workbook.getSheet("Sayfa2");
		System.out.println(sayfa2.getLastRowNum()); //son kullanılan satır indexi
		System.out.println(sayfa2.getPhysicalNumberOfRows()); // kullnılan satır sayısını verir boşları saymaz.
		//System.out.println(sayfa2.getRow(45).getCell(1)); // Null Pointer verir. woekbook Kullnılan satır kadar hafızaya alır.

		//System.out.println(sayfa2.getRow(2).getCell(45)); //Null verir wn son kullanılan sütundab sonrasını workbook belleğe almıyor.
		// Fiziki olarak kullanılmayan satırlarda Exception, kullanılan satırlarda null değerini verir.
		boolean polandVarMi = false;
		for (int i = 0; i < sayfa1.getLastRowNum(); i++) {
			String satirdakiIngUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
			if (satirdakiIngUlkeIsmi.equalsIgnoreCase("Poland")){
				polandVarMi=true;
			}
		}
		Assert.assertTrue(polandVarMi);

		for (int i = 0; i < sayfa2.getLastRowNum(); i++) {
			String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
			String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

			if (satirdakiUlkeIsmi.equalsIgnoreCase("Samoa")){
				Assert.assertEquals("Apia",satirdakiBaskentIsmi);
			}

		}

		//Map e çevirme
		Map<String,String> ulkelerVeBaskentler = new TreeMap<>();

		for (int i = 0; i < sayfa1.getLastRowNum(); i++) {
			String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
			String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

			ulkelerVeBaskentler.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);

		}
		//Poland va mı
		Assert.assertTrue(ulkelerVeBaskentler.containsKey("Poland"));

		Assert.assertEquals("Apia",ulkelerVeBaskentler.get("Samoa"));




	}
}
