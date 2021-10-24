package Util;

import java.io.*;
import java.util.ArrayList;

//文本输入输出
public class FileIOUtil {

    //简单根据传参判断需要输出的文本类型
    public static void outPut(String[] s,int i) {
        if(i == 0){
            String path = "Exercise.txt";   //题目
            out(s,path);
        }else if(i == 1){
            String path = "Answers.txt";    //答案
            out(s,path);
        }else if(i == 2){
            String path = "Grade.txt";  //成绩
            out(s,path);
        } else if(i == 3){
            String path = "exerciseAns.txt";    //题目和答案
            out(s,path);
        }
    }

    public static String[] in(String path) {
        String strALine;
        ArrayList a =new ArrayList();
        try {
            int i = 0;
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while ((strALine = br.readLine()) != null) {
                a.add(strALine);    //追加至a
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("指定文件不存在。");
        }

        //将a转换成字符串数组
        String[] r = new String[a.size()];
        for (int i=0;i<a.size();i++){
            r[i] = a.get(i).toString();
        }
        return r;
    }

    public static void out(String[] s,String path){
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file, true);
            for(int i=1;i<s.length+1;i++){
                fw.write(i + "、" + s[i-1]+"\n");    //偷懒输出
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("文件保存失败。");
        }
    }
}