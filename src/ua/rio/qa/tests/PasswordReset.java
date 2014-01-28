package ua.rio.qa.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ua.rio.base.test.BaseTest;

public class PasswordReset extends BaseTest {

	@Test
	public void test07() throws InterruptedException {		
		basePage.registration();
		
		basePage.driver.findElement(By.xpath(".//*[@id='content']/div/div[4]/div[2]/a")).click();
		
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys(randomString(12)+"@"+randomString(3)+".ru");
		basePage.driver.findElement(By.id("login-submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("При восстановлении пароля возникли следующие ошибки:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
				
		basePage.driver.findElement(By.id("email")).clear();
		basePage.driver.findElement(By.id("email")).sendKeys("alexxxsb20@mail.ru");
		basePage.driver.findElement(By.id("login-submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("На ваш e-mail были высланы инструкции по смене пароля.", basePage.driver.findElement(By.id("login-submit")).getText());
		
	}
}
