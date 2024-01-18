package tests.day10_ActionsClass_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
1- https://www.facebook.com adresine gidelim
2- Cookies kabul edelim (bende çıkmadı bu adımı geçtim)
3- Yeni hesap olustur butonuna basalim
4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
5- Kaydol tusuna basalim
 */

public class C03_FacebookKayitTesti extends TestBase {
	@Test
	public void testKayit() {
		driver.get("https://www.facebook.com");
		WebElement yeniHesapTusu = driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']"));

		yeniHesapTusu.click();
		Actions actions = new Actions(driver);
		Faker faker = new Faker();
		String fakeEmail = faker.internet().emailAddress();

		WebElement firstNameKutusu = driver.findElement(By.xpath("//input[@*='firstname']"));
		actions.click(firstNameKutusu)
				.sendKeys(faker.name().firstName())
				.sendKeys(Keys.TAB)
				.sendKeys(faker.name().lastName())
				.sendKeys(Keys.TAB)
				.sendKeys(fakeEmail)
				.sendKeys(Keys.TAB)
				.sendKeys(fakeEmail)
				.sendKeys(Keys.TAB)
				.sendKeys(faker.internet().password())
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys("28")
				.sendKeys(Keys.TAB)
				.sendKeys("Şub")
				.sendKeys(Keys.TAB)
				.sendKeys("1985")
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.ARROW_RIGHT)
				.perform();

		ReusableMethods.bekle(3);
		driver.findElement(By.name("websubmit")).click();
		ReusableMethods.bekle(3);


	}
}
