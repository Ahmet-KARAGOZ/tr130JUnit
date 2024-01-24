package tests.day14_ScreenShatJSExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_JS_Executer extends TestBase {
	@Test
	public void test01(){
		//Anasayfaya gidin
		driver.get("https://www.testotomasyonu.com");
		//Best Sport Shoes  bolumune kadar sagıya inin
		// basligin "Best Sport Shoes For Multi Gender." oldugunu test edin

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement bestSportElementi = driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));
		//jse ile istenen elemente scroll yapalım
		jse.executeScript("arguments[0].scrollIntoView();" , bestSportElementi);
		ReusableMethods.bekle(2);
		String expBaslik = "Best Sport Shoes For Multi Gender.";
		String actBaslik = bestSportElementi.getText();

		ReusableMethods.webElementScreenShot(bestSportElementi);

		Assert.assertEquals(expBaslik,actBaslik);

		jse.executeScript("alert('Merhaba dünya!');");
		ReusableMethods.bekle(3);
	}
}
