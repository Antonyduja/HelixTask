package commonFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class setUp {
	
		public Properties prop = new Properties();
		public Properties output = new Properties();
		public WebDriver driver;
	
	public Properties readPropertiesFile()
	{
		InputStream input;
		try {
			input = new FileInputStream("C:\\Antony\\helixTask\\cofiguration.properties");
			prop.load(input);

		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	public Properties writePropertiesFile() throws IOException 
	{
		String path = "C:\\Antony\\helixTask\\pagetitles.properties";
		File file = new File(path);
		file.createNewFile();
		try 
		{
			FileOutputStream titles = new FileOutputStream(file);
			output.store(titles,"Page titles");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
@BeforeSuite
public void openBrowser()
{
	readPropertiesFile();
	System.setProperty("webdriver.chrome.driver", prop.getProperty("driverLocation"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@AfterSuite
public void tearDown()
{
	driver.quit();
}
}
