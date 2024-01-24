package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
	public static void bekle(int saniye) {
		try {
			Thread.sleep(saniye * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<String> stringListeCevir(List<WebElement> webElementList) {
		List<String> stringLst = new ArrayList<>();
		for (WebElement eachElement : webElementList) {
			stringLst.add(eachElement.getText());

		}
		return stringLst;
	}

	public static void titleIleWindowDegistir(String hedefTitle, WebDriver driver) {
		Set<String> whdSeti = driver.getWindowHandles();
		for (String eachWHD : whdSeti) {
			driver.switchTo().window(eachWHD);
			String oldugumuzSayfaTitle = driver.getTitle();

			if (oldugumuzSayfaTitle.equals(hedefTitle)) {
				break;
			}
		}


	}

	public static void tumSayfaScreenShot(WebDriver driver) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
		String timeStamp = ldt.format(zamanFormati);

		File tumSayfaScreenShot = new File("target/tumSayfaScreenShot/tss" + timeStamp + ".jpeg");
		File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(geciciDosya, tumSayfaScreenShot);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void tumSayfaScreenShot(WebDriver driver, String resimAdi) {
		TakesScreenshot tss = (TakesScreenshot) driver;

		File tumSayfaScreenShot = new File("target/tumSayfaScreenShot/" + resimAdi + ".jpeg");
		File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(geciciDosya, tumSayfaScreenShot);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void webElementScreenShot(WebElement webElement) {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
		String timeStamp = ldt.format(zamanFormati);

		File webElementSS = new File("target/webElementSShots/webElement" + timeStamp + ".jpg");
		File geciciSS = webElement.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(geciciSS, webElementSS);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void webElementScreenShot(WebElement webElement, String ScrenShotIsmi) {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
		String timeStamp = ldt.format(zamanFormati);

		File webElementSS = new File("target/webElementSShots/" + ScrenShotIsmi + "+" + timeStamp + ".jpg");
		File geciciSS = webElement.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(geciciSS, webElementSS);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
