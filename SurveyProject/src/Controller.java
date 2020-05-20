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
                    throw new IllegalArgumentException("survey already exists");
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

    public void addSurveyResponseToSurvey(Survey survey, SurveyResponse surveyResponse) {
        survey.addSurveyResponse(surveyResponse);
    }

    public Survey findSurveyByName(String endofYearSurveyName) {
        for(Survey survey : surveyList){
            if (survey.getSurveyName().equalsIgnoreCase(endofYearSurveyName)){
                return survey;
            }
        }
             throw new NullPointerException("Survey doesn't exist");

    }

    public double calculateSurveyAverage(Survey survey) {
        return survey.getAverageScore();
    }

    public double calculateSurveyStdDeviation(Survey survey){
        return survey.getStdDeviation();
    }

    public int getSurveyMinimumScore(Survey survey) {
        return survey.getMinimumScore();
    }

    public int getSurveyMaximumScore(Survey survey) {
        return survey.getMaximumScore();
    }

    public double getSurveyQuestionAnswerAverage(Survey survey, int questionNumber) {
        return survey.getQuestionMeanAverage( questionNumber);
    }

    public double getSurveyQuestionAnswerStdDeviation(Survey survey, int questionNumber) {
        return survey.getQuestionStandardDeviation(questionNumber);
    }

    public int getQuestionMinAnswer(Survey survey, int questionNumber) {
        return survey.getQuestionMinimumAnswer(questionNumber);
    }

    public int getQuestionMaxAnswer(Survey survey, int questionNumber) {
        return survey.getQuestionMaximumAnswer(questionNumber);
    }
}
