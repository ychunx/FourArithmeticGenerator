package Util;

import java.util.ArrayList;

//作业批改函数
public class JudgeUtil {

    public static void judge(String[] e,String[] a){

        ArrayList rCount =new ArrayList();
        ArrayList wCount =new ArrayList();
        //int rCount[]=new int[e.length];
        //int wCount[]=new int[a.length];
        int rightNum=0; //记录正确数目
        int wrongNum=0; //记录错误数目

        //根据学生提交的作业（包含题目和答案）判断是否与原题目和答案相等做出简单判断
        for(int i=0;i<e.length;i++){
            if(e[i].equals(a[i])) {
                rCount.add(i+1);    //记录正确题号
                rightNum++;
            }
            else {
                wCount.add(i+1);    //记录错误题号
                wrongNum++;
            }
        }
        String r = "";
        String w = "";

        //拼接题号字符串
        for(int i=0;i<rCount.size();i++){
            r = r.concat(rCount.get(i).toString() + ",");
        }
        for(int i=0;i<wCount.size();i++){
            w = w.concat(wCount.get(i).toString() + ",");
        }
        String[] s = new String[2];
        s[0] = "Correct:" + rightNum + "(" + r + ")";
        s[1] = "Wrong:" + wrongNum + "(" + w + ")";

        //输出至文本文件
        FileIOUtil.outPut(s,2);
    }
}