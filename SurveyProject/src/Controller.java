public class Controller {

    public Survey createEmptySurvey(){
        return new Survey();
    }

    public Survey createSurveyWithName(String name){
        return new Survey(name);
    }


}
