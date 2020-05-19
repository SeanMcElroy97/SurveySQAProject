import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {

    List<Survey> surveyList = new ArrayList<>();

    public Survey createEmptySurvey(){
        return new Survey();
    }

    public Survey createSurveyWithName(String name){
        return new Survey(name);
    }

    public void addQuestionsToSurvey(Survey s, HashMap<Integer, String> addedQuestions){
        s.addSurveyQuestions(addedQuestions);
    }

    public List<Survey> getSurveyList() {
        return surveyList;
    }

    public void addSurveyToList(Survey surveyToAdd) {
        surveyList.add(surveyToAdd);
    }
}
