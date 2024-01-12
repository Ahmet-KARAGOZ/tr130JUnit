package tests.day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_CheckBox2 extends TestBase {
	@Test
	public void checkBoxTesti() throws InterruptedException {
		driver.get("https://testotomasyonu.com/form");

		//	b. Sirt Agrisi ve Carpinti checkbox’larini secin

		WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
		WebElement sirtAgrisiYazisi = driver.findElement(By.xpath("//label[@for='gridCheck5']"));

		WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
		WebElement carpintiYazisi = driver.findElement(By.xpath("//label[@for='gridCheck4']"));

		sirtAgrisiYazisi.click();
		carpintiCheckBox.click();

		//	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

		Assert.assertTrue(sirtAgrisiCheckBox.isSelected());
		Assert.assertTrue(carpintiCheckBox.isSelected());

		//	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

		WebElement sekerCheckBox = driver.findElement(By.id("gridCheck2"));
		WebElement epilepsiCheckBox = driver.findElement(By.id("gridCheck7"));

		Assert.assertFalse(sekerCheckBox.isSelected());
		Assert.assertFalse(epilepsiCheckBox.isSelected());








		Thread.sleep(3000);



	}
}
