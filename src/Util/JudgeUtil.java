package Util;

import java.util.ArrayList;

public class JudgeUtil {

    public static void judge(String[] e,String[] a){

        ArrayList rCount =new ArrayList();
        ArrayList wCount =new ArrayList();
        //int rCount[]=new int[e.length];
        //int wCount[]=new int[a.length];
        int rightNum=0;
        int wrongNum=0;
        for(int i=0;i<e.length;i++){
            if(e[i].equals(a[i])) {
                rCount.add(i+1);
                rightNum++;
            }
            else {
                wCount.add(i+1);
                wrongNum++;
            }
        }
        String r = "";
        String w = "";
        for(int i=0;i<rCount.size();i++){
            r = r.concat(rCount.get(i).toString() + ",");
        }
        for(int i=0;i<wCount.size();i++){
            w = w.concat(wCount.get(i).toString() + ",");
        }
        String[] s = new String[2];
        s[0] = "Correct:" + rightNum + "(" + r + ")";
        s[1] = "Wrong:" + wrongNum + "(" + w + ")";
        FileIOUtil.outPut(s,2);
    }
}
