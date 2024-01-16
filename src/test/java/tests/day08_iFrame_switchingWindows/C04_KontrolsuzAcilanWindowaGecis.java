package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;
/*
● https://testotomasyonu.com/addremove/ adresine gidin.
● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
● ‘Please click for Electronics Products’ linkine tiklayin.
● Electronics sayfasinin acildigini test edin
● Bulunan urun sayisinin 16 olduğunu test edin
● Ilk actiginiz addremove sayfasina donun
● Url’in addremove icerdigini test edin
 */

public class C04_KontrolsuzAcilanWindowaGecis extends TestBase {
	@Test
	public void test01(){
		driver.get("https://testotomasyonu.com/addremove/");
		WebElement textElementi = driver.findElement(By.xpath("//*[text() = 'Add/Remove Elements']"));
		String expYazi = "Add/Remove Elements";
		String actYaazi = textElementi.getText();
		Assert.assertEquals(expYazi,actYaazi);

		String expTitle ="Test Otomasyonu";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle,actTitle);

		String ilkSayfaWHD = driver.getWindowHandle();

		driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();
		String ikinciWHD="";

		Set<String> whdSeti = driver.getWindowHandles();
		for (String each : whdSeti){
			if (!each.equals(ilkSayfaWHD)){
				ikinciWHD=each;
			}
		}

		driver.switchTo().window(ikinciWHD);
		String expTitleicerik ="Electronics";
		actTitle = driver.getTitle();

		Assert.assertTrue(actTitle.contains(expTitleicerik));

		List<WebElement> urunElementListesi = driver.findElements(By.xpath("//*[@class='product-box mb-2 pb-1']"));

		int expUrunSayisi = 16;
		int actUrunSayisi = urunElementListesi.size();
		Assert.assertEquals(expUrunSayisi,actUrunSayisi);

		driver.switchTo().window(ilkSayfaWHD);
		String expURLicerik = "addremove";
		String actUURLicerik = driver.getCurrentUrl();
		Assert.assertTrue(actUURLicerik.contains(expURLicerik));



	}

}
