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
		Assert.assertEquals("�� ��������� ��� ������.\n����������, ��������� ��� e-mail.", basePage.driver.findElement(By.id("login-submit")).getText());
		
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
		Assert.assertEquals("��� ���������� ����� �������� ��������� ������:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
		Assert.assertEquals("������ ������ ���������", basePage.driver.findElement(By.cssSelector("p.alert-message")).getText());
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
		Assert.assertEquals("��� ���������� ����� �������� ��������� ������:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
		Assert.assertEquals("��������� ��� ���������� ����",  basePage.driver.findElement(By.cssSelector("p.alert-message")).getText());
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
		Assert.assertEquals("��� ����������� �������� ��������� ������:", basePage.driver.findElement(By.cssSelector("div.alert-title")).getText());
		Assert.assertEquals("���������� �����������, ��� �� �������� � ���������������� �����������", basePage.driver.findElement(By.cssSelector("p.alert-message")).getText());
	}
	
	
}
