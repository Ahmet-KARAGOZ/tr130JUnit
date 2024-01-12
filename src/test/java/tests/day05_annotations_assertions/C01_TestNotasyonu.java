package tests.day05_annotations_assertions;

import org.junit.Ignore;
import org.junit.Test;

public class C01_TestNotasyonu {

	/*
	Toplu çalıştırmada herhangi bir sırraalama olmadan çalışır
	Çalışmsını istemediğimiz için @Ignore kullanılır.
	 */
	@Test
	public void testOtomasyonuTest(){
		System.out.println("Test otomsyonu çalıştı");
	}
	@Test @Ignore
	public void youtubeTest(){
		System.out.println("Youtube testi çalıştı");
	}
	@Test
	public void qwertyTest(){
		System.out.println("qwerty Tesi çalıştı");
	}
}
