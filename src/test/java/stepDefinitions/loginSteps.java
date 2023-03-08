package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
	
public class loginSteps {
	
	WebDriver driver = null;
	
	@Given("Opens the Browser")
	public void opens_the_browser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://outlook.live.com/mail/0/");
		//driver.manage().window().maximize();  
	}

	@When("^Enters the (.*) and (.*)$")
	public void enters_the_user_name_and_password(String username, String password) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click(); 
		
		WebElement userPswd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i0118']")));
		userPswd.sendKeys(password);
				
		driver.findElement(By.xpath("//*[@value='Sign in']")).click();
		
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click(); 
		
		Thread.sleep(2000);
		
		WebElement newMsg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='New mail']"))); 
		
		newMsg.click(); 
		
		WebElement sndToPrsn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='textbox']")));  
		sndToPrsn.sendKeys("kpujitha417@gmail.com");
		
		sndToPrsn.sendKeys(Keys.ENTER);
		sndToPrsn.sendKeys(Keys.TAB);
		System.out.println("Done here");	
		
		WebElement sbjtle = driver.findElement(By.xpath("//input[@placeholder='Add a subject']"));                                  
		sbjtle.sendKeys("hey buddy");                                                                                              

		WebElement emlBdy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Message body') and @role='textbox']")));                                         
		emlBdy.sendKeys("Did you get my mail? Let me know if you get my mail. Thank you");                                                                                               
		
		driver.findElement(By.xpath("//*[text()='Send']")).click();                                            
		
	}
	
	@Then("Close the Browser")
	public void close_browser() 
	{
		//driver.close();	
	}
			
}
