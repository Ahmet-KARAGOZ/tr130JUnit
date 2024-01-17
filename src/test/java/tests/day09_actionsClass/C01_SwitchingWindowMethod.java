package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

/*
//● https://testotomasyonu.com/addremove/ adresine gidin.

//● Sayfa başlığının(title) "Test Otomasyonu" olduğunu doğrulayın.

//● 'Please click for Electronics Products' linkine tiklayin.

//● Sayfa başlığının(title) "Test Otomasyonu - Electronics" olduğunu doğrulayın.
 */

public class C01_SwitchingWindowMethod extends TestBase {
	@Test
	public void test01(){
		driver.get("https://testotomasyonu.com/addremove/");
		String expTitle = "Test Otomasyonu";
		String actTitle = driver.getTitle();

		Assert.assertEquals(expTitle,actTitle);

		driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();
		titleIleWindowDegistir("Test Otomasyonu - Electronics");

		expTitle = "Test Otomasyonu - Electronics";
		actTitle = driver.getTitle();
		Assert.assertEquals(expTitle,actTitle);

		titleIleWindowDegistir("Test Otomasyonu");
		WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
		Assert.assertTrue(addRemoveYaziElementi.isDisplayed());

		titleIleWindowDegistir("Test Otomasyonu - Electronics");
		List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));
		int expUrunSayisi = 16;
		int  actUrunSayisi = bulunanUrunElementleriList.size();

		Assert.assertEquals(expUrunSayisi,actUrunSayisi);


		ReusableMethods.bekle(2);
	}

	public void titleIleWindowDegistir(String hedefTitle){
		Set<String> whdSeti = driver.getWindowHandles();
		for (String eachWHD : whdSeti ){
			driver.switchTo().window(eachWHD);
			String oldugumuzSayfaTitle = driver.getTitle();

			if (oldugumuzSayfaTitle.equals(hedefTitle)){
				break;
			}
		}



	}
}
