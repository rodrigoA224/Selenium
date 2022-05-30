package Clase2.clase2;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;
import Poms.YoutubePage;

public class youtube {
	private WebDriver driver;
	private GooglePage google;
	private YoutubePage youtube;
	private ChromeOptions opc = new ChromeOptions();
	

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
		driver = new ChromeDriver();
		opc.addArguments("--headlesss");
		
	}

	@Test
	public void test() throws InterruptedException {
		// Goes to page
		youtube = new YoutubePage(driver);
		google = new GooglePage(driver);
		Scanner entrada=new Scanner (System.in);
		System.out.println("Ingresa el nombre de tu cancion");
		String a = entrada.nextLine();
		
		
		
		
		driver.get("http://google.com");

		
		assertTrue(google.writeSearch("Youtube"));	       
	    assertTrue(google.clickFirstResult());	        
	    Thread.sleep(2000);		
		WebElement searchbox = driver.findElement(By.name("search_query"));
		searchbox.click();
		searchbox.sendKeys(a);
		Thread.sleep(2000);
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement video = driver.findElement(By.id("title-wrapper"));
		video.click();
		System.out.println(driver.getTitle());
		System.out.println("Si jala pero aveces es mañoso ");
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(6000);
		// driver.quit();
	}

}