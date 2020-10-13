import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandr.trostyanko/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.quit();
    }
}
