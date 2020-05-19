import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {

    List<Survey> surveyList = new ArrayList<>();

    public Survey createEmptySurvey(){
        return new Survey();
    }

    public Survey createSurveyWithName(String name) {
        for (Survey s: surveyList){
            if (s.getSurveyName() == name){
                try {
                    throw new AssertionError("survey already exists");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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

    ////////////////////////////////////////////

    public SurveyResponse createEmptySurveyResponse(){
        return new SurveyResponse();
    }


    public void addAnswerToSurveyResponse(SurveyResponse emptySurveyResponse, HashMap<Integer, Integer> surveyAnswers) {
        emptySurveyResponse.addAnswersToResponse(surveyAnswers);
    }
}
