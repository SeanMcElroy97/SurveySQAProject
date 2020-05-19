import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Survey {

    private String surveyName;
    private HashMap<Integer, String> surveyQuestions = new HashMap<>();
    private List<SurveyResponse> surveyResponses = new ArrayList<>();

    public Survey(){}

    public Survey(String surveyName) {
        this.surveyName= surveyName;
    }


    public String getSurveyName() {
        return surveyName;
    }

    public HashMap<Integer, String> getSurveyQuestions() {
        return surveyQuestions;
    }

    public void addSurveyQuestions(HashMap<Integer, String> moreSurveyQuestions) throws AssertionError{

       moreSurveyQuestions.forEach((questionNumber, questionSTr) -> {
           if (surveyQuestions.size() >= 10) {
               throw new AssertionError();
           } else {
               surveyQuestions.put(questionNumber, questionSTr);
           }
       });
    }


    public List<SurveyResponse> getSurveyResponses() {
        return surveyResponses;
    }

    public void addSurveyResponse(SurveyResponse surveyResponse){
        this.surveyResponses.add(surveyResponse);
    }
}
