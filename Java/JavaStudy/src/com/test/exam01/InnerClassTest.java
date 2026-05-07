package com.test.exam01;

public class InnerClassTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();

        OutClass.InClass inClass = outClass.new InClass(); // 해당 문법 찾기?
        inClass.inTest();
        outClass.usingClass();

        System.out.println("inClass.inNum: " + inClass.inNum);
    }
}

class OutClass {
    private int num = 10;
    private static int sNum = 20;
    
    private InClass inClass;
    
    class InClass {
        int inNum = 100;

        void inTest(){
            System.out.println("외부 클래스의 인스턴스 변수: " + num);
            System.out.println("외부 클래스의 정적 변수: " + sNum);
        }
        
    }

    public void usingClass(){
        inClass.inTest();
    }
}
