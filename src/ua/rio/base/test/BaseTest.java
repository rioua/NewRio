package ua.rio.base.test;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Assert;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ua.rio.base.page.BasePage;

public class BaseTest {
	public StringBuffer verificationErrors = new StringBuffer();

	public BasePage basePage;
	
	
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"testServer"})
	public void init(String testServer) {
		basePage = PageFactory.initElements(new FirefoxDriver(), BasePage.class);
		basePage.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		basePage.driver.manage().window().maximize();
		basePage.driver.get(testServer);
	}

	@AfterMethod(alwaysRun=true)
	public void destruct() throws InterruptedException {
		Thread.sleep(5000);
		basePage.driver.quit();
		String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      AssertJUnit.fail(verificationErrorString);
	    }
	}
	
	
	
	
	private void fail(String verificationErrorString) {
		System.out.println("Верификация не прошла" + verificationErrorString);
		
	}

	public void autorisationUser() {
		basePage.driver.findElement(By.linkText("Вход")).click();
		basePage.driver.findElement(By.cssSelector("a.iconWrapper > div.txt")).click();
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys("alexxxsb21@mail.ru");
		basePage.driver.findElement(By.id("password")).clear();
		basePage.driver.findElement(By.id("password")).sendKeys("qwerty");
		basePage.driver.findElement(By.id("login-submit")).click();
	}
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String num = "0123456789";
	static Random rnd = new Random();

	public String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i <= len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public String randomNumberString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i <= len; i++)
			sb.append(num.charAt(rnd.nextInt(num.length())));
		return sb.toString();
	}
	
	public boolean isElementPresent(By by) {
	    try {
	    	basePage.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  public boolean isAlertPresent() {
	    try {
	    	basePage.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	
	  // generate a string in (Min - Max range)
	  public int rndMinMax(int Min, int Max) {
		  return Min + (int)(Math.random() * ((Max - Min) + 1));
	  }
}