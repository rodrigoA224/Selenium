package Clase2.clase2;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class google {
	private WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
		driver = new ChromeDriver();
	}


	@Test
	public void test() throws InterruptedException {
		// Goes to page
		driver.get("http://google.com");

		Thread.sleep(2000);
		WebElement inputText = driver.findElement(By.xpath("//input[@name = 'q']"));// Se identifica el elemento
		inputText.sendKeys("Automation Practice");// Se le manda el texto a escribir
		inputText.sendKeys(Keys.ENTER);// Simula un enter
		Thread.sleep(2000);// Espera 2 segundos
		WebElement firstResult = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
		firstResult.click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='sf-with-ul']"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("DRESSES")) {
				list.get(i).click();
				System.out.println(i);
			}

		}

	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(6000);
		// driver.quit();
	}

}