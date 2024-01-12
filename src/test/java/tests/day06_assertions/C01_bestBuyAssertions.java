package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */

public class C01_bestBuyAssertions {
	static  WebDriver driver;
	@BeforeClass
	public static void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bestbuy.com/");
	}

	@AfterClass
	public static void teardown(){
		driver.quit();
	}
	@Test
	public void urlTesti(){
		String expectedURL = "https://www.bestbuy.com/";
		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(expectedURL,actualURL);
	}

	@Test
	public void titleTesi(){
		String unexpectedIcerik = "Rest";
		String actualTitle = driver.getTitle();

		Assert.assertFalse(actualTitle.contains(unexpectedIcerik));
	}

	@Test
	public void logoTesti(){
		WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
		Assert.assertTrue(logoElementi.isDisplayed());
	}

	@Test
	public void francaisLinkTesti(){
		WebElement francaisLinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));
		Assert.assertTrue(francaisLinkElementi.isDisplayed());
	}

	public static class C02_CheckBox {
		/*
		Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
	 a. Verilen web sayfasına gidin.
		 https://testotomasyonu.com/form
	 b. Sirt Agrisi ve Carpinti checkbox’larini secin
	 c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
	 d. Seker ve Epilepsi checkbox’larininin seçili                                  olmadigini test edin
		 */
		WebDriver driver;
		@Before
		public void setup(){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		@After
		public void teardown(){
			driver.quit();
		}

		@Test
		public void checkboxTesti(){
			driver.get("https://testotomasyonu.com/form");
			WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
			WebElement sirtAgrisiYazisi = driver.findElement(By.xpath("//label[@for='gridCheck5']"));

			WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
			WebElement carpintiYazisi = driver.findElement(By.xpath("//label[@for='gridCheck4']"));

			sirtAgrisiYazisi.click();
			carpintiCheckBox.click();

			Assert.assertTrue(sirtAgrisiCheckBox.isSelected());
			Assert.assertTrue(carpintiCheckBox.isSelected());

			WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
			WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

			Assert.assertFalse(sekerCheckBox.isSelected());
			Assert.assertFalse(epilepsiCheckBox.isSelected());
		}


	}
}
