package ua.rio.qa.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import ua.rio.base.pages.AddPost;
import ua.rio.base.test.BaseTest;

public class AddPostNotLogged extends BaseTest {

	
	@Test
	public void test02() throws InterruptedException {
				
		basePage.goToPostFreeAds();
		
		basePage.driver.findElement(By.id("change-category")).click();
		basePage.driver.findElement(By.linkText("Недвижимость")).click();
		basePage.driver.findElement(By.linkText("Квартиры")).click();
		basePage.driver.findElement(By.linkText("Продам")).click();
		basePage.driver.findElement(By.id("region_ac_title")).clear();
		basePage.driver.findElement(By.id("region_ac_title")).sendKeys("Киев");
		Thread.sleep(2000);
		basePage.driver.findElement(By.xpath(".//*[@id='geo']/div[1]/div/ul/li[1]")).click();
		basePage.driver.findElement(By.id("item-metro-ddlink")).click();
		Thread.sleep(1000);
		basePage.driver.findElement(By.linkText("Житомирская")).click();
		basePage.driver.findElement(By.id("profile-addr-addr")).clear();
		basePage.driver.findElement(By.id("profile-addr-addr")).sendKeys("Лепсе 34");
	    
	    new Select(basePage.driver.findElement(By.id("item-types-select"))).selectByVisibleText("Продам");
	    basePage.driver.findElement(By.xpath("(//input[@name='d[389][148]'])[2]")).click();
	    new Select(basePage.driver.findElement(By.name("d[389][23]"))).selectByVisibleText("Кирпичный");
	    basePage.driver.findElement(By.id("price_val")).clear();
	    basePage.driver.findElement(By.id("price_val")).sendKeys("99958");
	    basePage.driver.findElement(By.id("item-price-torg")).click();
	    basePage.driver.findElement(By.id("item-price-bart")).click();
	    
	    File file = new File("resources/merry.jpg");
	    basePage.driver.findElement(By.name("file")).sendKeys(file.getAbsolutePath());
	    
	    //basePage.driver.findElement(By.xpath(".//*[@id='item-img-upload']/input")).click();
	    //Thread.sleep(10000);
		/*
	    
	    basePage.driver.findElement(By.linkText("Изменить город")).click();
	    // wait for element presents
	    Thread.sleep(1000);
	    WebElement subMenu = basePage.driver.findElement(By.id("region_ac_title"));
	    subMenu.clear();
	    
	    subMenu.sendKeys(AddPost.City());
	    // -//-
	    Thread.sleep(1000);
	    WebElement subMenu2 = basePage.driver.findElement(By.cssSelector("li[value=\""+AddPost.CityNumber()+"\"]"));
	    subMenu2.click();
	    basePage.driver.findElement(By.xpath("(//button[@name=''])[3]")).click();
	    
	    basePage.driver.findElement(By.name("name")).clear();
	    basePage. driver.findElement(By.name("name")).sendKeys(randomString(12));
	    basePage.driver.findElement(By.name("email")).clear();
	    basePage.driver.findElement(By.name("email")).sendKeys(randomString(12)+"@"+randomString(3)+".ru");
	    basePage.driver.findElement(By.xpath("(//button[@name=''])[2]")).click();
	    
	    assertEquals("Вы успешно создали объявление!", basePage.driver.findElement(By.cssSelector("h2")).getText());
		
		*/
	}
	
	
}

	
