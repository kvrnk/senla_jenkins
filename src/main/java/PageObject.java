import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObject {
    WebDriver driver;
    By q = By.name("q");
    By list = By.cssSelector("div[class='rc'] h3");

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    void open(String url) {
        driver.get(url);
    }

    void searchFor(String text) {
        driver.findElement(q).sendKeys(text);
        driver.findElement(q).submit();
    }

    void checkSearchResult (String text) {
        List<WebElement> searchResults = driver.findElements(list);
        WebElement first = searchResults.get(0);

        //Assert.assertEquals("Selenium - Поиск в Google", driver.getTitle());

        if(first.getText().contains(text)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    void close() {
        driver.quit();
    }
}
