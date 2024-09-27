package com.cjc.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cjc.mt.LoginPageMT;

public class LoginPageMTTest {
	WebDriver driver;

		@BeforeSuite
	  public void beforeSuite() 
	{
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumTesting\\128\\chromedriver.exe");
		 driver=new ChromeDriver();
		
	}
	@BeforeTest

	  public void enterUrl()
	 {
		 driver.get("https://demo.guru99.com/selenium/newtours/");
			System.out.println("test successfully executed");

	 }
	@BeforeClass
	  public void maximizeBrowser() 
	{
		 driver.manage().window().maximize();
	}
	 @BeforeMethod
	  public void getCookies() 
	 {
		 Set<Cookie>cooki=driver.manage().getCookies();
		 System.out.println("Total no of cookies is:"+cooki.size());
	 for(Cookie cook :cooki)
	 {
		System.out.println("Name of cookies is:"+cook.getName()); 
	 }
	 Cookie add=new Cookie("New Cookie","XYZ");
	 driver.manage().addCookie(add);
	 Set<Cookie>cook2=driver.manage().getCookies();
	 System.out.println("total added cookies:"+cook2.size());
	 }
	 
//	 @Test
//	  public void loginTestMethod() 
//	 {
//		 System.out.println("LoginTCheck");
//		 LoginPageMTTest lp=new LoginPageMTTest(driver);
//	lp.loginCheck("AAAAA","aaaaa");
//	}
	 
	 @Test
	  public void loginTestMethod1() 
	 {
		 System.out.println("LoginTCheck");
		 LoginPageMT lp=new LoginPageMT(driver);
	lp.loginCheck();
	}
		  @AfterMethod
	  public void captureScreenshot() throws IOException
	  {
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src,new File("D:\\SeleniumTesting\\pom.png"));
	  }
	  @AfterClass
	  public void deleteCookies()
	  {
		  driver.manage().deleteCookieNamed("__eoi");
		  Set<Cookie>cook4=driver.manage().getCookies();
		  System.out.println("Total no of cookies after deleted is:"+cook4.size());
	  }

	  @AfterTest
	  public void dbClose() 
	  {
		  System.out.println("Database is closed now");
	  }
	  @AfterSuite
	  public void browserClose() 
	  {
		  System.out.println("Browser is closed");
		  driver.close();
	  }
}
