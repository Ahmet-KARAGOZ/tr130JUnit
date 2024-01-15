package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
1- https://testotomasyonu.com/discount adresine gidin
2- Elektronics Products yazisinin gorunur olduğunu test edin
3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
5- Fashion yazisinin gorunur olduğunu test edin
6- Sayfayi kapatin
 */
public class C04_IFrame extends TestBase {
	@Test
	public void iFrameTesti(){
		driver.get("https://testotomasyonu.com/discount");

		WebElement elektronicIFrame = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));
		driver.switchTo().frame(elektronicIFrame);
		WebElement elektronicProductElementi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));
		Assert.assertTrue(elektronicProductElementi.isDisplayed());

		WebElement dellisimelementi = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));
		String expisim = "DELL Core I3 11th Gen";
		String actisim = dellisimelementi.getText();

		Assert.assertEquals(actisim,expisim);
	}

}
