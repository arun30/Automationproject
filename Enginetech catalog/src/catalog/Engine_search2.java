package catalog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Engine_search2 {

	WebDriver driver;
	
	@BeforeMethod 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://autopartsasia.org/ETcatalog/");
		
	}
	
	@Test
	public void applnsearch() {
		if(driver.getPageSource().contains("Engine Part Search")) {
			System.out.println("Text is present");
		}else{
		System.out.println("Text is absent");
		}
	
		
		driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/ul/li[1]/a")).click();
		if(driver.getPageSource().contains("VEHICLE APPLICATION")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/ul/li[6]")).click();
		if(driver.getPageSource().contains("AUDI - TRUCK, VAN, SUV")){
			System.out.println("audi Text is present");
			}else{
			System.out.println("audi Text is absent");
			}
		
		driver.findElement(By.xpath("//*[@id=\"2.0L / 1984 DOHC L4 16V CPMB Turbo 82.50mm Bore 14-17\"]")).click();
		if(driver.getPageSource().contains("Part #")){
			System.out.println("part Text is present");
			}else{
			System.out.println("part Text is absent");
			}
		
		//driver.findElement(arg0)
		
	}
	
	
	
	
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	
	
	
	
	
}
