import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SurveyTest {

    Controller c = new Controller();
    String endofYearSurveyName = "End of year survey";

    @Test
    public void getControllerInstance(){
        Controller controllerObj = new Controller();

        assertTrue("Create controller object", controllerObj instanceof Controller);
    }


    //Test to create empty survey object
    @Test
    public void getEmptySurveyInstance(){
        Survey emptySurvey = c.createEmptySurvey();
        assertTrue("Create empty Survey object", emptySurvey instanceof Survey);
    }

    @Test
    public void createSurveyWithName(){

        Survey surveyWithName = c.createSurveyWithName(endofYearSurveyName);

        assertEquals(endofYearSurveyName, surveyWithName.getSurveyName());

    }

    //Test adding 2 questions
    @Test
    public void addQuestionsToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addQuestionsToSurvey(endOfYearSurvey, listOfQuestions);

        int numOfQuestionsInSUrvey = endOfYearSurvey.getSurveyQuestions().size();

        assertEquals(2, numOfQuestionsInSUrvey);

    }

    //Test adding 11 questions over the limit of survey 10
    @Test(expected = AssertionError.class)
    public void add11QuestionToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        listOfQuestions.put(3, "How badly are you struggling to come up with questions?");
        listOfQuestions.put(4, "The projects user experience?");
        listOfQuestions.put(5, "The projects responsiveness?");
        listOfQuestions.put(6, "How likely will you respond to another survey?");
        listOfQuestions.put(7, "How has your performance improved over the year?");
        listOfQuestions.put(8, "Did you make a lot of friends?");
        listOfQuestions.put(9, "How did your task estimation improve?");
        listOfQuestions.put(10, "How did your code reviewing improve?");
        listOfQuestions.put(11, "How did your Team version controls improve?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addQuestionsToSurvey(endOfYearSurvey, listOfQuestions);
    }

    //BoundaryCases
    @Test
    public void add10QuestionToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");
        listOfQuestions.put(3, "How badly are you struggling to come up with questions?");
        listOfQuestions.put(4, "The projects user experience?");
        listOfQuestions.put(5, "The projects responsiveness?");
        listOfQuestions.put(6, "How likely will you respond to another survey?");
        listOfQuestions.put(7, "How has your performance improved over the year?");
        listOfQuestions.put(8, "Did you make a lot of friends?");
        listOfQuestions.put(9, "How did your task estimation improve?");
        listOfQuestions.put(10, "How did your code reviewing improve?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        c.addQuestionsToSurvey(endOfYearSurvey, listOfQuestions);

        int numOfQuestionsInSUrvey = endOfYearSurvey.getSurveyQuestions().size();

        assertEquals(10, numOfQuestionsInSUrvey);

    }


}