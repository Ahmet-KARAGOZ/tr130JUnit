package tests.MyDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://earth.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// //*[@*='__image_picker_web-file-input']

		//  (//input[@class='flt-text-editing transparentTextEditing'])[1]

		WebElement aramaKutusu = driver.findElement(By.xpath("(//input[@class='flt-text-editing transparentTextEditing'])[1]"));

		//Actions actions = new Actions(driver);
		//actions.click(aramaKutusu);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", aramaKutusu);


		aramaKutusu.sendKeys("38°18'22\"N 27°09'02\"E" + Keys.ENTER);
		ReusableMethods.bekle(5);

		aramaKutusu = driver.findElement(By.xpath("(//input[@class='flt-text-editing transparentTextEditing'])[1]"));
		aramaKutusu.clear();
		aramaKutusu.sendKeys("38°22'00\"N 27°07'54\"E" + Keys.ENTER);
		//ReusableMethods.bekle(5);
	}
}
