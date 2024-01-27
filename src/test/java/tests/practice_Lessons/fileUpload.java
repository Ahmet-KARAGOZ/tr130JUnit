package tests.practice_Lessons;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
https://the-internet.herokuapp.com/upload adresine giderek
bir dosyayı siteye upload edip. Upload edildiğini doğrulayınız
 */

public class fileUpload extends TestBase {
	@Test
	public void fileUpload(){
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement browse = driver.findElement(By.id("file-upload"));
		String dosyaYolu = "C:\\Users\\x\\IdeaProjects\\Self_T130_JUnit\\src\\test\\java\\tests\\practice_Lessons\\fileUpload.java";
		ReusableMethods.bekle(2);
		browse.sendKeys(dosyaYolu);
		driver.findElement(By.id("file-submit")).click();

		WebElement uploadeED = driver.findElement(By.xpath("//h3"));
		Assert.assertTrue(uploadeED.isDisplayed());
		ReusableMethods.bekle(5);


	}
}
