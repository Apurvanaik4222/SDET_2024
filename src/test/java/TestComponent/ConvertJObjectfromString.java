package TestComponent;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConvertJObjectfromString {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper =new ObjectMapper();
      CustomerDetailsJOFS customerDetailsJOFS =  mapper.readValue(new File("C:\\Users\\91762\\IdeaProjects\\SDET_2024\\src\\test\\jsonFiles\\data99.json"),CustomerDetailsJOFS.class);

      System.out.println(customerDetailsJOFS.getName());
        System.out.println(customerDetailsJOFS.getAmount());
    }
}
