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

    public double getAverageScore(){

        if(surveyResponses.size()>0){
            int numberOfTotalAnswers =0;
            double sumOfAnswers = 0;

             for(SurveyResponse response: surveyResponses){
                 numberOfTotalAnswers+= response.getSurveyAnswers().size();
                 sumOfAnswers += response.getSurveyAnswers().values().stream().mapToInt(i -> i.intValue()).sum();

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


        List<Integer> allAnswerScores= new ArrayList<>();
        double mean = getAverageScore();
        int size =0;

        for(SurveyResponse sr: surveyResponses){
            allAnswerScores.addAll(new ArrayList<Integer>(sr.getSurveyAnswers().values()));
            size += sr.getSurveyAnswers().size();
        }

        double x = 0;
        for(Integer i : allAnswerScores){
            x += Math.pow(i-mean, 2);
        }

        double stdDeviation = Math.sqrt(x/size);



        return stdDeviation;


    }


    public int getMinimumScore(){
        List<Integer> listOfResponseScores = new ArrayList<>();
        int minScore =0;

        for(SurveyResponse sr: surveyResponses){
            listOfResponseScores.addAll(new ArrayList<Integer>(sr.getSurveyAnswers().values()));
        }

        minScore=Collections.min(listOfResponseScores);

        return minScore;
    }

    public int getMaximumScore(){
        List<Integer> listOfResponseScores = new ArrayList<>();
        int maxScore =0;

        for(SurveyResponse sr: surveyResponses){
            listOfResponseScores.addAll(new ArrayList<Integer>(sr.getSurveyAnswers().values()));
        }

        maxScore=Collections.max(listOfResponseScores);

        return maxScore;
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
