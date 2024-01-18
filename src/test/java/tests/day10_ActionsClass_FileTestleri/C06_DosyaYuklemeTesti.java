package tests.day10_ActionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
/*
1.https://the-internet.herokuapp.com/upload adresine gidelim
2.chooseFile butonuna basalim
3.Yuklemek istediginiz dosyayi secelim.
4.Upload butonuna basalim.
5.“File Uploaded!” textinin goruntulendigini test edelim.
 */

public class C06_DosyaYuklemeTesti extends TestBase {
	@Test
	public void yuklemeTesti(){
		// C:\Users\x\Desktop\cartman.png
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

		String dinamikDosyaYolu = System.getProperty("user.home") + "\\Desktop\\cartman.png";
		chooseFileButonu.sendKeys(dinamikDosyaYolu);
		driver.findElement(By.id("file-submit")).click();

		WebElement dosyayuklendiYazisi = driver.findElement(By.id("uploaded-files"));
		Assert.assertTrue(dosyayuklendiYazisi.isDisplayed());

	}
}
