package tests.day11_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;
/*

 */

public class C03_Cookies extends TestBase {
	@Test
	public void test01(){
		driver.get("https://www.walmart.com");
		Set<Cookie> cookieSet = driver.manage().getCookies();

		int siraNo = 1;
		for (Cookie eachCookie : cookieSet){
			System.out.println(siraNo + "------" + eachCookie);
			siraNo++;
		}

		Assert.assertTrue(cookieSet.size()>5);

		Assert.assertEquals(driver.manage().getCookieNamed("mobileweb").getValue(),"0");


		Cookie cookieYeni = new Cookie("en sevdigim cookie" , "cikolatali");
		driver.manage().addCookie(cookieYeni);

		System.out.println("---------------------------------------------------------------------------------------------------");

		cookieSet = driver.manage().getCookies();

		siraNo = 1;
		for (Cookie eachCookie : cookieSet){
			System.out.println(siraNo + "------" + eachCookie);
			siraNo++;
		}

		Assert.assertEquals(driver.manage().getCookieNamed("en sevdigim cookie").getValue(),"cikolatali");

		driver.manage().deleteCookieNamed("mobileweb");

		System.out.println("---------------------------------------------------------------------------------------------------");

		cookieSet = driver.manage().getCookies();

		siraNo = 1;
		boolean mobileWebVarmi = false;
		for (Cookie eachCookie : cookieSet){
			System.out.println(siraNo + "------" + eachCookie);
			siraNo++;
			if (eachCookie.getName().equals("mobileweb")){
				mobileWebVarmi = true;
			}
		}
		Assert.assertFalse(mobileWebVarmi);

		driver.manage().deleteAllCookies();
		cookieSet = driver.manage().getCookies();
		Assert.assertTrue(cookieSet.isEmpty());




		ReusableMethods.bekle(1);

	}
}
