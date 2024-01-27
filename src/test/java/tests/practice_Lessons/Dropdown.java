package tests.practice_Lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
//● https://the-internet.herokuapp.com/dropdown adresine gidin.
// 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
// 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
// 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
// 4.Tüm dropdown değerleri(value) yazdırın
// 5.Dropdown'un boyutunun 3 olduğunu test edin

public class Dropdown {
	static WebDriver driver;

	@Before
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void dropDownMenu() {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		ReusableMethods.bekle(1);

		WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id='dropdown']"));
		Select select = new Select(dropdownMenu);
		select.selectByIndex(1);
		System.out.println(select.getFirstSelectedOption().getText());

		select.selectByValue("2");
		System.out.println(select.getFirstSelectedOption().getText());

		select.selectByVisibleText("Option 1");
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println("--------------------------------");

		List<WebElement> optionList = select.getOptions();
		for (WebElement each : optionList) {
			System.out.println(each.getText());
		}

		Assert.assertEquals(3, optionList.size());


	}
}
