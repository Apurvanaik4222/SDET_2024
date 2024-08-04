package docker;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseClass {


    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        dockerbatFile dockerbat =new dockerbatFile();
        dockerbat.dockerRun();
    }


    @AfterTest
    public void tearDown() throws IOException, InterruptedException {
        dockerStopTest dockerStop =new dockerStopTest();
        dockerStop.dockerStop();
    }
}
