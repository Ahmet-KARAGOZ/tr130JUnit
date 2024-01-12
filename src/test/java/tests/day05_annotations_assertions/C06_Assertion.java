package tests.day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {
	WebDriver driver;
	@After
	public void teardown(){
		driver.quit();
	}
	@Test
	public void test01(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.testotomasyonu.com/");
		String expectedUrl = "https://www.testotomasyonu.com";
		String actualUrl = driver.getCurrentUrl();

		if (actualUrl.equals(expectedUrl)){
			System.out.println("Test PASSSED");
		} else  {
			System.out.println("Test FAILED");
			throw new RuntimeException();
		}

		//driver.quit();
	}

}
