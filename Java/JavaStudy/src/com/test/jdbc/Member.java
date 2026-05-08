package com.test.jdbc;

// DTO(Data Transfer Object)
// @Builder (롬복 사용시 딸깍 가능)
public class Member {
    // 인스턴스 변수
    private String userid;
    private String username;
    private int age;

    // 생성자
    public Member() {
    }
    public Member(String userid, String username, int age) {
        this.userid = userid;
        this.username = username;
        this.age = age;
    }

    // getter
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }

    // setter
    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // 빌더 패턴
    // 내부 클래스 근데 빌더패턴은 내부 클래스로 항상 구현해야되나? 찾아보기
    static class Builder {
        private String userid; // String 타입은 기본적으로 null 값이 들어감 선언시
        private String username;
        private int age;
        
        public Builder userid(String userid) { 
            this.userid = userid;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Member build(){
            if (userid == null || username == null || age == 0) {
                throw new IllegalStateException("Cannot create Member");
            }
            return new Member(userid, username, age);
        }
    }
    
}
