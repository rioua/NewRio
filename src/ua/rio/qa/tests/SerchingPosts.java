package ua.rio.qa.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ua.rio.base.pages.SearchPage;
import ua.rio.base.test.BaseTest;

public class SerchingPosts extends BaseTest {
	String [] str = {"дом", "гараж", "мопс", "ваз", "хаски"};
	Integer [] number = {14000, 2000, 60, 550, 40 };
	
	@Test
	public void test03() throws InterruptedException {
		for (int i = 0; i < str.length; i++) {
			basePage.driver.findElement(By.name("q")).clear();
			basePage.driver.findElement(By.name("q")).sendKeys(str[i]);
			basePage.driver.findElement(By.id("search-submit")).click();
			
			int  num = SearchPage.NumOfPosts("items-search-cnt");
			
			if (num < number[i]) {
				System.out.println(i + " - на этом проходе вылет");
			}
			Assert.assertTrue(num > number[i]);

			}
		}
	}


