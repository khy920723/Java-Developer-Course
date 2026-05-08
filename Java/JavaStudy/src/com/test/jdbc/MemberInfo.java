package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberInfo {
    public static void main(String[] args) {
        
        String uri = "jdbc:mariadb://localhost:3306/webdev";
        String userid = "webmaster";
        String userpw = "12345"; 
        String query = "select userid, username, age from tbl_test";

        // 모두 sql 패키지 라이브러리임
        Connection con; // DB와의 연결을 관리
        Statement stmt; // DB에게 명령 전달
        ResultSet rs; // DB로부터 받아온 데이터 저장, Set Collection의 한 유형

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 퀵 픽스로 생성, 해당 드라이버가 없을 수도 있으니까 예외처리하라는 경고 뜸
            
            // 이게 팩토리 타입 디자인 패턴
            con = DriverManager.getConnection(uri, userid, userpw); // 얘도 마찬가지
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            List<Member> list = new ArrayList<>();
            // while (rs.next()) { // 다음이 없으면 null 반환
            //     list.add(new Member(rs.getString("userid"), // key 
            //                         rs.getString("username"),
            //                         rs.getInt("age"))); // 어차피 반환값이 string이기는 함 // 반드시 순서를 맞춰야되기 때문에 빌더 패턴을 많이씀
                
            // }
            while (rs.next()) { // 다음이 없으면 null 반환
                list.add(new Member.Builder()
                                .userid(rs.getString("userid"))
                                .username(rs.getString("username"))
                                .age(rs.getInt("age"))
                                .build()); // 순서 안 맞춰도 됨                
            }

            // 출력
            for(Member member:list){
                System.out.println("아이디: " + member.getUserid());
                System.out.println("이름: " + member.getUsername());
                System.out.println("나이: " + member.getAge());
            }
            // 닫기
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                rs.close();
            }
            if (con != null) {
                rs.close();
            }

        } catch (Exception e) { // 이와 같이 최상위 익셉션으로 던져주거나 throws Exception 처리
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 드라이브 소프트웨어를 구동하기 위한 것


    }
}
