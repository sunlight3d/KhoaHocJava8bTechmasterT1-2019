import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HTTPRequest {
    private WebDriver driver = new ChromeDriver();
    private static HTTPRequest instance;
    private HTTPRequest(){}

    public static synchronized HTTPRequest getInstance(){
        if(instance == null){
            System.setProperty("webdriver.chrome.driver", "/Users/hoangnd/Documents/chromedriver");
            instance = new HTTPRequest();
        }
        return instance;
    }
    public void getFilmsFromURL(String url) {
        //http://www.phimmoi.net/phim-le/
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("Phim lẻ");
            }
        });
        WebElement btnNext = driver.findElement(By.xpath("//a[contains(text(), 'Trang kế')]"));
        do {
            List<WebElement> englishFilmNames= driver.findElements(By.className("movie-title-1"));
            List<WebElement> vietnameseFilmNames = driver.findElements(By.className("movie-title-2"));
            List<WebElement> durations = driver.findElements(By.className("movie-title-chap"));
            for (WebElement englishFilmName : englishFilmNames) {

            }
            btnNext.click();
            btnNext = driver.findElement(By.xpath("//a[contains(text(), 'Trang kế')]"));
        } while (btnNext != null);
        driver.quit();
    }
}