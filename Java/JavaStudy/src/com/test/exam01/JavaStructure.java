package com.test.exam01;

/* 
    자바 프로그래밍 과정
    첫 번째 프로그래밍 예제 ... 자바 언어의 구조를 익힙니다.
*/
public class JavaStructure { // 클래스의 시작
    public static void main(String[] args) { // main 메소드의 시작
        // 변수 선언, 초기화
        int i = 10;
        long l_value = 10L;
        double d_value = 10.0;
        float f_value = 10.0F;
        int j;
        char a;
        j = sum(i, 10);
        a = '가';
        System.out.println("Hello World.");
        System.out.println("(Wrapper-toString) integer 타입 i = " + Integer.toString(i));
        System.out.println("integer 타입 i = " + i);
        System.out.println("(Wrapper-toString) long 타입 l_value = " + Long.toString(l_value));
        System.out.println("long 타입 l_value = " + l_value);
        System.out.println("(Wrapper-toString) double 타입 d_value = " + Long.toString(l_value));
        System.out.println("long 타입 l_value = " + l_value);
        // TODO

    }

    public static int sum(int a, int b) { // a와 b를 합친 값을 돌려준다.
        return a + b;
    }
}
