package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

/*
● testotomasyonu anasayfa adresine gidin.
● Sayfa’nin window handle degerini String bir degiskene atayin
● Sayfa title’nin “Otomasyon” icerdigini test edin
● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
● Sayfa title’nin “wisequarter” icerdigini test edin
● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
● Sayfa title’nin “Walmart” icerdigini test edin
● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
 */

public class C02_SwitchingWindows extends TestBase {
	@Test
	public void yeniWindowTesti(){
		driver.get("https://testotomasyonu.com");
		String testOtoWindowHandleDegeri = driver.getWindowHandle();
		String expTitle="Otomasyon";
		String actTitle = driver.getTitle();

		Assert.assertTrue(actTitle.contains(expTitle));

		ReusableMethods.bekle(1);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://wisequarter.com");

		expTitle="Wise Quarter";
		actTitle = driver.getTitle();

		Assert.assertTrue(actTitle.contains(expTitle));

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.walmart.com");

		expTitle="Walmart";
		actTitle = driver.getTitle();

		Assert.assertTrue(actTitle.contains(expTitle));

		driver.switchTo().window(testOtoWindowHandleDegeri);
		expTitle="Otomasyon";
		actTitle = driver.getTitle();

		Assert.assertTrue(actTitle.contains(expTitle));

		ReusableMethods.bekle(2);




	}
}
