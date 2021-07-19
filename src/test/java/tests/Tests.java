package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class Tests {
	private WebDriver driver;
	//BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//Todo Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Test
	public void pruebaUno() {
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("user");
		driver.findElement(By.id("passwd")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//Todo Auto-generated catch block
			e.printStackTrace();			
		}
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Invalid email address."));
	}
	
	//AfterMethod
	public void tearDown() {
		driver.close();
	}
}
