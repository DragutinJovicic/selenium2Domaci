package selenium2Domaci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestItBoot {
	static WebDriver driver;
	
	public static final String URLhome = "https://itbootcamp.rs/";
	public static final String KONTAKTXPATH = "//*[@id=\"menu-item-4141\"]/a";

	@Test
	public static void testKontakt() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URLhome);
		driver.manage().window().maximize();
		WebElement kontakt = driver.findElement(By.xpath(KONTAKTXPATH));
		kontakt.click();
		String actual = driver.getCurrentUrl();
		String expected = "https://itbootcamp.rs/kontakt/";
		
		Assert.assertEquals(actual, expected);
	}
}
