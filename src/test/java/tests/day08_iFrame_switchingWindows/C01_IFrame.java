package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.WatchEvent;
/*
1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
 2 ) Bir metod olusturun: iframeTest
 - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
 - Text Box’a “Merhaba Dunya!” yazin.
 - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
 */

public class C01_IFrame extends TestBase {
	@Test
	public void iFrameTesti(){
		driver.get("https://the-internet.herokuapp.com/iframe");
		WebElement anIFrameYaziElementi = driver.findElement(By.xpath("//*[text() ='An iFrame containing the TinyMCE WYSIWYG Editor']"));

		Assert.assertTrue(anIFrameYaziElementi.isEnabled());

		WebElement iFrameElementi = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
		driver.switchTo().frame(iFrameElementi);

		WebElement textBoxElement = driver.findElement(By.xpath("//*[@id='tinymce']"));
		ReusableMethods.bekle(1);
		textBoxElement.clear();
		textBoxElement.sendKeys("Merhaba Dunya!");

		driver.switchTo().defaultContent();

		WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
		Assert.assertTrue(elementalSelenium.isDisplayed());
		System.out.println(elementalSelenium.getText());

		ReusableMethods.bekle(2);


	}
}
