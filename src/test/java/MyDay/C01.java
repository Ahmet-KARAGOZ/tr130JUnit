package MyDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
	@Test
	public void sayfaKontrol() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.testotomasyonu.com");
		WebElement aramaKutusu = driver.findElement(By.id("global-search"));
		aramaKutusu.sendKeys("chair" + Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'Yellow')]")).click();

		WebElement stokYazisi = driver.findElement(By.xpath("//*[contains(text(),'In Stock')]"));
		//System.out.println(stokYazisi.getText());

		String expectedResult = "In Stock";
		String actualResult = stokYazisi.getText();

		Assert.assertEquals(expectedResult,actualResult);


		Thread.sleep(3000);
		driver.quit();
	}
}
