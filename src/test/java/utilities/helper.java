package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class helper
{
	//method to take screen shot when test cases fail
	
	public static void captureScreenShot(WebDriver driver , String screenshotName)
	{
		Path dest=Paths.get("./ScreenShots",screenshotName +".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream output=new FileOutputStream(dest.toString());
			output.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			output.close();
		} catch (IOException e) {
			System.out.println("Exception while screenshot " +e.getMessage());
			e.printStackTrace();
		}
		
	}

}
