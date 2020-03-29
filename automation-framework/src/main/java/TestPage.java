import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPage {

    public static void main(String[] args) {
        WebDriver testDriver = new ChromeDriver();
        testDriver.get("https://cloud.google.com/products/calculator");


    }
}
