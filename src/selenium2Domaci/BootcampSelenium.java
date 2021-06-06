package selenium2Domaci;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootcampSelenium {
	
	public static final String URLHome = "https://itbootcamp.rs/";
	public static final String KontaktXPATH = "//*[@id=\"menu-item-4141\"]/a";
	public static final String DONACIJEXPATH = "//*[@id=\"menu-item-6402\"]/a";
	public static final String SEARCHXPATH = "//*[@id=\"masthead\"]/div[2]/div/div/div[2]/a";
	public static final String SEARCHBOXXPATH = "//*[@id=\"masthead\"]/div[2]/div/div/form/div/div/input";
	
	

	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get(URLHome);
		Dimension size = driver.manage().window().getSize();
		driver.manage().window().maximize();
		
		WebElement kontakt = driver.findElement(By.xpath(KontaktXPATH));
		kontakt.click();
		String title = driver.getTitle();
		System.out.println(title);
		
	
		driver.navigate().to(URLHome);
		WebElement RWS = driver.findElement(By.xpath(DONACIJEXPATH));
		RWS.click();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.manage().window().setSize(size);
		driver.manage().window().maximize();
		
		WebElement Search = driver.findElement(By.xpath(SEARCHXPATH));
		Search.click();
		WebElement SearchBox = driver.findElement(By.xpath(SEARCHBOXXPATH));
		SearchBox.click();
		SearchBox.sendKeys("Testiranje");
		SearchBox.sendKeys(Keys.ENTER);
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/Screen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		

	}

}
