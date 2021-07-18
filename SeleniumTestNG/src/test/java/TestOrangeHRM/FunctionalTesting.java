package TestOrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTesting {

public static WebDriver driver; //  class
	
	
	@BeforeSuite
	public void ServerUp()
	
	{
		
		System.out.println("Server is: UP");
	
	}
	@BeforeClass
	public void LaunchBrowser()
	{
		
		WebDriverManager.chromedriver().setup();
		
		
	}
	@Test(priority=0)
	public void UserOnHomePage() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		//driver.getCurrentUrl();
		String ActualTitleLogin= driver.getTitle();
		String ExpectedTitleLogin="OrangeHRM";
		Assert.assertEquals(ActualTitleLogin, ExpectedTitleLogin, "Title of webpage do not match.");		
		
	}
	
	@Test(priority=1)
	public void LogIn()
	{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("btnLogin")).click();
		String ActualTitleHomePage= driver.getTitle();
		String ExpectedTitleHomePage="OrangeHRM";
		Assert.assertEquals(ActualTitleHomePage, ExpectedTitleHomePage);		
		
	}
	

	@Test(priority=2)
	public void LogOut()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("welcome")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
	}
	
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
		System.out.println("Browser Closed Successfully");
		
	}
	
	@AfterSuite
	public void ServerDown()
	
	{
		System.out.println("Server is: DOWN");	
		
		
	}

}
