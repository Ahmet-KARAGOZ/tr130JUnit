package tests.day12_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;
/*
1.“https://testotomasyonu.com/webtables” adresine gidin
2.Web table tum body’sini yazdirin
3. Web tablosunda “Comfortable Gaming Chair” bulundugunu test edin
4. Web table’daki body de satir sayisinin 5 oldugunu test edin
5. Tum satirlari yazdirin
6. Web table’daki sutun sayisinin 4 olduğunu test edin
7. 3.sutunu yazdirin
8. Tablodaki basliklari yazdirin
9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
10. 4.satirdaki category degerinin “Furniture” oldugunu test edin
 */

public class C01_KlasikHtmlKodlariylaWebTables extends TestBase {
	@Test
	public void test01(){
		driver.get("https://testotomasyonu.com/webtables");
		WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
		System.out.println(tumBodyElementi.getText());

		String expTabloIcerik = "Comfortable Gaming Chair";
		String actTumBody = tumBodyElementi.getText();

		Assert.assertTrue(actTumBody.contains(expTabloIcerik));

		List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
		int expSatirSayisi = 5;
		int actStatirSayisi = satirlarListesi.size();

		Assert.assertEquals(expSatirSayisi,actStatirSayisi);


		System.err.println("Satırlar Listesi : ");
		List<String> satirYazilariList = ReusableMethods.stringListeCevir(satirlarListesi);
		System.out.println(satirYazilariList);

		List<WebElement> ucuncuSatirDatalarList = driver.findElements(By.xpath("//tbody/tr[3]/td"));
		int expSutunSayisi = 4;
		int actSutunSAyisi = ucuncuSatirDatalarList.size();
		Assert.assertEquals(expSutunSayisi,actSutunSAyisi);

		List<WebElement> ucuncuSutunDataList = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunDataList));

		WebElement baslikElementi = driver.findElement(By.tagName("thead"));
		System.out.println("Başlıklar : "+baslikElementi.getText());

		System.out.println("İstenen hücre : "+dataDondur(4,2));

		String expKategoriElementi = "Furniture";
		String actKategoriElementi = dataDondur(4,2);

		Assert.assertEquals(expKategoriElementi,actKategoriElementi);


	}

	public String dataDondur(int satirNO, int sutunNO){
		//       //tbody/tr[satirNo]/td[SutunNO]

		String dinamikXpath = "//tbody/tr["+ satirNO + "]/td[" + sutunNO +"]";
		WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));
		return istenenHucreElementi.getText();
	}
}
