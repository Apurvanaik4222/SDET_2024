package TestComponent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class databaseConnEg {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {


        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","Destiny@1234");
       Statement statement = conn.createStatement();
       ResultSet set =statement.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
        JSONArray jsonArray =new JSONArray();

        ArrayList<CustomerDetails> list =new ArrayList<CustomerDetails>();
        while (set.next()){
            CustomerDetails customerDetails =new CustomerDetails();
           customerDetails.setCourseName(set.getString(1));
           customerDetails.setPurchaseDate(set.getString(2));
           customerDetails.setAmount(set.getInt(3));
           customerDetails.setLocation(set.getString(4));
           list.add(customerDetails);



       }

        for (int i=0;i<list.size();i++){
            ObjectMapper mapper =new ObjectMapper();
            mapper.writeValue(new File("C:\\Users\\91762\\IdeaProjects\\SDET_2024\\src\\test\\jsonFiles\\data"+i+".json"),list.get(i));
            Gson gson =new Gson();
           String jsonStringELe = gson.toJson(list.get(i));
           jsonArray.add(jsonStringELe);

        }

        JSONObject jsonObject =new JSONObject();
                jsonObject.put("data",jsonArray);
                System.out.println(jsonObject.toString());
        String unescapeString = StringEscapeUtils.unescapeJava(jsonObject.toString());
        System.out.println(unescapeString);
       String string1 = unescapeString.replace("\"{","{");
      String latestString = string1.replace("}\"","}");
      System.out.println(latestString);


  FileWriter fileWriter =new FileWriter(new File("C:\\Users\\91762\\IdeaProjects\\SDET_2024\\src\\test\\jsonFiles\\Combined.json"));
  fileWriter.write(latestString);
  fileWriter.flush();






    }
}
