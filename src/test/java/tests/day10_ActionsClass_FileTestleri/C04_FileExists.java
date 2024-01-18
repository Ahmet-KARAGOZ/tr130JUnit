package tests.day10_ActionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
	@Test
	public void test01(){
		String dosyaYolu = "src/test/java/tests/day10_ActionsClass_FileTestleri/deneme.txt";
		System.out.println(Files.exists(Paths.get(dosyaYolu)));

		Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

		System.out.println(System.getProperty("user.dir"));

		String absoluteDosyaYolu = System.getProperty("user.dir") + "/src/test/java/tests/day10_ActionsClass_FileTestleri/deneme.txt";
		Assert.assertTrue(Files.exists(Paths.get(absoluteDosyaYolu)));

	}
}
