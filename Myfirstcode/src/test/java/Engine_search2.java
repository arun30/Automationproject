

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Selenium.Utils.SeleniumUtils;

public class Engine_search2 extends SeleniumUtils {

	WebDriver driver;
	
	@BeforeSuite
	public void presetup(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/Extent-Report/Report.html", true);
		extent
        .addSystemInfo("Host Name", "SoftwareTestingMaterial")
        .addSystemInfo("Environment", "Win10 Chrome")
        .addSystemInfo("Client", "Enginetech");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}
	
/*	@BeforeMethod 
	public void setup() {
		//logger = extent.startTest("Verify error " + message); 
		launchBrowser("chrome", "http://autopartsasia.org/ETcatalog/");

	}*/
	
	@Test
	public void applnsearch() {
		try {
			logger = extent.startTest("appln search");
			launchBrowser("chrome", "http://autopartsasia.org/ETcatalog/");		
			waitForWebElement("link", "Engine parts", 10);
			verifyTitle("Enginetech Catalog");
			clickElement("xpath", "/html/body/header/div[2]/div/div/div[3]/ul/li[1]/a");
			verifyTitle("VEHICLE APPLICATION");
			clickElement("xpath", "/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/ul/li[6]");
			verifyTitle("AUDI - TRUCK, VAN, SUV");
			clickElement("xpath", "/html/body/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/ul/li[6]");
			logger.log(LogStatus.PASS, "Verified application search " , logger.addScreenCapture(takeScreenshot("applnpassed.png")));
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "application search failed " + e.getMessage() , logger.addScreenCapture(takeScreenshot("applnfailed.png")));
			e.printStackTrace();
		}
		finally {
			
			extent.endTest(logger);
		
		}
	
		
		
		
		
		
	/*	
		driver.findElement(By.xpath("//*[@id=\"2.0L / 1984 DOHC L4 16V CPMB Turbo 82.50mm Bore 14-17\"]")).click();
		if(driver.getPageSource().contains("Part #")){
			System.out.println("part Text is present");
			}else{
			System.out.println("part Text is absent");
			}*/
		
		//driver.findElement(arg0)
		
	}
	
	
	
	
	
	@AfterMethod
	public void close() {
		closeBrowser();
	}
	
	
	@AfterSuite
	public void cleanup(){
		extent.flush();
		extent.close();
	}
	
	
	
}
