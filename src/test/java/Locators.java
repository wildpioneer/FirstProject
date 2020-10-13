import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Locators {
    private static String URL = "https://www.3crkp.by/%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8F/%D0%" +
            "BF%D0%BE%D0%BB%D0%B5%D0%B7%D0%BD%D0%BE-%D0%B7%D0%BD%D0%B0%D1%82%D1%8C/%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%" +
            "D0%BD%D1%81%D0%BA%D0%B8%D0%B5-%D0%BA%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80%D1%8B/%D1%" +
            "88%D0%BA%D0%B0%D0%BB%D0%B0-score";
    private ChromeDriver driver;

    @BeforeTest
    public void setUp() {
        //System
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void idTest() {
        By ageLocator = By.id("age_score");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(ageLocator);

        driver.quit();
    }

    @Test
    public void nameTest() {
        By siteSearchLocator = By.name("site_search");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(siteSearchLocator);

        driver.quit();
    }

    @Test
    public void linkTest() {
        By linkTextLocator = By.linkText("Шкала SCORE");
        By partialLinkTextLocator = By.partialLinkText("HAS-BLED");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(linkTextLocator);
        driver.findElement(partialLinkTextLocator);

        driver.quit();
    }

    @Test
    public void tagNameTest() {
        By tagNameLocator = By.tagName("strong");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(tagNameLocator);
        List<WebElement> webElementList = driver.findElements(tagNameLocator);

        System.out.println(webElementList.size());
        Assert.assertEquals(webElementList.size(), 8, "Array size is incorrect.");

        driver.quit();
    }

    @Test
    public void classNameTest() {
        By singleClassNameLocator = By.className("glyphicon-eye-open");
        By multipleClassNameLocator = By.className("button");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(singleClassNameLocator);
        List<WebElement> webElementList = driver.findElements(multipleClassNameLocator);

        System.out.println(webElementList.size());
        Assert.assertEquals(webElementList.size(), 3, "Array size is incorrect.");

        driver.quit();
    }

    @Test
    public void cssSelectorTest() {
        By singleClassNameLocator = By.cssSelector(".glyphicon-eye-open");

        //Поиск элемента class="glyphicon glyphicon-search"
        By multipleClassesNameLocator = By.cssSelector(".glyphicon.glyphicon-search");

        //Поиск child элемента class="col-xs-12" с родителем class="contacts"
        By childLocator1 = By.cssSelector(".contacts .col-xs-12");

        //Поиск прямого потомка с тэгом р у элемента class="entry"
        By directDescendantLocator = By.cssSelector(".entry > p");

        //Поиск элемента с тэгом label содержащим аттрибут for='smoke_score'
        By attributeEqualLocator = By.cssSelector("label[for='smoke_score']");

        //Поиск элемента с тэгом input содержащим аттрибут placeholder значение которого начинается с 'Возраст'
        By attributeStartLocator = By.cssSelector("input[placeholder^='Возраст']");

        //Поиск элемента с тэгом input содержащим аттрибут placeholder значение которого заканчивается на 'лет'
        By attributeEndLocator = By.cssSelector("input[placeholder$='лет']");

        //Поиск элемента с тэгом input содержащим аттрибут placeholder значение которого содержит на 'лет'
        By attributeContainsLocator = By.cssSelector("input[onkeypress*='_push_']");

        //Поиск элемента с тэгом <span class="glyphicon"> у которого родителем является элемент <div class="container">
        By complexLocator = By.cssSelector("div.container span.glyphicon");

        //Поиск элемента c тэгом li который является вторым по счету ребенком у родительского элемента
/*
         <ul>
            <li>
            <li> - будет найден этот элемент
            <li>
         </ul>
*/
        By secondChildLocator = By.cssSelector("li:nth-child(2)");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(singleClassNameLocator);
        driver.findElement(multipleClassesNameLocator);
        driver.findElement(childLocator1);
        driver.findElement(directDescendantLocator);
        driver.findElement(attributeEqualLocator);
        driver.findElement(attributeStartLocator);
        driver.findElement(attributeEndLocator);
        driver.findElement(attributeContainsLocator);
        driver.findElement(complexLocator);
        driver.findElement(secondChildLocator);

        driver.quit();
    }

    @Test
    public void cssRecall() {
        driver = new ChromeDriver();

        driver.get("http://tut.by");

        WebElement menu1 = driver.findElement(By.className("icon-burger"));
        WebElement menu2 = driver.findElement(By.cssSelector(".a-icon.icon-burger"));
        WebElement menu3 = driver.findElement(By.xpath("//link[@rel='dns-prefetch']"));


        menu2.click();
    }
}
