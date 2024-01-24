package tests.day14_ScreenShatJSExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_IstenenWebElementScreenShot extends TestBase {
	@Test
	public void test01() throws IOException {
		// testotomasyon anasayfaya gidin
		driver.get("https://www.testotomasyonu.com");

// arama kutusuna phone yazip, arama kutusunun screenshot'ini alin
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("phone");

		File webElementSS = new File("target/webElementSShots/aramaKutusu.jpg");
		File geciciSS = aramaKutusu.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(geciciSS,webElementSS);



// phone icin arama yapin
		aramaKutusu.submit();

// arama sonucunda urun bulunabildigini test edin
		WebElement sonucYazisi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
		String unExpectedSonucYazisi = "0 Products Found";
		String actSonucYazisi = sonucYazisi.getText();
		Assert.assertNotEquals(unExpectedSonucYazisi,actSonucYazisi);

// arama sonuc yazisinin screenshot'ini alin
		ReusableMethods.webElementScreenShot(sonucYazisi);



		ReusableMethods.bekle(1);
	}
}
