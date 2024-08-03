package TestComponent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class JsonReaderUtils {


    @Test(dataProvider = "getData")
    public void demo1(HashMap<Object,Object> map){
        System.out.println(map.get("CourseName"));
        System.out.println(map.get("PurchaseDate"));
        System.out.println(map.get("Amount"));
        System.out.println(map.get("Location"));
        System.out.println("========================");



    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<Object,Object>> list =JsonReaderUtils.jsonReader("C:\\Users\\91762\\IdeaProjects\\SDET_2024\\src\\test\\jsonFiles\\Combined1.json");
       // return new Object[][] {{"abc","123"},{"pfgd","56467"}};

       return new Object[][] {{list.get(0)},{list.get(1)},{list.get(2)}};
    }




    public static List<HashMap<Object,Object>> jsonReader(String filePath) throws IOException {

        String jsonContent =FileUtils.readFileToString(new File(filePath));

        ObjectMapper mapper =new ObjectMapper();
     List<HashMap<Object,Object>> list =   mapper.readValue(jsonContent, new TypeReference<List<HashMap<Object,Object>>>() {
        });
     return list;

    }
}
