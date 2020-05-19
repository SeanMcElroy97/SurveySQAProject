import java.util.HashMap;

public class SurveyResponse {
    private HashMap<Integer, Integer> surveyAnswers = new HashMap<>();

    public HashMap<Integer, Integer> getSurveyAnswers() {
        return surveyAnswers;
    }

    public void addAnswersToResponse(HashMap<Integer, Integer> someSurveyAnswers){
        someSurveyAnswers.forEach((questionNumber, qUestionAnswer) -> surveyAnswers.put(questionNumber, qUestionAnswer));
    }

}
