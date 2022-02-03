package Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_Browser {
	public static WebDriver driver;
	public static String path;
//	public static ExtentHtmlReporter htmlReporter;
//	public static ExtentReports extent;
//	public static ExtentTest test;
	
//@BeforeTest	
//public void abc()
//{
//	//htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-ouput2//MyReport.html");
//	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport2.html");
//	
//	htmlReporter.config().setDocumentTitle("Automation Report");//Title of the Report
//	htmlReporter.config().setReportName("Functional Report");//Name of the Report
//	htmlReporter.config().setTheme(Theme.DARK);
//	
//	extent=new ExtentReports();
//	extent.attachReporter(htmlReporter);
//	extent.setSystemInfo("Hostname", "localhost");
//	extent.setSystemInfo("OS", "Windows10");
//	extent.setSystemInfo("Tester Name", "Sampada");
//	extent.setSystemInfo("Browser", "Chrome");
//	
//}
@BeforeSuite
public void LaunchBrowser()
{
	WebDriverManager.chromedriver().setup();
	
	
	driver=new ChromeDriver();
	//Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	
	//Deleting Cookies
	driver.manage().deleteAllCookies();
	
	//Maximize browser window
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
}

//@AfterMethod
//public void teardown(ITestResult result) throws IOException
//{
//	if(result.getStatus()==ITestResult.FAILURE)
//	{
//		test.log(Status.FAIL, "Test Case Failed"+result.getName());//to add name of method of Testcase
//		test.log(Status.FAIL, "Test Case Failed"+result.getThrowable());//To log error in Extent Report
//		
//		String screenshotpPath=Launch_Browser.getScreenShot(driver, result.getName());
//	test.addScreenCaptureFromPath(screenshotpPath);//adding Screen shot
//	}
//	else if(result.getStatus()==ITestResult.SKIP)
//	{
//		test.log(Status.SKIP, "Test Case Failed"+result.getName());//to add name of method of Testcase
//	}
//	else if(result.getStatus()==ITestResult.SUCCESS)
//	{
//		test.log(Status.PASS, "Test Case Failed"+result.getName());//to add name of method of Testcase
//	}
//}

//public static String getScreenShot(WebDriver driver,String Screenshotname)throws IOException
//{
//	String dateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
//	TakesScreenshot ts=(TakesScreenshot)driver;
//	File source=ts.getScreenshotAs(OutputType.FILE);
//	
//	String destination=System.getProperty("user.dir")+"//Screenshots//"+Screenshotname+dateName+".png";
//	File finaldestination=new File(destination);
//	//FileUtils.copyFile(source, destination);
//	FileUtils.copyFile(source, finaldestination);
//	return destination;
//	
//}
@AfterSuite
public void Close_Browser()
{
	//extent.flush();
	driver.close();
}
}
