package tests.day06_assertions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C05_DropDownMenu extends TestBase {
	/*
	● https://testotomasyonu.com/form adresine gidin.
	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
	4. Secilen değerleri konsolda yazdirin
	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
	 */
	@Test
	public void dropdownTesti() throws InterruptedException {
		driver.get("https://testotomasyonu.com/form");
		//1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

		WebElement dropDwnGun = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
		Select selectGun = new Select(dropDwnGun);
		selectGun.selectByIndex(5);

		//2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

		WebElement DropDwnAy = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select selectAy = new Select(DropDwnAy);
		selectAy.selectByValue("nisan");

		//3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

		WebElement dropDwnYil = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
		Select selectYil = new Select(dropDwnYil);
		selectYil.selectByVisibleText("1990");

		System.out.println(selectGun.getFirstSelectedOption().getText());
		System.out.println(selectAy.getFirstSelectedOption().getText());
		System.out.println(selectYil.getFirstSelectedOption().getText());

	Thread.sleep(3000);
	}
}
