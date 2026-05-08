// package com.test.exam01;

// // 교재: 모르겠음 TIL 기반
// public class UserRegistry {
//     private String name;
// 	private int age;
	
// 	// 클래스 내에 생성자가 반드시 존재해야 함.
// 	// 단, 인자가 없고, 실행되는 메소드가 없는 디폴트 생성자의 경우는 코딩 시 생략 가능(컴파일 시 자동으로 코드 내에 생성자가 삽입 됨)
// 	// 롬복Lombok 사용 시 해당 표기 생략 가능(@AllArgs... 사용함)
// 	public UserRegistry(){ }
	
// 	// 파라미터에 따라 생성자 다수 존재 가능(오버로딩).
// 	// 단, 이 때는 디폴트 생성자도 반드시 작성해야 함.
// 	public UserRegistry(String name, int age) {
// 		this.name = name;
// 		this.age = age;
// 		System.out.println("회원 가입 이름과 나이");
// 	}
	
// 	// getter
// 	public String getName() {
// 		return name;
// 	}
// 	public int getAge(){
//         return age;
//     }

//     // setter
//     public void setName(String name){
//         this.name = name;
//     }
//     public void setAge(int age){
//         this.age = age;
//     }
// }

// class UserRegistryMain {
//     public static void main(String[] args) {
//         UserRegistry userRegistry = new UserRegistry("KIM", 40); // 인스턴스 생성 시, 생성된 인스턴스 내의 인스턴스 변수를 특정값으로 초기화
//         System.out.println("고객의 이름: " + userRegistry.getName());
//         System.out.println("고객의 나이: " + userRegistry.getAge());

//         userRegistry.setName("PARK");
//         userRegistry.setAge(50);
//         System.out.println("고객의 이름: " + userRegistry.getName());
//         System.out.println("고객의 나이: " + userRegistry.getAge());
//     }
// }
