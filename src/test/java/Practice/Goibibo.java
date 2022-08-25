package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//From
		WebElement From=driver.findElement(By.xpath("//span[text()='From']/../p[text()='Enter city or airport']"));
		From.click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bengaluru");
		List<WebElement> allsuggestions= driver.findElements(By.xpath("//ul[@class='sc-caiLqq jnUsvh']/li"));
		for(WebElement sug:allsuggestions)
		{
			String fromsugg =sug.getText();
			if(fromsugg.contains("Bengaluru International Airport"))
			{
				sug.click();
				break;
			}
		}
		//To
		//WebElement To=driver.findElement(By.xpath("//span[@class='sc-jcFjpl htmBRX']/../p[text()='Enter city or airport']"));
		//To.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mumbai");
		List<WebElement> allsuggestions1= driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li"));
		for(WebElement sug1:allsuggestions1)
		{
			String tosugg =sug1.getText();
			if(tosugg.contains("Chhatrapati Shivaji International Airport"))
			{
				sug1.click();
				break;
			}
		}
		
			
		
		
	}
}