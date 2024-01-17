package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
2- https://the-internet.herokuapp.com/context_menu sitesine gidin
3- Cizili alan uzerinde sag click yapin
4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
 */

public class C03_ActionsContextClick extends TestBase {
	@Test
	public void test01(){
		driver.get("https://the-internet.herokuapp.com/context_menu");

		Actions actions = new Actions(driver);
		WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));
		actions.contextClick(ciziliAlanElementi).perform();

		String expAlertYazi = "You selected a context menu";
		String actAlertYazi = driver.switchTo().alert().getText();

		Assert.assertEquals(expAlertYazi,actAlertYazi);

		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

		ReusableMethods.titleIleWindowDegistir("Elemental Selenium | Elemental Selenium",driver);

		WebElement h1TagElementi = driver.findElement(By.tagName("h1"));
		String expYaziElment = "Make sure your code lands";
		String actYaziElemet = h1TagElementi.getText();

		Assert.assertEquals(expYaziElment,actYaziElemet);


		ReusableMethods.bekle(2);


	}
}
