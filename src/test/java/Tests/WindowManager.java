package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Poms.GooglePage;
import Poms.PracticePage;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WindowManager {
	
	private WebDriver driver;
    private GooglePage google ;
    private PracticePage practicePage;
	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test() throws InterruptedException {
		// Goes to page
		google = new GooglePage(driver);
		practicePage = new PracticePage(driver);
		driver.get("http://google.com");
		google.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Searchs for desired item
		assertTrue(google.writeSearch("Selenium framework practie form"));
		// Clicks first result
		assertTrue(google.clickSeleniumPage());
		// Clicks button
		assertTrue(practicePage.clickAlertButton());
		Thread.sleep(1000);
		// accepts alert
		assertTrue(practicePage.acceptAlert());
		// clicks new window button
		assertTrue(practicePage.clickNewWindowButton());
		// Switches to window
		Thread.sleep(1000);
		assertTrue(practicePage.switchToWindowByIndex(1));
		// Goes to google on second page
		Thread.sleep(1000);
		driver.get("http://google.com");
		assertTrue(practicePage.switchToWindowByIndex(0));
		// Clicks on new tab
		assertTrue(practicePage.clickTabWindowButton());
		Thread.sleep(1000);
		// Changes to new tab
		// assertTrue(practicePage.switchWindowByTitle("Selenium Framework | Selenium,
		// Cucumber, Ruby, Java et al."));
		assertTrue(practicePage.switchWindowByTitle("Google"));
		Thread.sleep(1000);
		driver.get("http://youtube.com");
		Thread.sleep(5000);

		
	}
	
	@After
	public void teardown() {
		//driver.quit();

    }
}
