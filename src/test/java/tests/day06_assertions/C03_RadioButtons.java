package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtons {
	/*
	a. Verilen web sayfasına gidin.
      https://testotomasyonu.com/form
 	b. Cinsiyet Radio button elementlerini locate edin
	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
 	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
	 */
	static WebDriver driver;
	@BeforeClass
	public static void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void yazidanSecmeTesti(){
		driver.get("https://testotomasyonu.com/form");
		WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
		WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
		WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

		WebElement erkekRadioYazisElemnti = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
		erkekRadioYazisElemnti.click();

		Assert.assertTrue(erkekRadioButton.isSelected());
		Assert.assertFalse(kadinRadioButton.isSelected());
		Assert.assertFalse(digerRadioButton.isSelected());
	}

	@Test
	public void butondanSecmeTesti(){
		driver.get("https://testotomasyonu.com/form");
		WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
		WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
		WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

		erkekRadioButton.click();

		Assert.assertTrue(erkekRadioButton.isSelected());
		Assert.assertFalse(kadinRadioButton.isSelected());
		Assert.assertFalse(digerRadioButton.isSelected());

	}


}
