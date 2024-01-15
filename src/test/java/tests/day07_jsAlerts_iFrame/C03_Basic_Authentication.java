package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
1- Bir class olusturun : BasicAuthentication
2- https://testotomasyonu.com/basicauth sayfasina gidin
3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
Html komutu : https://username:password@URL
 Username    : membername
  password     : sunflower
4- Basarili sekilde sayfaya girildigini dogrulayin
 */

public class C03_Basic_Authentication extends TestBase {
	@Test
	public void test01(){
		driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
		WebElement basicAut = driver.findElement(By.tagName("h1"));
		String expectedYazi = "Basic Auth";
		String actualYazi = basicAut.getText();

		Assert.assertEquals(expectedYazi,actualYazi);

	}
}
