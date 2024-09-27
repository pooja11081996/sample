package com.cjc.mt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMT 
{
WebDriver driver;

By uname=By.name("userName");
By pword=By.name("password");
By sub=By.name("submit");



public LoginPageMT(WebDriver driver)
{
	this.driver=driver;
}


public void loginCheck()
{
	driver.findElement(uname).sendKeys("PPPPP");
	driver.findElement(pword).sendKeys("JJJJJ");
	driver.findElement(sub).click();
}

}
