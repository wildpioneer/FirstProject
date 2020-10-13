import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests {

    @Test
    public void smokeTest1() {
        //System.setProperty("webdriver.chrome.driver", "/Users/aleksandr.trostyanko/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.3crkp.by/%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8F/%D0%BF%D0%BE%D0%BB%D0%B5%D0%B7%D0%BD%D0%BE-%D0%B7%D0%BD%D0%B0%D1%82%D1%8C/%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%B8%D0%B5-%D0%BA%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80%D1%8B/%D1%80%D0%B0%D1%81%D1%87%D0%B5%D1%82-%D0%B8%D0%BC%D1%82");

        WebElement heightInputField = driver.findElement(By.name("ht"));
        heightInputField.sendKeys("182");

        WebElement parent = driver.findElement(By.className("entry"));
        WebElement child = parent.findElement(By.name("ht"));
        child.clear();
        child.sendKeys("183");

        WebElement weightInputField = driver.findElement(By.name("mass"));
        weightInputField.sendKeys("58");

        WebElement button = driver.findElement(By.xpath("//input[@value = 'Рассчитать']"));

        Assert.assertTrue(button.isDisplayed(), "Кнопка не отображается");
        Assert.assertTrue(button.isEnabled(), "Кнопка не доступна");

        button.click();

        WebElement imtInputField = driver.findElement(By.name("result"));
        String text = imtInputField.getAttribute("value");

        Assert.assertEquals(text, "17.32", "Поле ИМТ содержит неверное значение.");
        Assert.assertTrue(text.equalsIgnoreCase("17.32"), "Поле ИМТ содержит неверное значение.");

        WebElement resline = driver.findElement(By.id("resline"));
        String reslineValue = resline.getText();
        Assert.assertEquals(reslineValue, "Пониженный вес", "Статус содержит неверное значение.");
        Assert.assertTrue(reslineValue.equalsIgnoreCase("пониженный вес"), "Статус содержит неверное значение.");

        driver.quit();
    }

    @Test
    public void smokeTest2() {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-скф");

        WebElement dropdown = driver.findElement(By.id("oSex"));
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByVisibleText("женский");

        driver.findElement(By.id("oCr")).sendKeys("80");
        driver.findElement(By.id("oAge")).sendKeys("38");
        driver.findElement(By.id("oWeight")).sendKeys("55");
        driver.findElement(By.id("oHeight")).sendKeys("163");
        driver.findElement(By.xpath("//input[@value='Рассчитать']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtMDRD")).getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(driver.findElement(By.id("txtMDRD1")).getText(),
                "ХБП: 2 стадия (при наличии почечного повреждения)");
        Assert.assertEquals(driver.findElement(By.id("txtCG")).getText(), "Cockroft-Gault: 70 (мл/мин)");
        Assert.assertEquals(driver.findElement(By.id("txtBSA")).getText(), "Поверхность тела:1.58 (кв.м)");

        driver.quit();
    }

    @Test
    public void smokeTest3() {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.staging.juiceplus.com/gb/en/products/capsules/premium-capsules");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".m-form .a-button__inner")));

        driver.get("https://www.staging.juiceplus.com/gb/en/cart");
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[. = 'Proceed to checkout']")));

        driver.quit();
    }
}
