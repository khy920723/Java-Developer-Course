package com.test.jdbc;

import javax.swing.plaf.ViewportUI;

/*
    DTO 클래스
    - Data Transfer Object
*/
// @Builder (Lombok 사용 시 어노테이션으로 한 큐에 만들기 가능)
public class Member {
    /* 인스턴스 변수 */
    private String userid;
    private String username;
    private int age;

    /* 생성자 */
    public Member() {
    }
    public Member(String userid, String username, int age) {
        this.userid = userid;
        this.username = username;
        this.age = age;
    }

    /* getter */
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }

    /* setter */
    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
    /* 
        빌더 패턴
        - 근데 빌더패턴은 내부 클래스로 항상 구현해야되나?
            - 자바(Java)와 스프링 부트(Spring Boot) 환경에서는 가독성, 캡슐화, 그리고 유지보수 측면에서 정적 내부 클래스(Static Nested Class)로 구현하는 것이 사실상의 표준(De facto standard)이자 권장되는 방식
            - 높은 응집도 (Encapsulation): UserDto를 만드는 Builder는 UserDto와만 관련이 있습니다. 이 둘을 한 파일에 묶음으로써 관련 코드가 흩어지지 않고 응집
            - 가독성: UserDto.builder()와 같이 명확하게 호출할 수 있어, 수많은 UserDtoBuilder 파일이 별도로 존재하여 패키지가 더러워지는 것을 막습
            - 불변성 및 생성자 감추기: 외부에서 Builder를 통해서만 객체를 생성하도록 강제하고, UserDto의 생성자를 private으로 제한하여 객체의 불변성을 보장
            - 근데 현재 코드는 정석적인 빌더패턴은 아닌 듯 함(게터세터 직접접근 가능)
    */
    static class Builder { // 내부 클래스
        private String userid; // String 타입은 선언 시 기본적으로 null 값이 들어감
        private String username;
        private int age;

        public Builder userid(String userid){
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

        public Member build() {
            if (userid == null || username == null || age == 0) {
                throw new IllegalStateException("Cannot create Member");
            }
            return new Member(userid, username, age);
        }

        
    }
    
    
}


/* ---------------- 원본 소스 -------------- */
// // DTO(Data Transfer Object)
// // @Builder (롬복 사용시 딸깍 가능)
// public class Member {
//     // 인스턴스 변수
//     private String userid;
//     private String username;
//     private int age;

//     // 생성자
//     public Member() {
//     }
//     public Member(String userid, String username, int age) {
//         this.userid = userid;
//         this.username = username;
//         this.age = age;
//     }

//     // getter
//     public String getUserid() {
//         return userid;
//     }
//     public void setUserid(String userid) {
//         this.userid = userid;
//     }
//     public String getUsername() {
//         return username;
//     }

//     // setter
//     public void setUsername(String username) {
//         this.username = username;
//     }
//     public int getAge() {
//         return age;
//     }
//     public void setAge(int age) {
//         this.age = age;
//     }

//     // 빌더 패턴
//     // 내부 클래스 근데 빌더패턴은 내부 클래스로 항상 구현해야되나? 찾아보기
//     static class Builder {
//         private String userid; // String 타입은 기본적으로 null 값이 들어감 선언시
//         private String username;
//         private int age;
        
//         public Builder userid(String userid) { 
//             this.userid = userid;
//             return this;
//         }

//         public Builder username(String username) {
//             this.username = username;
//             return this;
//         }

//         public Builder age(int age) {
//             this.age = age;
//             return this;
//         }

//         public Member build(){
//             if (userid == null || username == null || age == 0) {
//                 throw new IllegalStateException("Cannot create Member");
//             }
//             return new Member(userid, username, age);
//         }
//     }
    
// }
