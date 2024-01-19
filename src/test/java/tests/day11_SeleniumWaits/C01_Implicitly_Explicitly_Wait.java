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
Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
Iki metod icin de asagidaki adimlari test edin.
1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
2. Remove butonuna basin.
3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
4. Add buttonuna basin
5. It’s back mesajinin gorundugunu test edin
 */
public class C01_Implicitly_Explicitly_Wait {
	WebDriver driver;
	@Test
	public void implicitWaitTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//*[text()='Remove']")).click();

		WebElement itsGone = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
		Assert.assertTrue(itsGone.isDisplayed());

		WebElement addButonu = driver.findElement(By.xpath("//*[text()='Add']"));
		addButonu.click();

		WebElement itsBackYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
		Assert.assertTrue(itsBackYaziElementi.isDisplayed());

		ReusableMethods.bekle(3);
		driver.quit();
	}

	@Test
	public void explicitWaitTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//*[text()='Remove']")).click();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		/*
		WebElement itsGone = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

		wait.until(ExpectedConditions.visibilityOf(itsGone));
		 */
		WebElement itsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));


		Assert.assertTrue(itsGone.isDisplayed());

		driver.findElement(By.xpath("//*[text()='Add']")).click();

		/*
		WebElement itsBackYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
		 */
		WebElement itsBackYaziElementi =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));

		Assert.assertTrue(itsBackYaziElementi.isDisplayed());












		ReusableMethods.bekle(3);
		driver.quit();
	}
}
