import java.util.HashMap;

public class SurveyResponse {

    //Collection of survey answers
    private HashMap<Integer, Integer> surveyAnswers = new HashMap<>();

    //Retriev all survey response answers
    public HashMap<Integer, Integer> getSurveyAnswers() {
        return surveyAnswers;
    }

    //Add an answer to this response
    public void addAnswersToResponse(HashMap<Integer, Integer> someSurveyAnswers){
        someSurveyAnswers.forEach((questionNumber, qUestionAnswer) ->{

            if(qUestionAnswer<1 || qUestionAnswer>5){
                throw new IllegalArgumentException();
            }else{
            surveyAnswers.put(questionNumber, qUestionAnswer);
            }
        });
    }

}
