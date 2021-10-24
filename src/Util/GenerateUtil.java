package Util;

import java.util.Random;

//题目生成函数
public class GenerateUtil {

    //生成题目和答案字符串数组
    public static String[] createExercise(int range, int num) {

        Random random = new Random();
        String[] subject = new String[num];
        String[] answer=new String[num];

        for(int i=0;i<num;i++) {
            int a = (int) (random.nextInt(range));
            int b = (int) (random.nextInt(range));
            int c = (int) (random.nextInt(range));
            int d = (int) (random.nextInt(range));
            int operator = (int) (random.nextInt(4));

            if (b != 0 && d != 0) {
                if (operator == 0) {
                    int numerator = a * d + b * c;
                    int denominator = b * d;
                    subject[i] = divide(a, b) + '+' + divide(c, d) + '=';
                    answer[i] = reductionOfAFraction(numerator, denominator);
                }
                if (operator == 1) {
                    if (a * d - b * c >= 0) {
                        int numerator = a * d - b * c;
                        int denominator = b * d;
                        subject[i] = divide(a, b) + '-' + divide(c, d) + '=';
                        answer[i] = reductionOfAFraction(numerator, denominator);
                    } else {
                        int numerator = b * c - a * d;
                        int denominator = b * d;
                        subject[i] = divide(c, d) + '-' + divide(a, b) + '=';
                        answer[i] = reductionOfAFraction(numerator, denominator);

                    }
                }
                if (operator == 2) {
                    int numerator = a * c;
                    int denominator = b * d;
                    subject[i] = divide(a, b) + 'x' + divide(c, d) + '=';
                    answer[i] = reductionOfAFraction(numerator, denominator);

                }
                if (operator == 3) {
                    if (c != 0) {
                        int numerator = a * d;
                        int denominator = b * c;
                        subject[i] = divide(a, b) + '÷' + divide(c, d) + '=';
                        answer[i] = reductionOfAFraction(numerator, denominator);
                    }
                    if (c == 0)
                        c = 1;
                    int numerator = a * d;
                    int denominator = b * c;
                    subject[i] = divide(a, b) + '÷' + divide(c, d) + '=';
                    answer[i] = reductionOfAFraction(numerator, denominator);
                }
            } else {
                b = 1;
                d = 1;
                if (operator == 0) {
                    int numerator = a * d + b * c;
                    int denominator = b * d;
                    subject[i] = a + "+" + c + "=";
                    answer[i] = reductionOfAFraction(numerator, denominator);
                }
                if (operator == 1) {
                    if (a * d - b * c >= 0) {
                        int numerator = a * d - b * c;
                        int denominator = b * d;
                        subject[i] = a + "-" + c + "=";
                        answer[i] = reductionOfAFraction(numerator, denominator);
                    } else {
                        int numerator = b * c - a * d;
                        int denominator = b * d;
                        subject[i] = c + "-" + a + "=";
                        answer[i] = reductionOfAFraction(numerator, denominator);
                    }
                }
                if (operator == 2) {
                    int numerator = a * c;
                    int denominator = b * d;
                    subject[i] = c + "x" + a + "=";
                    answer[i] = reductionOfAFraction(numerator, denominator);
                }
                if (operator == 3) {
                    if (c != 0) {
                        int numerator = a * d;
                        int denominator = b * c;
                        subject[i] = a + "÷" + c + "=";
                        answer[i] = reductionOfAFraction(numerator, denominator);
                    } else {
                        c = 1;
                        int numerator = a * d;
                        int denominator = b * c;
                        subject[i] = a + "÷" + c + "=";
                        answer[i] = reductionOfAFraction(numerator, denominator);
                    }
                }
            }
        }
        String[] exerciseAns = new String[num];
        for (int j=0;j<num;j++){
            exerciseAns[j] = subject[j] + answer[j];
        }
        return exerciseAns;
    }

    //生成题目字符串数组
    public static String[] toExercise(String[] s) {
        String[] r = new String[s.length];
        for (int i=0;i<s.length;i++){
            r[i] = s[i].substring(0,s[i].indexOf("=")) + "=";
        }
        return r;
    }

    //生成答案字符串数组
    public static String[] toAnswer(String[] s) {
        String[] r = new String[s.length];
        for (int i=0;i<s.length;i++){
            r[i] = s[i].substring(s[i].indexOf("=")+1,s[i].length());
        }
        return r;
    }

    //假分数转换真分数
    public static String divide(int a, int b){
        if(a>=b){
            int c,d;
            c=a/b;
            d=a%b;
            if(d==0)return c+"";
            else return c+"'"+d+"/"+b;
        }
        else return a+"/"+b;
    }

    //约分
    public static String reductionOfAFraction(int a, int b) {
        int maxfactor = 1;
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                maxfactor = i;
                break;
            }
        }
        int numerator = a / maxfactor;
        int denominator = b / maxfactor;
        if (numerator == 0) return "0";
        if (denominator == 1) return numerator + "";
        else return divide(numerator, denominator);
    }
}