package tests.practice_Lessons;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class FakerClass extends TestBase {
	@Test
	public void fakerClass(){
		driver.get("https://www.automationexercise.com/");
		driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

		Faker faker = new Faker();

		WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
		String isim = faker.name().fullName();
		nameBox.sendKeys(isim);

		WebElement mailBox = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
		String emailAdress = faker.internet().emailAddress();
		mailBox.sendKeys(emailAdress);

		//driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("(//button[@type='submit'])[2]"))).perform();

		driver.findElement(By.xpath("//*[@id='id_gender1']")).click();

		WebElement passwordBox = driver.findElement(By.xpath("//*[@id='password']"));
		actions.click(passwordBox).sendKeys(faker.internet().password(3,8))
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(faker.name().firstName())
				.sendKeys(Keys.TAB)
				.sendKeys(faker.name().lastName())
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(faker.address().fullAddress())
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
				.sendKeys(faker.address().state())
				.sendKeys(Keys.TAB)
				.sendKeys(faker.address().city())
				.sendKeys(Keys.TAB)
				.sendKeys(faker.address().zipCode())
				.sendKeys(Keys.TAB)
				.sendKeys(faker.phoneNumber().phoneNumber())
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.ENTER).perform();


		WebElement onayYazisi = driver.findElement(By.xpath("//*[text()='Account Created!']"));

		String expYazi = "ACCOUNT CREATED!";
		String actYazi = onayYazisi.getText();

		Assert.assertEquals(expYazi,actYazi);



		ReusableMethods.bekle(20);

	}
}
