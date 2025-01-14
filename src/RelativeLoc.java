import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {
    public static void main(String[] args) {
        // WebDriverの設定
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Documents\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // サイトにアクセス
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // 'name'フィールドのエレメントを取得
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

        // 'name'フィールドの上にあるラベルのテキストを取得して表示
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        // 'dateofBirth'フィールドを取得
        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

        // 'dateofBirth'の下にあるinputフィールドをクリック
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        // 'Check me out if you Love IceCreams!' ラベルのエレメントを取得
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

        // 'Check me out if you Love IceCreams!' の左側にあるinputフィールドをクリック
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        // 'inlineRadio1'というIDのラジオボタンを取得
        WebElement rdb = driver.findElement(By.id("inlineRadio1"));

        // 'inlineRadio1'の右側にあるラベルのテキストを表示
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

    }
}
