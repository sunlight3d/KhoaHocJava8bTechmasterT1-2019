package com.company;

public class Calculation {
    public static Double fx1(Double x) {
        Double result = 2 * Math.pow(x, 3) + Math.pow(x,2);
        return result;
    }
    public static void calculatePerformance(){
        long miliseconds1 = System.currentTimeMillis();
        for(Integer i = 0; i< 1_000; i++){
            fx1(1234567891011121314.0);
        }

        long miliseconds2 = System.currentTimeMillis();
        System.out.println("Thoi gian thuc hien: "+(miliseconds2-miliseconds1)+"ms");
    }
    public static Double canbac2(Integer x) {
        return Math.sqrt(Math.pow(x,2)) + 1;
    }
    public static Integer min(Integer x, Integer y){
        if (x<y) {
            return x;
        } else  {
            return y;
        }
    }
    public static String getRate(Integer mark)
    {
        if(mark < 5)
        {
            return "failed";
        } else if(mark >= 5 && mark <=7)
        {
            return "good";
        } else
            {
            return "perfect";
        }
    }
}
