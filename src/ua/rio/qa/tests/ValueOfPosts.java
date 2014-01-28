package ua.rio.qa.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.rio.base.pages.SearchPage;
import ua.rio.base.test.BaseTest;

public class ValueOfPosts extends BaseTest {

	
	@Test
	public void test04() throws InterruptedException {
		
		basePage.driver.findElement(By.xpath(".//*[@id='main-nav']/li[1]/a")).click();
		
		System.out.println("All Ok1");
		long  num = SearchPage.NumOfPosts("items-search-cnt");
		System.out.println("All Ok2");
		Assert.assertTrue(num > 100000);
		
	}
	
}