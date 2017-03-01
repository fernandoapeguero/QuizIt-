package com.fernandoapeguero.quizit;

public class QuestionBook {

    private int totalScore;
    private int closeOne;
    private int closeTwo;
    private int closeThird;
    private int closeFourth;
    private int closeFifth;
    private int closeSixth;

    private String[] Question = {
            "What Country is this statue of Zues located ?",
            "The statue of liberty was a gift from what country to the USA ?",
            "In what year was the Eiffel tower Build and the builder first name.",
            "Witch chinese Dynasty build the Great wall of china!",
            "How many miles long is the Grand Canyon ?",
            "In with Country is the Blue Hole"
    };


    public String getQuestion(int index) {

        String question = Question[index];

        return question;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int setTotalScore(int newValue) {

        totalScore += newValue;
        return totalScore;
    }

    // setter and getter method for cloeOne
    public int getCloseOne() {
        return closeOne;
    }

    public int setCloseOne(int newValue) {

        return closeOne += newValue;
    }

    // setter and getter method for closeTwo

    public int getCloseTwo() {
        return closeTwo;
    }

    public int setCloseTwo(int newValue) {


        return closeTwo += newValue;
    }

    // setter and getter method for closeThird

    public int getCloseThird() {
        return closeThird;
    }

    public int setCloseThird(int newValue) {
        return closeThird += newValue;
    }

    //setter and getter method for closeFourth

    public int getCloseFourth() {
        return closeFourth;
    }

    public int setCloseFourth(int newValue) {

        return closeFourth += newValue;
    }
    //setter and getter method for closeFifth

    public int getCloseFifth() {
        return closeFifth;
    }

    public int setCloseFifth(int newValue) {

        return closeFifth += newValue;
    }

    //setter and getter method for closeSixth

    public int getCloseSixth(){
        return closeSixth;
    }

    public int setCloseSixth(int newValue){
        return closeSixth += newValue;
    }

    // reseting values to start quiz again

    public void reseter (){

        totalScore = 0 ;
        closeOne = 0 ;
        closeTwo = 0 ;
        closeThird = 0 ;
        closeFourth = 0 ;
        closeFifth = 0 ;
        closeSixth = 0 ;

    }

}
