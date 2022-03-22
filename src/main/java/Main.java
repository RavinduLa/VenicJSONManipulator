import org.json.simple.parser.ParseException;
import questions.QuestionManipulator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            //QuestionManipulator.extract();
            //Generator.generate();
            //GeneratorIsQuestion.generate();
            ShuffleJson.shuffle();
            ShuffleIsQuestion.shuffle();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } /*catch (ParseException e) {
            e.printStackTrace();
        }*/

    }
}
