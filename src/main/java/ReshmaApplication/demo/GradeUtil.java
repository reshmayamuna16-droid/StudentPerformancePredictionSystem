package ReshmaApplication.demo;

public class GradeUtil {

    public static String grade(int avg){
        if(avg>=90) return "A+";
        else if(avg>=75) return "A";
        else if(avg>=60) return "B";
        else if(avg>=50) return "C";
        else return "Fail";
    }

    public static String predict(int avg){
        if(avg>=85) return "Excellent";
        else if(avg>=60) return "Average";
        else return "Needs Improvement";
    }
}
