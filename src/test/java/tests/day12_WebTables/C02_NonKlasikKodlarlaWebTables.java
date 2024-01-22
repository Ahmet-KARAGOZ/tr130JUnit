package tests.day12_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;
/*
1. “https://testotomasyonu.com/webtables2” sayfasina gidin
 2. Headers da bulunan basliklari yazdirin
 3. 3.sutunun basligini yazdirin
 4. Tablodaki tum datalari yazdirin
 5. Tabloda kac tane cell (data) oldugunu yazdirin
 6. Tablodaki satir sayisini yazdirin
 7. Tablodaki sutun sayisini yazdirin
 8. Tablodaki 3.kolonu yazdirin
 9. Tabloda ” Category” si Furniture olan urunun fiyatini yazdirin
10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

(//*[@role='trow']) / *[@role='tdata']


 */

public class C02_NonKlasikKodlarlaWebTables extends TestBase {
	@Test
	public void test01(){
		driver.get("https://testotomasyonu.com/webtables2");

		WebElement baslikSatirElementi = driver.findElement(By.xpath("//*[@role='hrow']"));
		System.out.println(baslikSatirElementi.getText());

		WebElement ucuncuSutunBaslikElementi = driver.findElement(By.xpath("(//*[@role='hdata'])[3]"));
		System.out.println(ucuncuSutunBaslikElementi.getText());

		List<WebElement> tumDatalar = driver.findElements(By.xpath("(//*[@role='tdata'])"));
		System.out.println(ReusableMethods.stringListeCevir(tumDatalar));

		System.out.println("Tablo DataSayisi : " + tumDatalar.size());

		List<WebElement> tumSatirlarElementi = driver.findElements(By.xpath("(//*[@role='trow'])"));
		System.out.println("Satır Sayısı : " + tumSatirlarElementi.size());

		//  (//*[@role='trow'])[2] / *[@role='tdata']

		List<WebElement> ikinciSatirElementleri = driver.findElements(By.xpath("(//*[@role='trow'])[2] / *[@role='tdata']"));
		System.out.println("Tablodaki Sütun Sayısı : " + ikinciSatirElementleri.size());

		List<WebElement> ucuncuSutunelementleri = driver.findElements(By.xpath("(//*[@role='trow'])/ *[@role='tdata'][3]"));
		System.out.println("Üçüncu sütün elementleri : "+ ReusableMethods.stringListeCevir(ucuncuSutunelementleri));

		// (//*[@role='trow'])[   5  ]/ *[@role='tdata'][2]    category
		// (//*[@role='trow'])[   5  ]/ *[@role='tdata'][3]    fiyat

		for (int i = 1; i <= tumSatirlarElementi.size() ; i++) {
			String dinamikCategoryXpath =  "(//*[@role='trow'])[   "+i+"  ]/ *[@role='tdata'][2]  ";
			String dinamikFiyatXpath = "(//*[@role='trow'])[   "+i+"  ]/ *[@role='tdata'][3]";

			WebElement satirdakiCategoryElementi = driver.findElement(By.xpath(dinamikCategoryXpath));
			WebElement sutundakiFiyatElementi = driver.findElement(By.xpath(dinamikFiyatXpath));

			if (satirdakiCategoryElementi.getText().equals("Furniture")){
				System.out.println(sutundakiFiyatElementi.getText());
			}
		}

		datayiYazdir(3,3);
		datayiYazdir(2,2);






	}
	//  (//*[@role='trow'])[   5  ]/ *[@role='tdata'][   2    ]
	public  void datayiYazdir(int satirNO, int sutunNo){
		String dinamikXpath = "(//*[@role='trow'])[   "+satirNO+"  ]/ *[@role='tdata'][   "+sutunNo+"    ] ";
		WebElement istenenElement = driver.findElement(By.xpath(dinamikXpath));
		System.out.println("İstenen Hücredeki Data : "+istenenElement.getText());
	}
}
