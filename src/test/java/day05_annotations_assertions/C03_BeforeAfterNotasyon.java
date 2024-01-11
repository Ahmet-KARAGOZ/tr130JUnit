package day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterNotasyon {
	WebDriver driver;
	@Before
	public void setup(){
		System.out.println("@Before çalıştı.");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@After
	public void teardown(){
		System.out.println("@After çalıştı.");
		driver.quit();
	}
	@Test
	public void testOtomasyonuTest(){

		driver.get("https://www.testotomasyonu.com/");
		String expectesURL ="https://www.testotomasyonu.com/";
		String actualURL = driver.getCurrentUrl();

		if (expectesURL.equals(actualURL)){
			System.out.println("TEST otomasyınu PASSED");
		} else System.out.println("TEst oto FAILED");

	}
	@Test
	public void youtubeTest(){

		driver.get("https://www.youtube.com/");
		String expectesURL ="https://www.youtube.com/";
		String actualURL = driver.getCurrentUrl();

		if (expectesURL.equals(actualURL)){
			System.out.println("youtube PASSED");
		} else System.out.println("youtube FAILED");

	}
	@Test
	public void wiseQuarterTest(){

		driver.get("https://www.wisequarter.com/");
		String expectesURL ="https://wisequarter.com/";
		String actualURL = driver.getCurrentUrl();

		if (expectesURL.equals(actualURL)){
			System.out.println("Wİse PASSED");
		} else System.out.println("Wise FAILED");

	}
}
