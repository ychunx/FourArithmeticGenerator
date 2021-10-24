package appMain;

import Util.FileIOUtil;
import Util.GenerateUtil;
import Util.JudgeUtil;

public class Main {

    // -n x -r x 或 -e <exercisefile>.txt -a <answerfile>.txt
    public static void main(String[] args) {

        if(args.length == 4){

            //如果为 -n 和 -r 参数则进入题目生成部分
            if(args[0].equals("-n") && args[2].equals("-r")) {
                int num=Integer.parseInt(args[1]);
                int range=Integer.parseInt(args[3]);
                if(num>0 && range>0) {
                    String[] exerciseAns = GenerateUtil.createExercise(range, num);
                    String[] exercise = GenerateUtil.toExercise(exerciseAns);
                    String[] answer = GenerateUtil.toAnswer(exerciseAns);

                    FileIOUtil.outPut(exerciseAns,3);
                    FileIOUtil.outPut(exercise,0);
                    FileIOUtil.outPut(answer,1);
                }else {
                    System.out.println("您输入的参数不合法。");
                    System.exit(0);
                }
            }else if(args[0].equals("-e") && args[2].equals("-a")) {
                //如果为 -e 和 -a 参数则进入批改部分
                String exercisepath = args[1];  //传入路径
                String answerpath =args[3];
                String[] SExercise = FileIOUtil.in(exercisepath);
                String[] SAnswers = FileIOUtil.in(answerpath);

                /*
                System.out.println(exercisepath);

                for(int i=0;i<SExercise.length;i++){
                    System.out.println(SExercise[i]);
                    System.out.println(SAnswers[i]);
                }
                */

                //批改
                JudgeUtil.judge(SExercise,SAnswers);
            }else {
                System.out.println("您输入的参数不合法。");
                System.exit(0);
            }
        }else {
            System.out.println("您输入的参数数目不符合要求。");
            System.exit(0);
        }
    }
}