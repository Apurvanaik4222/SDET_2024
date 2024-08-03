package docker;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class dockerTestEdge {


    @Test
    public void dockerTest_edge() throws MalformedURLException {

        URL url =new URL("http://localhost:4444/wd/hub");

        EdgeOptions options =new EdgeOptions();
       /* DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");*/

        RemoteWebDriver driver =new RemoteWebDriver(url,options);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.close();
    }

}
