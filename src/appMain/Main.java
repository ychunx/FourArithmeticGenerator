package appMain;

import Util.FileIOUtil;
import Util.GenerateUtil;
import Util.JudgeUtil;

public class Main {

    // -n x -r x 或 -e <exercisefile>.txt -a <answerfile>.txt
    public static void main(String[] args) {

        if(args.length == 4){
            if(args[0].equals("-n") && args[2].equals("-r")) {
                int num=Integer.parseInt(args[1]);
                int range=Integer.parseInt(args[3]);
                if(num>0 && range>0) {
                    String[] exerciseAns = GenerateUtil.createExercise(range, num);
                    String[] exercise = GenerateUtil.toExercise(exerciseAns);
                    String[] answer = GenerateUtil.toAnswer(exerciseAns);

                    FileIOUtil.outPut(exercise,0);
                    FileIOUtil.outPut(answer,1);
                }else {
                    System.out.println("您输入的参数不合法！！！");
                    System.exit(0);
                }
            }else if(args[4].equals("-e") && args[6].equals("-a")) {
                String exercisepath = args[1];
                String answerpath =args[3];
                String[] SExercise = FileIOUtil.in(exercisepath);
                String[] SAnswer = FileIOUtil.in(answerpath);

                JudgeUtil.judge(SExercise,SAnswer);
            }else {
                System.out.println("您输入的参数不合法！！！");
                System.exit(0);
            }
        }else {
            System.out.println("您输入的参数数目不符合要求。");
            System.exit(0);
        }
    }
}
