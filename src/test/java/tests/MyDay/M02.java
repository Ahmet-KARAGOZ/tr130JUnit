package tests.MyDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

/*
Google Earth te istenen noktaya gidip gidilen noktanın irtifasını yazdıran programı yazınız.
 */

public class M02  {
	@Test
	public void test01(){

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://earth.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='flt-text-editing transparentTextEditing']"));
		aramaKutusu.sendKeys("38°18'22\"N 27°09'02\"E" + Keys.ENTER);
		ReusableMethods.bekle(5);
		aramaKutusu.clear();
		aramaKutusu.sendKeys("38°22'00\"N 27°07'54\"E" + Keys.ENTER);
		ReusableMethods.bekle(5);
	}
}