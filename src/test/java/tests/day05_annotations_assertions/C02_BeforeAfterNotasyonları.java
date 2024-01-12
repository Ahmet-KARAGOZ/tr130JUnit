package tests.day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfterNotasyonları {
	WebDriver driver;
	public void baslangıcAyarlariYap(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void testOtomasyonuTest(){
		baslangıcAyarlariYap();
		driver.get("https://www.testotomasyonu.com/");
		String expectesURL ="https://www.testotomasyonu.com/";
		String actualURL = driver.getCurrentUrl();

		if (expectesURL.equals(actualURL)){
			System.out.println("TEST otomasyınu PASSED");
		} else System.out.println("TEst oto FAILED");
		driver.quit();
	}
	@Test
	public void youtubeTest(){
		baslangıcAyarlariYap();
		driver.get("https://www.youtube.com/");
		String expectesURL ="https://www.youtube.com/";
		String actualURL = driver.getCurrentUrl();

		if (expectesURL.equals(actualURL)){
			System.out.println("youtube PASSED");
		} else System.out.println("youtube FAILED");
		driver.quit();
	}
	@Test
	public void wiseQuarterTest(){
		baslangıcAyarlariYap();
		driver.get("https://www.wisequarter.com/");
		String expectesURL ="https://wisequarter.com/";
		String actualURL = driver.getCurrentUrl();

		if (expectesURL.equals(actualURL)){
			System.out.println("Wİse PASSED");
		} else System.out.println("Wise FAILED");
		driver.quit();
	}
}
