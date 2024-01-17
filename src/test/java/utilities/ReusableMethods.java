package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
	public static void bekle(int saniye){
		try {
			Thread.sleep(saniye*1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<String> stringListeCevir(List<WebElement> webElementList){
		List<String> stringLst = new ArrayList<>();
		for (WebElement eachElement : webElementList ){
			stringLst.add(eachElement.getText());

		}
		return stringLst;
	}

	public static void titleIleWindowDegistir(String hedefTitle, WebDriver driver){
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
