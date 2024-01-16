package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;
/*
1- https://testotomasyonu.com/discount adresine gidin
2- Elektronics Products yazisinin gorunur olduğunu test edin
3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin
6- Sayfayi kapatin
 */

public class C03_KontrolsuzAcilanWindowaGecis extends TestBase {
	@Test
	public void kontrolsuzWindowTesti(){
		driver.get("https://testotomasyonu.com/discount");
		WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));
		driver.switchTo().frame(electronicsIframe);

		WebElement elektronicsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
		Assert.assertTrue(elektronicsYaziElementi.isDisplayed());

		//DELL Core I3 11th Gen
		WebElement delElementi = driver.findElement(By.id("dell-core"));
		System.out.println(delElementi.getText());
		String expUrunIsmi = "DELL Core I3 11th Gen";
		String actUrunIsmi = delElementi.getText();
		Assert.assertEquals(expUrunIsmi,actUrunIsmi);
		//1.Tab Handle Değeri:
		String ilkWindowWHD = driver.getWindowHandle();

		delElementi.click();

		Set<String> whDegerleriSeti = driver.getWindowHandles();
		System.out.println("ilkWindowWHD = " + ilkWindowWHD);
		System.out.println("whDegerleriSeti = " + whDegerleriSeti);
		String ikinciWindowWHD="";

		for (String each : whDegerleriSeti){
			if (!each.equals(ilkWindowWHD)){
				ikinciWindowWHD = each;
			}
		}

		driver.switchTo().window(ikinciWindowWHD);
		WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));
		String expFiyat = "$399.00";
		String actFiyat = fiyatElementi.getText();

		Assert.assertEquals(expFiyat,actFiyat);
		driver.switchTo().window(ilkWindowWHD);

		ReusableMethods.bekle(2);

		WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));
		Assert.assertTrue(hereAreYaziElementi.isDisplayed());




	}
}
