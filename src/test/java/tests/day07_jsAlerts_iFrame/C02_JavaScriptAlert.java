package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
1. Test
 - https://testotomasyonu.com/javascriptAlert adresine gidin
 - 1.alert’e tiklayin
 - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
 - OK tusuna basip alert’i kapatin
2.Test
 - https://testotomasyonu.com/javascriptAlert adresine gidin
 - 2.alert’e tiklayalim
 - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
3.Test
 - https://testotomasyonu.com/javascriptAlert adresine gidin
 - 3.alert’e tiklayalim
 - Cikan prompt ekranina “Abdullah” yazdiralim
 - OK tusuna basarak alert’i kapatalim
 - Cikan sonuc yazisinin Abdullah icerdigini test edelim
 */

public class C02_JavaScriptAlert extends TestBase {
	@Test
	public void birinciAlertTesti(){
		driver.get("https://testotomasyonu.com/javascriptAlert");
		driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
		String actualYazi = driver.switchTo().alert().getText();
		String expectedYazi = "I am a JS Alert";

		Assert.assertEquals(expectedYazi,actualYazi);
		driver.switchTo().alert().accept();



	}
	@Test
	public void ikinciAlertTesti(){
		driver.get("https://testotomasyonu.com/javascriptAlert");
		driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();

		WebElement sonucYaziElemnti = driver.findElement(By.xpath("//*[@id='result']"));

		String expectedSonucYazisi = "You clicked: Cancel";
		String actualSonucYazisi = sonucYaziElemnti.getText();

		Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);


	}

	@Test
	public void ucuncuAlertTesti(){
		driver.get("https://testotomasyonu.com/javascriptAlert");
		driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Alper");
		driver.switchTo().alert().accept();
		WebElement sonucYaziElemnti = driver.findElement(By.xpath("//*[@id='result']"));
		String expectedYazi = "Alper";
		String actualYazi = sonucYaziElemnti.getText();

		Assert.assertTrue(actualYazi.contains(expectedYazi));


	}
}
