package docker;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class dockerTestChrome {


    @Test
    public void dockerTest_chrome() throws MalformedURLException {

        URL url =new URL("http://localhost:4444/wd/hub");

        ChromeOptions options =new ChromeOptions();
       /* DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");*/

        RemoteWebDriver driver =new RemoteWebDriver(url,options);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.close();
    }

}
