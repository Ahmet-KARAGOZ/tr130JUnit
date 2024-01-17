package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
1- https://testotomasyonu.com/click sitesine gidin
2- “DGI Drones” uzerinde sag click yapin
3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
4- Tamam diyerek alert’i kapatalim
 */

public class C02_ActionsContextClick extends TestBase {
	@Test
	public void test01(){
		driver.get("https://testotomasyonu.com/click");

		Actions actions = new Actions(driver);

		WebElement dgiDroneElementi = driver.findElement(By.id("pic2_thumb"));
		actions.contextClick(dgiDroneElementi).perform();
		ReusableMethods.bekle(1);

		String expAlertYazi = "Tebrikler!... Sağ click yaptınız.";
		String actAlertYazi = driver.switchTo().alert().getText();
		Assert.assertEquals(expAlertYazi,actAlertYazi);

		driver.switchTo().alert().accept();

		ReusableMethods.bekle(10);
	}
}
