package ua.rio.base.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import static org.testng.Assert.*;

public class BasePage {
	
	public static   WebDriver driver;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(tagName="html")
	protected WebElement htmlTag;
	
	@FindBy(xpath=".//*[@id='header']/a")
	private WebElement siteLogo;
	
	//@FindBy(c="span..firepath-matching-node")
	//private WebElement addComment;
	
	@FindBy(xpath=".//*[@id='nav']/div[1]/a[2]")
	private WebElement registration;
	
	/*public BasePage clickAddComment() {
		addComment.click();
		return this;
	} */
	
	public BasePage registration() {
		registration.click();
		return this;
	}
	public  BasePage clickSiteLogo() {
		siteLogo.click();
		return this;
	}
	
	public WebElement FindByXpath(String str) {
		return driver.findElement(By.xpath(str));
	}
	public void hoverMouse(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public <T extends BasePage> T checkTextPresent(String text) {
		String pageSource = htmlTag.getText();
		boolean isTextPresent = pageSource.indexOf(text) != -1;
		assertTrue(isTextPresent);
		return (T) this;
	}
	
	public void  goToPostFreeAds() {
		WebElement ads = driver.findElement(By.xpath(".//*[@id='add-wrapper']/a"));
		ads.click();
	}
	
}


