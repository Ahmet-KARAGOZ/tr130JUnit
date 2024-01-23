package tests.MyDay;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class M03_Tables extends TestBase {
	@Test
	public void test01() {

//1. “https://demoqa.com/webtables” sayfasina gidin
		driver.get("https://demoqa.com/webtables");
//2. Headers da bulunan basliklari yazdirin
		WebElement headerYazi = driver.findElement(By.xpath("//*[@class='rt-thead -header']"));
		System.out.println(headerYazi.getText());
		System.out.println("-----------------------------------------------------------------");
//3. 3.sutunun basligini yazdirin
		WebElement ucuncuSutunBasligi = driver.findElement(By.xpath("(//*[@role='columnheader'])[3]"));
		System.out.println(ucuncuSutunBasligi.getText());
		System.out.println("-----------------------------------------------------------------");
//4. Tablodaki tum datalari yazdirin
		WebElement tumTabloBilgileri = driver.findElement(By.xpath("//*[@class='rt-table']"));
		System.out.println(tumTabloBilgileri.getText());
		System.out.println("-----------------------------------------------------------------");


//6. Tablodaki satir sayisini yazdirin
		List<WebElement> satirlar = driver.findElements(By.xpath("//*[@role='rowgroup']"));
		System.out.println("Tablo satır sayısı : " + satirlar.size());
		System.out.println("-----------------------------------------------------------------");

//7. Tablodaki sutun sayisini yazdirin
		List<WebElement> sutunlar = driver.findElements(By.xpath("(//*[@role='rowgroup'] ) [1] // *[@role='gridcell']"));
		System.out.println("Tablo sütun sayısı : " + sutunlar.size());
		System.out.println("-----------------------------------------------------------------");


		//5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

		//  (//*[@role='rowgroup'] ) [  2  ] // *[@role='gridcell'][   3   ]
		String dinamikXpath = "";
		String cell = "";
		System.out.println("Boş olmayanlar içinn------------");

		for (int i = 1; i <= satirlar.size(); i++) {
			for (int j = 1; j <= sutunlar.size(); j++) {
				dinamikXpath = "(//*[@role='rowgroup'] ) [  " + i + "  ] // *[@role='gridcell'][   " + j + "   ]";
				cell = driver.findElement(By.xpath(dinamikXpath)).getText();
				if (!cell.isBlank()) {
					System.out.println(cell);
				}
			}

		}
		System.out.println("-----------------------------------------------------------------");

//8. Tablodaki 3.kolonu yazdirin
		List<WebElement> ucuncuSutunVerileri = driver.findElements(By.xpath("(//*[@role='rowgroup'] )  // *[@role='gridcell'][3]"));
		System.out.println("Üçüncü sütun verileri : " + ReusableMethods.stringListeCevir(ucuncuSutunVerileri));
		System.out.println("-----------------------------------------------------------------");

//9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
//10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

	}
}
