import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestClass {

  //  private WebDriver driver;
    private String baseUrl;
    private PageObject pageObject;

//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver.exe");
//        driver = new ChromeDriver();
//        this.pageObject = new PageObject(driver);
//        baseUrl = "http://www.google.com";
//        driver.manage().timeouts().implicitlyWait(5, SECONDS);
//        pageObject.open(baseUrl);
//    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Programs/chromedriver");
        pageObject = PageFactory.initElements(new ChromeDriver(), PageObject.class);
        baseUrl = "http://www.google.com";
        pageObject.open(baseUrl);
    }

    @Test
    public void google() throws InterruptedException {
        pageObject.searchFor("Selenium");
        pageObject.checkSearchResult("Selenium");
    }

    @After
    public void shutDown() {
       pageObject.close();
    }
}
