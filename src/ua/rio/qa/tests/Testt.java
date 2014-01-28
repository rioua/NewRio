package ua.rio.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ua.rio.base.test.BaseTest;

public class Testt extends BaseTest {
	
	@Test
	public void test05() throws InterruptedException {
		basePage.driver.findElement(By.cssSelector("a.openPhotoModal > img")).click();
	   
	    	Thread.sleep(1000);

	    	for ( int i = 0; i < 100; i++ ) {
	    	basePage.driver.findElement(By.cssSelector("a.photo-preview-item > img")).click();
	    	basePage.driver.findElement(By.xpath("//img[contains(@src,'http://rio.rio-dev.shalb.com/files/images/items/356/356618bf7d9e5d1.jpg')]")).click();
	    	basePage.driver.findElement(By.xpath("//img[contains(@src,'http://rio.rio-dev.shalb.com/files/images/items/356/356618b1674e202.jpg')]")).click();
	    	basePage.driver.findElement(By.xpath("//img[contains(@src,'http://rio.rio-dev.shalb.com/files/images/items/356/356618ba4a01855.jpg')]")).click();
	    	basePage.driver.findElement(By.xpath("//img[contains(@src,'http://rio.rio-dev.shalb.com/files/images/items/356/356618b718a10f9.jpg')]")).click();
	    	}
	    	}
	}
	
	

