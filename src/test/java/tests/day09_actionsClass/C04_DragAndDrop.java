package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
/*
1- https://testotomasyonu.com/droppable adresine gidelim
2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
4- Sayfayi yenileyin
5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
6- “Drop Here” yazisinin degismedigini test edin
 */
public class C04_DragAndDrop extends TestBase {
	@Test
	public void test01(){
		driver.get("https://testotomasyonu.com/droppable");
		Actions actions = new Actions(driver);
		WebElement acceptableButonElementi = driver.findElement(By.xpath("//*[text()='Acceptable']"));
		WebElement dropHereElementi = driver.findElement(By.xpath("//*[@id='droppable2']"));
		ReusableMethods.bekle(2);
		actions.dragAndDrop(acceptableButonElementi,dropHereElementi).perform();

		String expYazi = "Dropped!";
		String actYazi = dropHereElementi.getText();
		Assert.assertEquals(expYazi,actYazi);

		driver.navigate().refresh();
		WebElement notAcceptableButonElementi = driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
		dropHereElementi = driver.findElement(By.xpath("//*[@id='droppable2']"));
		ReusableMethods.bekle(1);
		actions.dragAndDrop(notAcceptableButonElementi,dropHereElementi).perform();

		expYazi = "Drop Here";
		actYazi = dropHereElementi.getText();
		Assert.assertEquals(expYazi,actYazi);

		ReusableMethods.bekle(2);
	}
}
