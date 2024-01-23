package tests.MyDay;

import org.junit.Test;
import utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
import javax.security.auth.kerberos.KeyTab;
import javax.swing.*;
import java.util.List;
import java.util.Set;

public class M05 extends TestBase {
	@Test
	public void test01(){
		// https://www.testgorilla.com   --- sitesine gidin
		driver.get("https://www.testgorilla.com");
		// title'da "Talent" kelimesi ile başladığını test edin
		String title = driver.getTitle();
		Assert.assertTrue(title.startsWith("Talent"));
		// Pricing'e tıkladıktan sonra Starter paketinin altında seçebileceğimiz 11 seçenek olduğunu test edelim
		WebElement pricingElementi = driver.findElement(By.xpath("//a[text()='Pricing']"));
		pricingElementi.click();
		WebElement optionElementi = driver.findElement(By.xpath("(//button[@id='company-sizes-dropdown-trigger'])[1]"));
		optionElementi.click();
		List<WebElement> tumOptinSecenekleri = driver.findElements(By.xpath("(//*[@class='sc-b516285b-9 fSvSMq']) // button[@class='sc-b516285b-10 YHvmH']"));
		Assert.assertEquals(11,tumOptinSecenekleri.size());
		// Sayfayı refresh yapıp cookie'yi kabul edelim
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[text()='Accept']")).click();
		// Tüm cookie’leri listeleyelim
		Set<Cookie> cookieSeti = driver.manage().getCookies();
		int cookieSiraNo =1;
		for (Cookie eachCookie : cookieSeti ){
			System.out.println(cookieSiraNo + " = " + eachCookie);
			cookieSiraNo++;
		}
		//  chat butonuna tıklayın
		driver.findElement(By.xpath("//*[@class='m_JG1bwRiEvqsFkk5fD8']")).click();
		driver.findElement(By.xpath("//*[text()='Chat']")).click();
		driver.findElement(By.xpath("//*[text()='Send us a message']")).click();
		// Fake bir email yazıp bir kaç mesaj gönderelim
		WebElement emailKutuElementi = driver.findElement(By.xpath("//input[@placeholder='Email@example.com']"));
		WebElement mesajKutuElementi = driver.findElement(By.xpath("//*[@placeholder='Type a message...']"));
		Actions actions = new Actions(driver);
		Faker faker = new Faker();
		actions.click(emailKutuElementi)
				.sendKeys(faker.internet().emailAddress())
				.sendKeys(Keys.TAB)
				.sendKeys("Hello. I need help! I wanna talk about TestGorilla")
				.perform();
		ReusableMethods.bekle(2);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().perform();
		//sayfayı yenileyelim
		ReusableMethods.bekle(5);
	}
	// Book a demo'ya tıklayalım
	//// First name yazisinin görünür olduğunu test edelim
}
