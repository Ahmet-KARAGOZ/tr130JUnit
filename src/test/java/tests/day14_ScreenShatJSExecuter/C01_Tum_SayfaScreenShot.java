package tests.day14_ScreenShatJSExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_Tum_SayfaScreenShot extends TestBase {
	@Test
	public void test01(){
		// testotomasyon anasayfaya gidin
		driver.get("https://www.testotomasyonu.com");

// dogru sayfaya gittiginizi test edin
		String expURL = "https://www.testotomasyonu.com/";
		String actURL = driver.getCurrentUrl();

		Assert.assertEquals(expURL,actURL);

// screenshot alin
		ReusableMethods.tumSayfaScreenShot(driver);

// phone icin arama yapin
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("phone" , Keys.ENTER);


// arama sonucunda urun bulunabildigini test edin

		WebElement sonucYazisi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
		String unExpectedSonucYazisi = "0 Products Found";
		String actSonucYazisi = sonucYazisi.getText();
		Assert.assertNotEquals(unExpectedSonucYazisi,actSonucYazisi);

// screenshot alin

		ReusableMethods.tumSayfaScreenShot(driver,"urunSayisi");

		ReusableMethods.bekle(1);

	}
}
