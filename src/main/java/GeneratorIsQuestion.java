import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneratorIsQuestion {
    public static void generate() throws IOException {
        System.out.println("Creating scanner, reader, writer and file objects");
        File questionFile = new File("src/paq-4mil.txt");
        File commandFile = new File("src/commands.txt");
        File sentenceFile = new File("src/wikisent-2mil.txt");
        File commentFile = new File("src/comments.txt");
        FileWriter myWriter = new FileWriter("src/venic-dataset-temp-isQuestion.json");
        Scanner questionReader = new Scanner(questionFile);
        Scanner commandReader = new Scanner(commandFile);
        Scanner sentenceReader = new Scanner(sentenceFile);
        Scanner commentReader = new Scanner(commentFile);

        System.out.println("Created scanner, reader, writer and file objects");

        JSONObject jsonObject = new JSONObject();

        System.out.println("Starting writing is Question...");
        myWriter.write("[");
        System.out.println("Writing Questions");
        while (questionReader.hasNext()){
            String data = questionReader.nextLine();
            jsonObject.put("input", data);
            jsonObject.put("isQuestion" , 1);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        System.out.println("Writing commands");
        while (commandReader.hasNext()){
            String data = commandReader.nextLine();
            jsonObject.put("input", data);
            jsonObject.put("isQuestion" , 0);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        System.out.println("Writing sentences");
        while (sentenceReader.hasNext()){
            String data = sentenceReader.nextLine();
            jsonObject.put("input", data);
            jsonObject.put("isQuestion" , 0);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        System.out.println("Writing comments");
        while (commentReader.hasNext()){
            String data = commentReader.nextLine();
            jsonObject.put("input", data);
            jsonObject.put("isQuestion" , 0);
            myWriter.write(jsonObject.toJSONString());
            myWriter.write(",");
        }
        myWriter.write("]");

        myWriter.close();
        commandReader.close();
        questionReader.close();
        sentenceReader.close();
        commentReader.close();

        System.out.println("Wrote is Question set.");
    }
}
