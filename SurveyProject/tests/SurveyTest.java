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

    @Test
    public void addQuestionsToSurvey(){
        HashMap<Integer, String> listOfQuestions = new HashMap<>();
        listOfQuestions.put(1, "How good was your year?");
        listOfQuestions.put(2, "How likely will you recommend SQA module to a friend?");

        Survey endOfYearSurvey = c.createSurveyWithName(endofYearSurveyName);
        endOfYearSurvey.addSurveyQuestions(listOfQuestions);

        int numOfQuestionsInSUrvey = endOfYearSurvey.getSurveyQuestions().size();

        assertEquals(2, numOfQuestionsInSUrvey);

    }

}