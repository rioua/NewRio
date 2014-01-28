package ua.rio.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ua.rio.base.page.BasePage;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static int NumOfPosts(String strr) {
		String str = driver.findElement(By.id(strr)).getText();

		int start = 0;
		int end = str.length() - 11;
		char buf[] = new char[end - start];
		str.getChars(start, end, buf, 0);
		
		// System.out.println("All Ok1");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buf.length; i++) {
			sb.append(buf[i]);
		}
		// System.out.println("All Ok2");
		return Integer.parseInt(sb.toString());
	}
}
