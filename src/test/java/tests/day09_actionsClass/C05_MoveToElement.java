package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
1- https://www.testotomasyonu.com/ adresine gidin
2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
3- “Boys” linkine basin
4- Acilan sayfadaki ilk urunu tiklayin
4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
 */

public class C05_MoveToElement extends TestBase {
	@Test
	public void test01(){
		driver.get("https://www.testotomasyonu.com/");
		WebElement kidsWearElementi = driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(kidsWearElementi).perform();


		ReusableMethods.bekle(2);

		driver.findElement(By.xpath("//a[text()='Boys']")).click();


		driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]")).click();
		String expUrunIsmi = "Boys Shirt White Color";
		WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
		String actUrunIsmi = urunIsimElementi.getText();

		Assert.assertEquals(expUrunIsmi,actUrunIsmi);

		ReusableMethods.bekle(3);

	}
}
