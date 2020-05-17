import java.io.IOException;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
 
public class TecAdminSeleniumTest {
 
        public static void main(String[] args) throws IOException, InterruptedException {
                System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/chromeDriver/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
 
                WebDriver driver = new ChromeDriver(chromeOptions);
 
                driver.get("http://34.69.63.240:7000/");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
				driver.findElement(By.linkText("About Us")).click();
		
				String actualString = driver.findElement(By.xpath("//*[@id=\"PID-ab2-pg\"]/b")).getText();
 
                Thread.sleep(1000);
				String expectedString = "about";
 
                if (actualString.contains(expectedString)) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }
                driver.quit();
        }
}