import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver

reportsDir = 'build/test-reports'

driver = {
    new HtmlUnitDriver(true)
}

environments {

    chrome {
        ChromeDriverManager.getInstance().setup()
        driver = {
            new ChromeDriver()
        }
    }
}
