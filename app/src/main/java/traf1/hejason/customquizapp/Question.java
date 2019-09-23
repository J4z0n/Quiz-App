package traf1.hejason.customquizapp;

public class Question {
    public String question, one, two, three, four, five, answer;

    public void setQuestion(String s){
        question = s;
    }
    public void setOne(String s){
        one = s;
    }
    public void setTwo(String s){
        two = s;
    }
    public void setThree(String s){
        three = s;
    }
    public void setFour(String s){
        four = s;
    }
    public void setFive(String s){
        five = s;
    }
    public void setAnswer(String s){
        answer = s;
    }

    public String getQuestion(){
        return question;
    }
    public String getOne(){
        return one;
    }
    public String getTwo(){
        return two;
    }
    public String getThree(){
        return three;
    }
    public String getFour(){
        return four;
    }
    public String getFive(){
        return five;
    }
    public String getAnswer(){
        return answer;
    }

    public boolean verify(){
        return true;
    }
}
