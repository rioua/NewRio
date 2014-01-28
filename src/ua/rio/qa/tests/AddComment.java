package ua.rio.qa.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ua.rio.base.test.BaseTest;

public class AddComment extends BaseTest {
	
	@Test
	public void test05() throws InterruptedException {
		autorisationUser();
		Thread.sleep(2000);
		basePage.driver.findElement(By.cssSelector("a.feedback.text-orange > span")).click();
		
		basePage.driver.findElement(By.linkText("���� ���������")).click();
		Thread.sleep(1000);
		basePage.driver.findElement(By.linkText("������ �� �����")).click();
		
		basePage.driver.findElement(By.id("message")).clear();
		basePage.driver.findElement(By.id("message")).sendKeys(randomString(100));
		
		basePage.driver.findElement(By.xpath("//form[@id='contactForm']/fieldset/button")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals("����������\n\n� ��������� ����� �� ���������� ���� ������", basePage.driver.findElement(By.cssSelector("div.alert.alert-info > span")).getText());
	}
	
	
}
