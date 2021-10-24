package test;
import Util.FileIOUtil;
import org.junit.Test;


public class test{
    //测试生成四则运算
    @Test
    public void testCreateExercise(){
        Util.GenerateUtil.createExercise(10, 10);

    }
    //测试判断答案是否正确
    @Test
    public void testJudgeUtil(){

        String[] str1={"1+2=3"};
        String[] str2={"1+2=3"};
        Util.JudgeUtil.judge(str1,str2);}
    //测试a>b时的分数显示
    @Test
    public void testdivide1(){
        int a=5;
        int b=3;
        Util.GenerateUtil.divide(a,b);
    }
    //测试a=b时分数显示
    @Test
    public void testdivide2(){
        int a=5;
        int b=5;
        Util.GenerateUtil.divide(a,b);
    }
    //测试a<b时的分数显示
    @Test
    public void testdivide3(){
        int a=5;
        int b=10;
        Util.GenerateUtil.divide(a,b);
    }
    //测试带有0的约分情况
    @Test
    public void testreductionOfAFraction1(){
        int a=0;
        int b=2;
        Util.GenerateUtil.reductionOfAFraction(a,b);

    }
    //a>b且能继续约分的情况
    @Test
    public void testreductionOfAFraction2(){
        int a=100;
        int b=50;
        Util.GenerateUtil.reductionOfAFraction(a,b);

    }
    //测试不能继续约分的情况
    @Test
    public void testreductionOfAFraction3(){
        int a=37;
        int b=19;
        Util.GenerateUtil.reductionOfAFraction(a,b);

    }
    //测试文件输入
    @Test
    public void testin(){
        String path="C:/Users/86136/Desktop/新建文件夹 (2)/FourArithmeticGenerator/test.txt";
        FileIOUtil.in(path);
    }
    //测试文件输出
    @Test
    public void testout(){
        String path="C:/Users/86136/Desktop/新建文件夹 (2)/FourArithmeticGenerator/test.txt";
        String[] str={"1+2=3"};
        FileIOUtil.out(str,path);
    }
}