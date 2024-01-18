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
1- https://www.testotomasyonu.com adresine gidelim
2- Account linkine tiklayin
3- Sign Up linkine basalim
4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
5- Kaydin olusturuldugunu test edin
 */

public class C02_TEstotomasyonuRegister extends TestBase {
	@Test
	public void kayitolusturmaTesti(){
		driver.get("https://www.testotomasyonu.com");
		WebElement accountLinkElementi = driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"));
		accountLinkElementi.click();

		WebElement signUpLinki = driver.findElement(By.xpath("//a[text()=' Sign Up']"));
		signUpLinki.click();
		ReusableMethods.bekle(2);

		WebElement firstName = driver.findElement(By.id("firstName"));

		Actions actions = new Actions(driver);
		actions.click(firstName)
				.sendKeys("Ahmet")
				.sendKeys(Keys.TAB)
				.sendKeys("KARAGOZ")
				.sendKeys(Keys.TAB)
				.sendKeys("qwerty@gmail.com")
				.sendKeys(Keys.TAB)
				.sendKeys("0987")
				.sendKeys(Keys.TAB)
				.sendKeys("0987")
				.perform();

		driver.findElement(By.id("btn-submit-form")).click();

		ReusableMethods.bekle(2);

		WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
		emailKutusu.sendKeys("qwerty@gmail.com");

		WebElement sifreKutusu = driver.findElement(By.xpath("//input[@id='password']"));
		sifreKutusu.sendKeys("0987");

		driver.findElement(By.xpath("//*[@id='submitlogin']")).click();

		ReusableMethods.bekle(1);

		WebElement emailYazisi = driver.findElement(By.xpath("//p[text()='qwerty@gmail.com']"));
		Assert.assertTrue(emailYazisi.isDisplayed());


	}
}
