package com.test.exam01;

public class StaticExam {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
    
        number1.a = 1;
        number1.b = 1;
        
        System.out.println(number2.a + " " + number2.b);
    
        //static 전역 변수는 값이 변경. 일반 전역 변수는 값이 바뀌지 않음.
        //staic으로 선언된 변수는 메모리가 유지.
        //일반 전역변수는 인스턴스 생성때마다 새로운 메모리에 생성됨으로 값을 유지하지 않음.
        Number.print(); //static으로 선언된 메소드는 인스턴스 생성없이 실행 가능
        number1.print1(); //일반 메소드는 인스턴스 생성 후 실행 가능
    }
}

class Number{
    static int a =0;
    int b = 0;
    
    static void print() {
        System.out.println("static method test !!!");
    }
    
    void print1() {
        System.out.println("instance method test !!!");
    }
}

