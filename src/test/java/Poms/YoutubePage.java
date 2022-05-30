package Poms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubePage {
	
	private String inputTextLoc = "//input[@name = 'q']";
	private String firstResultLoc = "//h3[@class='LC20lb MBeuO DKV0Md']";
    public WebDriver driver;
    private String pageLoc = "//*[contains(text(), 'YouTube')]";
    
    

	public YoutubePage(WebDriver driver) {
		
		super();
		this.driver = driver;
		
		// TODO Auto-generated constructor stub
	}

	public boolean writeSearch(String searchValue) {
		boolean flag = false;
		try {
			WebElement inputText = driver.findElement(By.xpath(inputTextLoc));//se identifica el elemento			
	        inputText.sendKeys(searchValue);
	    	inputText.sendKeys(Keys.ENTER);//simula un enter 
			flag = true;
		}
		catch (Exception e) {
			System.out.println("Something went wrong :( ");
			e.printStackTrace();
		}
		return flag;
	   }

	public boolean clickFirstResult() {
		boolean flag = false;

	try {
		
		WebElement firstResult = driver.findElement(By.xpath(firstResultLoc));
		
		firstResult.click();
	    flag = true;
	}
	catch (Exception e) {
		System.out.println("Something went wrong :( ");
		e.printStackTrace();
	}
	return flag;
	   }

	public boolean clickSeleniumPage() {
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(pageLoc));
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();

		}

		return flag;

	 }
	}

