package Util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileIOUtil {

    public static void outPut(String[] s,int i) {
        if(i == 0){
            String path = "Exercise.txt";
            out(s,path);
        }else if(i == 1){
            String path = "Answers.txt";
            out(s,path);
        }else if(i == 2){
            String path = "Grade.txt";
            out(s,path);
        } else if(i == 3){
            String path = "exerciseAns.txt";
            out(s,path);
        }

    }

    public static String[] in(String path) {
        String strALine;
        String a[] = new String[10];
        try {
            int i = 0;
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while ((strALine = br.readLine()) != null) {
                a[i] = strALine;
                i++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("指定文件不存在。");
        }
        return a;
    }

    public static void out(String[] s,String path){
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file, true);
            for(int i=1;i<s.length+1;i++){
                fw.write(i + "、" + s[i-1]+"\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("文件保存失败。");
        }
    }
}
