package tests.MyDay;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class M01 extends TestBase {
	@Test
	public void calisma(){
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL);
		actions.keyDown(Keys.ALT);
		actions.keyDown(Keys.DELETE);
		ReusableMethods.bekle(5);
	}
}
