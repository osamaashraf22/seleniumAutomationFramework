package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.helper;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) 
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			String chromePath=System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("fireFox"))
		{
			String fireFoxPath=System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			String edgePath=System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
			System.setProperty("webdriver.msedgedriver.driver", edgePath);
			driver=new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://demo.nopcommerce.com/");

	}

	@AfterSuite
	public void stopDriver() 
	{
		driver.quit();
	}
	
	//take screenshot when test case fail and add it in screenshot folder 
	@AfterMethod
	public void screenShotOnFailure(ITestResult result)
	{
		if (result.getStatus() ==ITestResult.FAILURE)
		{
			System.out.println("Fail");
			System.out.println("Taking ScreenShot...");
			helper.captureScreenShot(driver, result.getName());
		}
		
	}

}
