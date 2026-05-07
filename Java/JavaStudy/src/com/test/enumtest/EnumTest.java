package com.test.enumtest;

// 교재: 열거형 클래스
public class EnumTest {
    public static void main(String[] args) {
        
        // name() 메소드는 열거형 클래스에서 기본적으로 제공하는 메소드
        System.out.println(Day.MON.name()); // MON 출력
        System.out.println(Day.MON.label()); // 제작한 getter 출력
    }
}
