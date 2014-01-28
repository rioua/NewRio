package ua.rio.qa.tests;


import ua.rio.base.test.BaseTest;
import ua.rio.base.pages.AddPost;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class AddPostLogged extends BaseTest {
	private boolean acceptNextAlert = true;
	
	@Test
	public void test01() throws InterruptedException {

		autorisationUser();
		
		basePage.goToPostFreeAds();

		basePage.driver.findElement(By.id("title")).clear();
		basePage.driver.findElement(By.id("title")).sendKeys("HALLLLLLLLLL");
		basePage.driver.findElement(By.id("item-category-ddlink")).click();
		basePage.driver.findElement(By.cssSelector("img.cat-thumb")).click();
		new Select(basePage.driver.findElement(By.id("item-cat-2"))).selectByVisibleText("Квартиры");
		new Select(basePage.driver.findElement(By.id("item-cat-3"))).selectByVisibleText("Продам");
		basePage.driver.findElement(By.name("d[389][148]")).click();
		basePage.driver.findElement(By.name("d[389][17]")).click();
	    new Select(basePage.driver.findElement(By.name("d[389][23]"))).selectByVisibleText("Кирпичный");
	    basePage.driver.findElement(By.name("d[389][18]")).clear();
	    basePage.driver.findElement(By.name("d[389][18]")).sendKeys("5");
	    basePage.driver.findElement(By.name("d[389][19]")).clear();
	    basePage.driver.findElement(By.name("d[389][19]")).sendKeys("67");
	    basePage.driver.findElement(By.name("d[389][20]")).clear();
	    basePage.driver.findElement(By.name("d[389][20]")).sendKeys("54");
	    basePage.driver.findElement(By.name("d[389][21]")).clear();
	    basePage.driver.findElement(By.name("d[389][21]")).sendKeys("21");
	    basePage.driver.findElement(By.name("d[389][22]")).clear();
	    basePage.driver.findElement(By.name("d[389][22]")).sendKeys("11");
	    basePage.driver.findElement(By.name("d[389][24]")).clear();
	    basePage.driver.findElement(By.name("d[389][24]")).sendKeys("9");
	    basePage.driver.findElement(By.id("item-phone")).click();
	    basePage.driver.findElement(By.id("item-phone")).clear();
	    basePage.driver.findElement(By.id("item-phone")).sendKeys("0632114894");
	    basePage.driver.findElement(By.id("descr")).click();
	    basePage.driver.findElement(By.id("descr")).clear();
	    basePage.driver.findElement(By.id("descr")).sendKeys("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
	    
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
	    basePage. driver.findElement(By.name("name")).sendKeys("Alex");
	    
	    //other-contacts
	    CheckElement(By.id("icq-contact"));
	    CheckElement(By.id("skype-contact"));
	    CheckElement(By.id("mailru-contact"));
	    //
	    
	    basePage.driver.findElement(By.xpath("(//button[@name=''])[2]")).click();
	    Thread.sleep(1000);
	    
		if (IsElementVisible(basePage.driver.findElement(By
				.xpath(".//*[@id='alert_global']/div"))) == true) {
			deletePost();
			System.out.println("Біло не удалено объявление");
			assertTrue(false);
		}
	   
	    basePage.driver.findElement(By.linkText("посмотреть на него")).click();
	    assertEquals("HALLLLLLLLLL", basePage.driver.findElement(By.cssSelector("h1")).getText());
	    deletePost();
	   
	}

	private void deletePost() throws InterruptedException {
		    basePage.driver.findElement(By.id("userMenuDropdownLink")).click();
		    basePage.driver.findElement(By.linkText("Мои объявления")).click();
		    
		    Actions action = new Actions(basePage.driver);     
		    WebElement hoverItem = basePage.driver.findElement(By.xpath(".//*[@id='obj-boxes']/div[1]/div[1]"));
		    action.moveToElement(hoverItem).perform();
		    

			//Wait for elements presents
		    Thread.sleep(1000);
		    
		    WebElement subMenu3 = basePage. driver.findElement(By.xpath(".//*[@id='obj-boxes']/div[1]/div[1]/div/a[2]"));
		    subMenu3.click();
		    
		    assertTrue(closeAlertAndGetItsText().matches("^Вы действительно хотите удалить объявление[\\s\\S]$"));
		    
		    basePage.driver.findElement(By.id("reason2")).click();
		    basePage.driver.findElement(By.id("proceed-action")).click();
		    basePage.clickSiteLogo();
		
	}

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = basePage.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
	    
	public boolean TryFindElement(By by, WebElement element)
	{
	    try {
	        element = basePage.driver.findElement(by);
	        return true;
	    }
	    catch (NoSuchElementException ex) {
	        return false;
	    }
	    
	}

		public boolean IsElementVisible(WebElement element)	{
	    return element.isDisplayed() && element.isEnabled();
	}
		
		public void CheckElement(By by) {
			WebElement element = null;
			if (TryFindElement(by,  element )) {
		    	element = basePage.driver.findElement(by);
		        boolean visible = IsElementVisible(element);
		        if  (visible) {
		            basePage.driver.findElement(by).click();
		            basePage.driver.findElement(by).clear();
		            basePage.driver.findElement(by).sendKeys(randomNumberString(7));
		        } else 	if (by.equals(By.id("icq-contact"))) {
		        	basePage.driver.findElement(By.xpath(".//*[@id='other-contacts']/a[1]")).click();
		        	} else if (by.equals(By.id("skype-contact"))) {
		        	basePage.driver.findElement(By.xpath(".//*[@id='other-contacts']/a[2]")).click();
		        	} else if (by.equals(By.id("mailru-contact")) ) {
		        	basePage.driver.findElement(By.xpath(".//*[@id='other-contacts']/a[3]")).click();
		        	}
		        	
		        	basePage.driver.findElement(by).click();
		            basePage.driver.findElement(by).clear();
		            basePage.driver.findElement(by).sendKeys(randomNumberString(7));
		    }
	    }
	}


