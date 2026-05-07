package com.test.enumtest;

// enum: enum 클래스라는 걸 나타내는 예약어
// 특정 상수들을 그룹화해서 관리를 원활하게 하기 위함.
public enum Day {
    
    // 생성자를 통한 데이터 매핑
    // 상수 목록을 나열
    // 자바의 열거형 클래스 문법 그 자체임.
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wendsday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    // 인스턴스 변수 -> 상수(final)
    private final String label;

    // 생성자
    Day(String label) {
        //TODO Auto-generated constructor stub
        this.label = label;
    }

    // getter
    public String label() {
        return label;
    }
}


