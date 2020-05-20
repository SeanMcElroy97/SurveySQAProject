import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {

    //Collection of Surveys
    List<Survey> surveyList = new ArrayList<>();

    //Creates empty survey
    public Survey createEmptySurvey(){
        return new Survey();
    }

    //Creates a survey with a unique name
    public Survey createSurveyWithName(String name) {
        for (Survey s: surveyList){
            if (s.getSurveyName() == name){
                    throw new IllegalArgumentException("survey already exists");
            }
        }
        return new Survey(name);
    }

    //Add question to existing Survey
    public void addQuestionsToSurvey(Survey s, HashMap<Integer, String> addedQuestions){
        s.addSurveyQuestions(addedQuestions);
    }

    //Retrieve the collection of surveys
    public List<Survey> getSurveyList() {
        return surveyList;
    }

    //Add survey to collection of surveys
    public void addSurveyToList(Survey surveyToAdd) {
        surveyList.add(surveyToAdd);
    }

    ////////////////////////////////////////////

    //Create an empty survey response
    public SurveyResponse createEmptySurveyResponse(){
        return new SurveyResponse();
    }

    //Add an answer to a survey.
    public void addAnswerToSurveyResponse(SurveyResponse emptySurveyResponse, HashMap<Integer, Integer> surveyAnswers) {
        emptySurveyResponse.addAnswersToResponse(surveyAnswers);
    }

    //Submit survey response. Add response to survey's collection of responses
    public void addSurveyResponseToSurvey(Survey survey, SurveyResponse surveyResponse) {
        survey.addSurveyResponse(surveyResponse);
    }

    //Find survey by it's unique name
    public Survey findSurveyByName(String endofYearSurveyName) {
        for(Survey survey : surveyList){
            if (survey.getSurveyName().equalsIgnoreCase(endofYearSurveyName)){
                return survey;
            }
        }
             throw new NullPointerException("Survey doesn't exist");

    }

    //Calculate the mean average of an entire survey
    public double calculateSurveyAverage(Survey survey) {
        return survey.getAverageScore();
    }

    //Calculate population standard deviation of an entire survey
    public double calculateSurveyStdDeviation(Survey survey){
        return survey.getStdDeviation();
    }

    //Get lowest survey score
    public int getSurveyMinimumScore(Survey survey) {
        return survey.getMinimumScore();
    }

    //Get highest survey score
    public int getSurveyMaximumScore(Survey survey) {
        return survey.getMaximumScore();
    }

    //Get mean average of a specific question on a survey
    public double getSurveyQuestionAnswerAverage(Survey survey, int questionNumber) {
        return survey.getQuestionMeanAverage( questionNumber);
    }

    //Get standard deviation of a specific question on the survey
    public double getSurveyQuestionAnswerStdDeviation(Survey survey, int questionNumber) {
        return survey.getQuestionStandardDeviation(questionNumber);
    }

    //Get lowest question score
    public int getQuestionMinAnswer(Survey survey, int questionNumber) {
        return survey.getQuestionMinimumAnswer(questionNumber);
    }

    //Get highest question score
    public int getQuestionMaxAnswer(Survey survey, int questionNumber) {
        return survey.getQuestionMaximumAnswer(questionNumber);
    }
}
