package code;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setAllMethod() {
		this.driver = GenericFucntion.setDriverPath();

	}

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");

		GenericFucntion.waitFor(2000);
		System.out.println("shubahm1");
		driver.findElement(By.linkText("Your trips")).click();
		GenericFucntion.waitFor(2000);

		driver.findElement(By.id("SignIn")).click();
		GenericFucntion.waitFor(2000);

		driver.switchTo().frame(driver.findElement(By.id("modal_window")));
		
		GenericFucntion.waitFor(5000);

		driver.findElement(By.xpath("//input[@class='required email']")).sendKeys("shubhamverma815@gmail.com");
		
		GenericFucntion.waitFor(1000);

		driver.findElement(By.xpath("//input[@class='required password']")).sendKeys("159753");

		System.out.println("shubham1");

		GenericFucntion.waitFor(1000);

		driver.findElement(By.id("signInButton")).click();
		GenericFucntion.waitFor(1000);

		String errors1 = driver.findElement(By.id("errors1")).getText().replaceAll("[\r\n]+", " ");
		System.out.println(errors1.replaceAll("[\r\n]+", " "));

		Assert.assertTrue(errors1.contains("There were errors in your submission The username or password you entered is incorrect."));

		//if we want to test negative test for login.
		//Assert.assertFalse(errors1.contains("There were errors in your submission The username or password you entered is incorrect."));

		driver.quit();
	}

}
