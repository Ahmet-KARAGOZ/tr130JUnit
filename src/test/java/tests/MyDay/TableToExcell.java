package tests.MyDay;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TableToExcell extends TestBase {
	@Test
	public void test01() throws IOException {
		driver.get("https://testotomasyonu.com/webtables2");
		List<WebElement> baslikBilgileriListesi = driver.findElements(By.xpath("//*[@role='hdata']"));
		//System.out.println(baslikBilgileriListesi.get(0).getText());

		//yukarıdan aşağıya ProductName listesi
		List<WebElement> productNameList = driver.findElements(By.xpath("(//*[@role='trow'])  / *[@role='tdata'][1]"));

		//category Listesi
		List<WebElement> categoryList = driver.findElements(By.xpath("(//*[@role='trow'])  / *[@role='tdata'][2]"));

		//Price Listesi
		List<WebElement> priceList = driver.findElements(By.xpath("(//*[@role='trow'])  / *[@role='tdata'][3]"));

		//Action Listesi
		List<WebElement> actionListesi = driver.findElements(By.xpath("(//*[@role='trow'])  / *[@role='tdata'][4]"));

		String dosyaYolu = "src/test/java/tests/MyDay/tabloExceli.xlsx";
		FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sayfa2 = workbook.getSheet("Sayfa2");


		//Header kısmındaki tablo başıklarını 0. satıra yanyana hücre oluşturarak yazdırıyoruz.
		sayfa2.createRow(0);
		for (int i = 0; i < baslikBilgileriListesi.size(); i++) {
			sayfa2.getRow(0).createCell(i).setCellValue(baslikBilgileriListesi.get(i).getText());

		}
		/*
		//Product Name leri yukarıdan aşağıya doğru her satıra 0. hücreyi oluşturarak yazıyoruz
		for (int i = 0; i < productNameList.size(); i++) {
			sayfa2.createRow(i + 1).createCell(0).setCellValue(productNameList.get(i).getText());
		}

		//Categoryleri her satıra indexi 1 olan hücreyi oluşturarak yazıyoruz.
		for (int i = 0; i < categoryList.size(); i++) {
			sayfa2.getRow(i + 1).createCell(1).setCellValue(categoryList.get(i).getText());
		}

		//Price List verilerini her satıra index i 2 olan hücreyi oluşturarak yazıyoruz.
		for (int i = 0; i < priceList.size(); i++) {
			sayfa2.getRow(i + 1).createCell(2).setCellValue(priceList.get(i).getText());
		}

		//Action listesini indexi 3 olan hücreyi oluşturarak yazıyoruz.
		for (int i = 0; i < actionListesi.size(); i++) {
			sayfa2.getRow(i + 1).createCell(3).setCellValue(actionListesi.get(i).getText());
		}
		 */

		for (int i = 0; i < productNameList.size(); i++) {
			sayfa2.createRow(i + 1).createCell(0).setCellValue(productNameList.get(i).getText());
			sayfa2.getRow(i + 1).createCell(1).setCellValue(categoryList.get(i).getText());
			sayfa2.getRow(i + 1).createCell(2).setCellValue(priceList.get(i).getText());
			sayfa2.getRow(i + 1).createCell(3).setCellValue(actionListesi.get(i).getText());
		}

		FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
		workbook.write(fileOutputStream);

		fileInputStream.close();
		fileOutputStream.close();
		workbook.close();


	}
}
