package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
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



	}
}
