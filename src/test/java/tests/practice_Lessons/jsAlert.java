package tests.practice_Lessons;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;
/* 1. Test
    -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
 - 1.alert'e tiklayin
    -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    -  OK tusuna basip alert'i kapatin
 */

public class jsAlert extends TestBase {
	@Test
	public void jsAlertTesti(){
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement jsPromt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		jsPromt.click();
		driver.switchTo().alert().sendKeys("Ben Kadir Deli Kadir!!");
		ReusableMethods.bekle(2);
		driver.switchTo().alert().accept();

		WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));

		String expSonuc = "Ben Kadir Deli Kadir!!";
		String actSonuc = sonucYazisi.getText();

		Assert.assertTrue(actSonuc.contains(expSonuc));

		ReusableMethods.bekle(5);

	}
}
