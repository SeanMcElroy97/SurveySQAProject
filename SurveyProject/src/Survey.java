import java.util.HashMap;

public class Survey {

    private String surveyName;
    private HashMap<Integer, String> surveyQuestions = new HashMap<>();

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

    public void addSurveyQuestions(HashMap<Integer, String> moreSurveyQuestions){

       moreSurveyQuestions.forEach((questionNumber, questionSTr) -> surveyQuestions.put(questionNumber, questionSTr));
    }

}
