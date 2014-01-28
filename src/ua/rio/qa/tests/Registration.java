package ua.rio.qa.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ua.rio.base.page.BasePage;
import ua.rio.base.test.BaseTest;

public class Registration extends BaseTest {
	String str = randomString(9);

	
	@Test //#1
	public void test01() throws InterruptedException {		
		basePage.registration();
		
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys(randomString(12)+"@"+randomString(3)+".ru");
		basePage.driver.findElement(By.id("pass1")).clear();
		basePage.driver.findElement(By.id("pass1")).sendKeys(str);
		basePage.driver.findElement(By.id("pass2")).clear();
		basePage.driver.findElement(By.id("pass2")).sendKeys(str);
		
		basePage.driver.findElement(By.id("accept")).click();
		
		basePage.driver.findElement(By.id("login-submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("Мы отправили вам письмо.\nПожалуйста, проверьте ваш e-mail.", basePage.driver.findElement(By.id("login-submit")).getText());
		
	}
	
	@Test //#2
	public void test02() throws InterruptedException {		
		basePage.registration();
		
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys(randomString(12)+"@"+randomString(3)+".ru");
		basePage.driver.findElement(By.id("pass1")).clear();
		basePage.driver.findElement(By.id("pass1")).sendKeys(str);
		basePage.driver.findElement(By.id("pass2")).clear();
		basePage.driver.findElement(By.id("pass2")).sendKeys(randomString(12));
		
		basePage.driver.findElement(By.id("accept")).click();
		
		basePage.driver.findElement(By.id("login-submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("При заполнении формы возникли следующие ошибки:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
		Assert.assertEquals("Пароли должны совпадать", basePage.driver.findElement(By.cssSelector("p.alert-message")).getText());
	}

	@Test //#3
	public void test03() throws InterruptedException {		
		basePage.registration();
		
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys(randomString(12)+"@"+randomString(3)+".ru");
		basePage.driver.findElement(By.id("pass1")).clear();

		basePage.driver.findElement(By.id("pass2")).clear();
		
		basePage.driver.findElement(By.id("accept")).click();
		
		basePage.driver.findElement(By.id("login-submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("При заполнении формы возникли следующие ошибки:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
		Assert.assertEquals("Заполните все отмеченные поля",  basePage.driver.findElement(By.cssSelector("p.alert-message")).getText());
	}
	
	@Test //#4 - visout accept of checkbox
	public void test04() throws InterruptedException {		
		basePage.registration();
		
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys(randomString(12)+"@"+randomString(3)+".ru");
		basePage.driver.findElement(By.id("pass1")).clear();
		basePage.driver.findElement(By.id("pass1")).sendKeys(str);
		basePage.driver.findElement(By.id("pass2")).clear();
		basePage.driver.findElement(By.id("pass2")).sendKeys(str);
		
		basePage.driver.findElement(By.id("login-submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("При регистрации возникли следующие ошибки:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
		Assert.assertEquals("Пожалуйста подтвердите, что Вы согласны с пользовательским соглашением", basePage.driver.findElement(By.cssSelector("p.alert-message")).getText());
	}
	
	
}
