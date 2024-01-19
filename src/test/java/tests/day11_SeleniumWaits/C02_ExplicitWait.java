package tests.day11_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
/*
1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
2. Textbox’in etkin olmadigini(enabled) dogrulayın
3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
4. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
5. Textbox’in etkin oldugunu(enabled) dogrulayın.
 */

public class C02_ExplicitWait {
	WebDriver driver;
	@Test
	public void explicitWaitTesti(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		WebElement textBoxElementi =driver.findElement(By.xpath("//input[@type='text']"));
		Assert.assertFalse(textBoxElementi.isEnabled());

		driver.findElement(By.xpath("//*[text()='Enable']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));

		WebElement itsenabledYziElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
		Assert.assertTrue(itsenabledYziElementi.isDisplayed());


		Assert.assertTrue(textBoxElementi.isEnabled());

		ReusableMethods.bekle(2);
		driver.quit();
	}
}
