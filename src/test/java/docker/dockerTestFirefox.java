package docker;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class dockerTestFirefox extends BaseClass{


    @Test
    public void dockerTest_firefox() throws MalformedURLException {

        URL url =new URL("http://localhost:4444/wd/hub");

        FirefoxOptions options =new FirefoxOptions();
        RemoteWebDriver driver =new RemoteWebDriver(url,options);
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        driver.close();
    }

}
