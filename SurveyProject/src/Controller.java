import java.util.HashMap;
import java.util.List;

public class Controller {

    public Survey createEmptySurvey(){
        return new Survey();
    }

    public Survey createSurveyWithName(String name){
        return new Survey(name);
    }

    public void addQuestionsToSurvey(Survey s, HashMap<Integer, String> addedQuestions){
        s.addSurveyQuestions(addedQuestions);
    }


}
