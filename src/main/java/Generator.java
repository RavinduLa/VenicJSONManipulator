import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Generator {

    public static void generate() throws IOException {
        System.out.println("Creating scanner, reader, writer and file objects");
        File questionFile = new File("src/questions.txt");
        File commandFile = new File("src/commands.txt");
        FileWriter myWriter = new FileWriter("src/venic-dataset-temp-isCommand.json");
        Scanner questionReader = new Scanner(questionFile);
        Scanner commandReader = new Scanner(commandFile);

        System.out.println("Created scanner, reader, writer and file objects");

        JSONObject jsonObject = new JSONObject();

        System.out.println("Starting writing...");
        myWriter.write("[");
        System.out.println("Writing Questions");
        while (questionReader.hasNext()){
            String data = questionReader.nextLine();
            jsonObject.put("input", data);
            jsonObject.put("isCommand" , 0);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        System.out.println("Writing commands");
        while (commandReader.hasNext()){
            String data = commandReader.nextLine();
            jsonObject.put("input", data);
            jsonObject.put("isCommand" , 1);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        myWriter.write("]");

        myWriter.close();
        commandReader.close();
        questionReader.close();
        System.out.println("Process finished");
    }
}
