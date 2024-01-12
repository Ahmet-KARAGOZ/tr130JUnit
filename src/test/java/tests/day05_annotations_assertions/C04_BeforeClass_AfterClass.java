package tests.day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_BeforeClass_AfterClass {
	static  WebDriver driver;
	List<WebElement> bulunanUrunler;
	@BeforeClass
	public static void setup(){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public static void teardown(){
		driver.quit();
	}
	@Test
	public void test01(){
		driver.get("https://www.testotomasyonu.com/");
		String expecteURL = "https://www.testotomasyonu.com/";
		String actualURL = driver.getCurrentUrl();

		if (expecteURL.equals(actualURL)){
			System.out.println("Test Otomasyonu sayfa Testi PASSED");
		} else System.out.println("Test Otomasyonu sayfa Testi FAILED");

	}
	@Test
	public void test02(){
		WebElement aramakutusu = driver.findElement(By.id("global-search"));
		aramakutusu.sendKeys("phone" + Keys.ENTER);
		bulunanUrunler = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));
		int actualurunSayisi = bulunanUrunler.size();

		if (actualurunSayisi > 0){
			System.out.println("Ürun Bulma Test PASSED");
		} else System.out.println("Ürun Bulma Test FAILED");

	}
	@Test
	public void test03(){
		bulunanUrunler = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));
		bulunanUrunler.get(0).click();
		WebElement urunacıklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));
		String expectedIcerik = "phone";
		String actAcıklama = urunacıklamaElementi.getText().toLowerCase();

		if (actAcıklama.contains(expectedIcerik)){
			System.out.println("İlk urun Testi PASSED");
		} else System.out.println("İlk urun Testi FAILED");

	}
}
