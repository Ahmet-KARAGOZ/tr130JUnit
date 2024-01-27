package tests.practice_Lessons;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class iFrame extends TestBase {
	@Test
	public void iFrameTesti(){
		driver.get("https://the-internet.herokuapp.com/iframe");
		WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(iFrame);
		WebElement iFrameText = driver.findElement(By.id("tinymce"));
		iFrameText.clear();
		iFrameText.sendKeys("Zoboligozabzob");

		ReusableMethods.bekle(3);
	}
}
