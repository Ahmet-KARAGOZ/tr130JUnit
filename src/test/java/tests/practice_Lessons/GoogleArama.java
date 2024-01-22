package tests.practice_Lessons;

import org.junit.Test;
import utilities.TestBase;
/*
BeforeClass ile driver'i oluşturun ve class icinde static yapin
Maximize edin ve 10 sn bekletin
https://www.gooqle.com adresine gidin
1-arama kutusuna "12 Angry Men" yazip, cikan sonuc sayisini yazdirin
2-arama kutusuna "Vizontele" yazip, cikan sonuc sayisini yazdirin
3-arama kutusuna "Saving Private Ryan" yazip, cikan sonuc sayisini yazdirin
AfterClass ile kapatin.
 */
public class GoogleArama extends TestBase {
	String isim ="";
	@Test
	public void test01(){
		driver.get("https://www.google.com");
		isim = "Şaban";
		System.out.println(isim);

	}
}
