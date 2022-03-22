package questions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class QuestionManipulator {

    public static void extract() throws IOException, ParseException {
        FileWriter myWriter = new FileWriter("src/questions.txt");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/questions1.json"));
        JSONArray jsonArray = (JSONArray) obj;

        for (Object o : jsonArray){
            JSONObject jsonObject = (JSONObject) o;
            String question = (String) jsonObject.get("qText");
            int length = question.length();
            question = question.substring(0,length-1);
            myWriter.write(question + "\n");
            System.out.println("Question : " + question + "\n");
        }

        System.out.println("JSON extracted into file");
    }
}
