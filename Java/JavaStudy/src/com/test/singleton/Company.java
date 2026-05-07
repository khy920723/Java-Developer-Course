package com.test.singleton;

// 교재: Singleton Pattern
// 스프링 프레임워크를 사용하면 이런 짓을 안 해도 됨.
public class Company {
    private static Company instance = new Company();
    private Company() {}
    
    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }
}
