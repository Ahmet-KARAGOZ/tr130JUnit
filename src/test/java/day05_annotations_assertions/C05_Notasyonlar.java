package day05_annotations_assertions;

import org.junit.*;

public class C05_Notasyonlar {
	@BeforeClass
	public static void setupClass(){
		System.out.println("BeforeClass çalıştı");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("AfterClass run");
	}

	@Before
	public void setup(){
		System.out.println("Before run");
	}

	@After
	public void teardown(){
		System.out.println("After run");
	}
	@Test
	public void test01(){
		System.out.println("Test01 çalıştı");
	}
	@Test
	public void test02(){
		System.out.println("Test02 çalıştı");
	}
	@Test
	public void test03(){
		System.out.println("Test03 çalıştı");
	}
}
