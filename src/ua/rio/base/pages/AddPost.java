package ua.rio.base.pages;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ua.rio.base.page.BasePage;

public class AddPost extends BasePage {
	static int rndNumber = 0;
	
	public AddPost(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static String City() {
		String[] City = { "Киев", "Винница", "Днепропетровск", "Донецк",
				"Житомир", "Запорожье", "Ивано-Франковск", "Кировоград",
				"Львов", "Луганск", "Луцк", "Николаев", "Одесса", "Полтава",
				"Ровно" };
		Random rnd = new Random(System.currentTimeMillis());
		rndNumber = rnd.nextInt((int) City.length);
		String str = City[rndNumber];
		return str;
	}

	public static int CityNumber() {
		int[] CityNumber = { 4216, 4278, 4315, 4331, 4359, 4395, 4414, 4460,
				4517, 4478, 4298, 4540, 4559, 4581, 4601 };

		return CityNumber[rndNumber];

	}

}
