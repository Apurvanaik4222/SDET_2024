package docker;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class dockerbatFile {


    @Test
    public void dockerRun() throws IOException, InterruptedException {

        File file1 =new File("C:\\Users\\91762\\IdeaProjects\\SDET_2024\\output.txt");
        file1.delete();
        System.out.println("File Deleted successfully");

        Runtime runtime =Runtime.getRuntime();
        runtime.exec("cmd /C start C:\\Users\\91762\\IdeaProjects\\SDET_2024\\dockerup.bat");

        Boolean flag =false;
        String file ="C:\\Users\\91762\\IdeaProjects\\SDET_2024\\output.txt";
       Calendar calendar = Calendar.getInstance();
       calendar.add(Calendar.SECOND,55);
      long stopTime = calendar.getTimeInMillis();
      System.out.println(System.currentTimeMillis());
        System.out.println(stopTime);
        Thread.sleep(3000);

      while (System.currentTimeMillis()<stopTime) {

          if (flag)
          {
              break;
          }

          BufferedReader reader =new BufferedReader(new FileReader(file));

          String lineData = reader.readLine();

          while (lineData != null && !flag) {

              if (lineData.contains("Node has been added")) {
                  flag = true;
                  break;
              }
              lineData = reader.readLine();


          }
      }
        Assert.assertTrue(flag);
      runtime.exec("cmd /C start C:\\Users\\91762\\IdeaProjects\\SDET_2024\\dockerScale.bat");
      System.out.println("Exceution Completed");


    }
}
