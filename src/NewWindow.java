import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

    public static void main(String[] args) throws IOException {
        /// WebDriverの設定
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Documents\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // 最初のURLを開く
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // 新しいウィンドウを開く
        driver.switchTo().newWindow(WindowType.WINDOW);

        // ウィンドウハンドルの取得
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();  // 親ウィンドウ
        String childWindow = it.next();    // 新しいウィンドウ

        // 新しいウィンドウに切り替えてURLを開く
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");

        // コース名を取得
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                                   .get(1).getText();

        // 親ウィンドウに戻って、コース名をフォームに入力
        driver.switchTo().window(parentWindowId);
        WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
        nameField.sendKeys(courseName);

        // スクリーンショットの取得
        File screenshot = nameField.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("logo.png"));

        // フォームフィールドの高さと幅を取得
        System.out.println("Height: " + nameField.getRect().getDimension().getHeight());
        System.out.println("Width: " + nameField.getRect().getDimension().getWidth());

        // driver.quit(); // ブラウザを閉じる場合はコメントアウトを外す
    }
}
