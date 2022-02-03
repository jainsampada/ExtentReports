package Pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Driver.Launch_Browser;

public class LoginPage extends Launch_Browser {
	@Test
public void Login()
{
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
}
	@Test
	public void forgetpass()
	{
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.navigate().back();
	}
}
