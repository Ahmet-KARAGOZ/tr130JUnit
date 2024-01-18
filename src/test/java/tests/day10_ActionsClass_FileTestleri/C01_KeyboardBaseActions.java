package tests.day10_ActionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
1- https://www.testotomasyonu.com sayfasina gidelim
2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
 */

public class C01_KeyboardBaseActions extends TestBase {
	@Test
	public void aramaTesti(){
		driver.get("https://www.testotomasyonu.com/");
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		Actions actions = new Actions(driver);

		actions.click(aramaKutusu)
				.keyDown(Keys.SHIFT)
				.sendKeys("dell c")
				.keyUp(Keys.SHIFT)
				.sendKeys("ore ")
				.keyDown(Keys.SHIFT)
				.sendKeys("i")
				.keyUp(Keys.SHIFT)
				.sendKeys("3")
				.sendKeys(Keys.ENTER)
				.perform();

		WebElement urunDetayElenti =driver.findElement(By.xpath("//*[@*='product-detail mb-3']"));
		String expUrunIcerik = "DELL Core I3";
		String actUrunIcerik = urunDetayElenti.getText();

		Assert.assertTrue(actUrunIcerik.contains(expUrunIcerik));

		ReusableMethods.bekle(5);
	}

}
