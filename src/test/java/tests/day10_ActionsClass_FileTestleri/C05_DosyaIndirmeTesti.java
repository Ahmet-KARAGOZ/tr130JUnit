package tests.day10_ActionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DosyaIndirmeTesti  extends TestBase {
	/*
	1. https://the-internet.herokuapp.com/download adresine gidelim.
2. logo.jpg dosyasını indirelim
3. Dosyanın başarıyla indirilip indirilmediğini test edelim
	 */

	@Test
	public void dosyaIndirmeTesti(){
		driver.get("https://the-internet.herokuapp.com/download");

		//  C:\Users\x\Downloads          dosyanın indiği yer

		System.out.println(System.getProperty("user.home")); // download öncesi   C:\Users\x

		//2. logo.jpg dosyasını indirelim
		driver.findElement(By.xpath("//*[text()='logo.jpg']")).click();

		String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\logo.jpg";
		System.out.println(dinamikDosyaYolu);

		ReusableMethods.bekle(2);

		Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));



	}
}
