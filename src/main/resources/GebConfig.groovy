import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.htmlunit.HtmlUnitDriver

reportsDir = 'build/test-reports'

driver = {
    new HtmlUnitDriver(true)
}

environments {

    chrome {
        ChromeDriverManager.getInstance().setup()
        ChromeOptions ChromeOptions = new ChromeOptions()
        ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox")

        driver = {
            new ChromeDriver(ChromeOptions)
        }
    }
}
