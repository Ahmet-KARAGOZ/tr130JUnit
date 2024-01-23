package tests.day13_ExcelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBase {
	@Test
	public void aramaTesti() throws IOException {
		driver.get("https://www.testotomasyonu.com");
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


		WebElement aramasonucuElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
		String expSonucYazisi = "0 Products Found";
		String actSonucYazisi = aramasonucuElementi.getText();

		Assert.assertEquals(expSonucYazisi,actSonucYazisi);
		ReusableMethods.bekle(1);
//Ekran görüntüsü alma
		TakesScreenshot tss = (TakesScreenshot) driver;
		File tumSayfaScreenShot = new File("target/tumSayfaScreenShot/tss.jpeg");
		File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);



		ReusableMethods.bekle(2);

	}
}
