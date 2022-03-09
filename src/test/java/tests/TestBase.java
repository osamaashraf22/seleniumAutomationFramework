package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
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
		
		else if (browserName.equalsIgnoreCase("headless")) 
		{
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					System.getProperty("user.dir") + "\\drivers\\phantomjs.exe");
			String []phantomJsArgs= {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver=new PhantomJSDriver(caps);
		}
		
		else if (browserName.equalsIgnoreCase("chrome-headless")) 
		{
			String chromePath=System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver=new ChromeDriver(options);
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
