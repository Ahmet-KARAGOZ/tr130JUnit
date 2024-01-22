package tests.practice_Lessons;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

// ilgili kurulumlari tamamlayalim
// Kullanici https://www.google.com adresine gider
// Çıkıyorsa Kullanici cookies i kabul eder
// Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
// Para birimlerinin karsilastirmasini alin
// Karsilastirilacak olan para biriminin 28 den kucuk oldugu test edilir

public class DolarKuru extends TestBase {
	@Test
	public void test01(){
		driver.get("https://www.google.com");
		WebElement aramaKutusu = driver.findElement(By.className("gLFyf"));
		aramaKutusu.sendKeys("USD TL" + Keys.ENTER);

		WebElement resultMoneyElementi = driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
		String result = resultMoneyElementi.getText().replace(",",".");
		System.out.println(result);

		double resultDouble = Double.parseDouble(result);

		Assert.assertTrue(resultDouble>30);
		if (resultDouble > 30){
			System.out.println("Artık dursun!");
		} else {
			System.out.println("Daha buralara gelmemiş...");
		}

	}
}
