package Assignment2;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownAlertsLinksHandle {

	protected WebDriver driver = new EdgeDriver();

	@BeforeTest
	public void invokeBrowser() {
		try {

			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\edgedriver_win64\\msedgedriver.exe");

			System.out.println("Invoke Browser and Open Edge");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void openOmayo() throws InterruptedException {

		// Maximize Window
		driver.manage().window().maximize();
		System.out.println("Maximize window");

		driver.get("http://omayo.blogspot.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SeleniumTutorial")));

		System.out.println("Open Omayo by Arun");

		// Open link in new window

		driver.findElement(By.linkText("SeleniumTutorial")).click();
		System.out.println("Click on Selenium143");

		// Return to main tab
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));
		driver.switchTo().window(tabs1.get(0));
		System.out.println("Navigate to main window");

		// Dropdown Handle

		WebElement e = driver.findElement(By.name("SiteMap"));
		Select dropdown1 = new Select(e);
		dropdown1.selectByIndex(3);
		System.out.println("Select doc3");
		Thread.sleep(3000);

		WebElement f = driver.findElement(By.name("SiteMap"));
		Select dropdown2 = new Select(f);
		dropdown2.selectByIndex(2);
		System.out.println("Select doc2");
		Thread.sleep(3000);

		// Alerts -1

		Actions doubleclick = new Actions(driver);
		doubleclick.moveToElement(driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']"))).doubleClick()
				.build().perform();
		System.out.println("Test Double click");
		Thread.sleep(2000);

		// Pop up Handle
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText(); // Capture text
		Thread.sleep(2000);
		alert.accept();
		System.out.println(alertMessage); // Print Alert Message

		// Alerts -2

		Actions getConfirmation = new Actions(driver);
		doubleclick.moveToElement(driver.findElement(By.id("confirm"))).doubleClick().build().perform();
		System.out.println("Get Confirmation");

		// Pop up Handle
		Alert alert1 = driver.switchTo().alert();
		String alertMessage1 = driver.switchTo().alert().getText();
		alert1.getText();
		System.out.println(alertMessage1); // Print Alert Message
		Thread.sleep(2000);
		alert1.dismiss();
		System.out.println("Dismiss");
		System.out.println("xyz");

	}

}
