package Util;

public class JudgeUtil {

    public static void judge(String[] e,String[] a){
        int rCount[]=new int[e.length];
        int wCount[]=new int[a.length];
        int rightNum=0;
        int wrongNum=0;
        for(int i=0;i<e.length;i++){
            if(e[i].equals(a[i])) {
                rCount[rightNum]=i+1;
                rightNum++;
            }
            else {
                wCount[wrongNum]=i+1;
                wrongNum++;
            }
        }
        String r = "";
        String w = "";
        for(int i=0;i<rCount.length;i++){
            r = r.concat(rCount[i] + ",");
        }
        for(int i=0;i<wCount.length;i++){
            w = w.concat(wCount[i] + ",");
        }
        String[] s = new String[2];
        s[0] = "Correct:" + rightNum + "(" + r + ")";
        s[1] = "Wrong:" + wrongNum + "(" + w + ")";
        FileIOUtil.outPut(s,2);
    }
}
