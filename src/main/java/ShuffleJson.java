import model.Input;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShuffleJson {
    public static void shuffle() throws IOException, ParseException {
        System.out.println("Initiating");
        FileWriter myWriter = new FileWriter("src/venic-dataset-v5-isCommand.json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/venic-dataset-temp-isCommand.json"));
        JSONArray jsonArray = (JSONArray) obj;


        List<Input> inputList = new ArrayList<>();
        System.out.println("Iterating through inputlist");
        for (Object o : jsonArray){
            JSONObject jsonObject = (JSONObject) o;
            String input = (String) jsonObject.get("input");
            long isCommand = (long) jsonObject.get("isCommand");
            
            Input i = new Input(input, isCommand);
            inputList.add(i);
        }
        System.out.println("Input list filled.");

        
        Collections.shuffle(inputList);
        System.out.println("Shuffled input list");

        JSONObject jsonObject = new JSONObject();
        System.out.println("Writing back shuffled input");
        myWriter.write("[");
        for(Input input : inputList){
            String i = input.getInput();
            long isCommand = input.getIsCommand();
            jsonObject.put("input", i);
            jsonObject.put("isCommand", isCommand);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        myWriter.write("]");
        System.out.println("Writing complete");
    }
}
