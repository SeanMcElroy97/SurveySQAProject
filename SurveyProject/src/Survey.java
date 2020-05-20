import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;




public class Survey {

    private String surveyName;
    private HashMap<Integer, String> surveyQuestions = new HashMap<>();
    private List<SurveyResponse> surveyResponses = new ArrayList<>();
    private double averageSurveyScore = 0.0;
    private double surveyStdDeviation = 0.0;


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
               throw new IndexOutOfBoundsException();
           } else {
               surveyQuestions.put(questionNumber, questionSTr);
           }
       });
    }


    public List<SurveyResponse> getSurveyResponses() {
        return surveyResponses;
    }

    public void addSurveyResponse(SurveyResponse surveyResponse){

        //Compare hashmaps by keys. Same keys good.
        if(surveyResponse.getSurveyAnswers().keySet().equals(this.surveyQuestions.keySet())){
            this.surveyResponses.add(surveyResponse);
        }else {
            throw new IllegalArgumentException("Question numbers dont match");
        }
    }

    public List<Integer> getListOfSurveyAnswers(){

        List<Integer> listOfAllSurveyAnswers = new ArrayList<>();

        for(SurveyResponse response: surveyResponses){
            response.getSurveyAnswers().forEach((QuestionNum, answer)-> listOfAllSurveyAnswers.add(answer));
        }
        return listOfAllSurveyAnswers;
    }

    public double getAverageScore(){

        if(surveyResponses.size()>0){
            int numberOfTotalAnswers = getListOfSurveyAnswers().size();
            double sumOfAnswers = 0;

             for(Integer answer : getListOfSurveyAnswers()){
                 sumOfAnswers += answer;
             }

             averageSurveyScore = sumOfAnswers/numberOfTotalAnswers;
        }

        return averageSurveyScore;
    }

    //Population standard dev. divided by n. Not n-1 for sample.
    public double getStdDeviation(){
        //Get mean
        //x =sum of each (value- the mean) squared
        //std square of (x/size)


        List<Integer> allAnswerScores= getListOfSurveyAnswers();
        double mean = getAverageScore();
        int size =allAnswerScores.size();
        double x = 0.0;

        for (Integer answer : allAnswerScores){
            x += Math.pow(answer-mean, 2);
        }

        System.out.println(x);

        double stdDeviation = Math.sqrt(x/size);


        return stdDeviation;


    }


    public int getMinimumScore(){
        return Collections.min(getListOfSurveyAnswers());
    }

    public int getMaximumScore(){
        return Collections.max(getListOfSurveyAnswers());
    }




    public List<Integer> getQuestionAnswersList(int questionNumber){
        List<Integer> answers = new ArrayList<>();

        for(SurveyResponse sr: surveyResponses){
            sr.getSurveyAnswers().forEach((questionNum,answer)->{
                if(questionNum==questionNumber) {
                    answers.add(answer);
                }
            } );
        }

        return answers;
    }

    public double getQuestionMeanAverage(int questionNumber){

        int totalNumberOfAnswers = surveyResponses.size();


        double sumOfAnswers =0;
        for (Integer i: getQuestionAnswersList(questionNumber)){
            sumOfAnswers+=i;
        }

        return sumOfAnswers/totalNumberOfAnswers;
    }

    public double getQuestionStandardDeviation(int questionNumber){
        //x =sum of each (value- the mean) squared
        double x = 0.0;
        double stdDeviation = 0.0;
        double meanAvg = getQuestionMeanAverage(questionNumber);
        List<Integer> questionAnswersList = getQuestionAnswersList(questionNumber);

        for (Integer answer : questionAnswersList){
            x += Math.pow(answer-meanAvg, 2);
        }

        stdDeviation = Math.sqrt(x/questionAnswersList.size());

        return stdDeviation;
    }


    public int getQuestionMinimumAnswer(int questionNumber){
        return Collections.min(getQuestionAnswersList(questionNumber));
    }

    public int getQuestionMaximumAnswer(int questionNumber) {
        return Collections.max(getQuestionAnswersList(questionNumber));
    }
}
