// package com.test.exam02;

// import java.util.function.Consumer;
// import java.util.function.DoubleUnaryOperator;
// import java.util.function.Function;
// import java.util.function.Predicate;
// import java.util.function.Supplier;

// @FunctionalInterface // 인터페이스 
// interface MyLamdaFuntion {
//     int sum(int a, int b);

// }

// @FunctionalInterface
// interface MyPrint {
//     String printLamda();
    
// }


// public class LamdaExam {
//     public static void main(String[] args) {
//         // 람다 표현식을 이용, 위의 인터페이스에서 구성한 함수에 대한 구현체를 정의 -> 2개의 인자를 받아서 메소드에서 계산 후 반환
//         MyLamdaFuntion myLamdaFuntion = (int a, int b) -> a + b; // 익명 // 왜 중괄호 빨간줄?
//         System.out.println("람다식을 이용한 익명함수: 2개의 인자를 받아서 메소드에서 계산 후 반환하는 예 = " + myLamdaFuntion.sum(3, 5));
        
//         // 람다 표현식을 이용하여 인자 없이 문자열을 반환
//         MyPrint myPrint = () -> "Hello World";
//         System.out.println("람다표현식을 이용하여 인자 없이 문자열을 반환하는 예 = " + myPrint.printLamda());

//         // Supplier: 매개변수 없이 반환값만을 갖는 함수형 인터페이스
//         // 실행메소드: get()
//         Supplier<String> supplier = () -> "Hello My Lamda World"; // 제네릭 사용 // 왜 괄호치면 빨간색 뜨지? 중괄호를 사용하면 "블록 바디(Block Body)"가 되어, 값을 반환하려면 반드시 명시적인 return 키워드와 세미콜론(;)이 필요하기 때문
//         System.out.println("Supplier: 매개변수 없이 반환값만을 갖는 함수형 인터페이스: " + supplier.get());

//         // Function: Function<T, R> 
//         // 매개변수 T를 받아서 연산 후 결과 R을 반환
//         // 실행 메소드: apply()
//         Function<String, Integer> function = str -> str.length(); // 매개변수 하나만 있을 때는 괄호 생략 가능 
//         System.out.println("Function<T, R>: 매개변수 T를 받아서 연산 후 결과 R을 반환하는 함수형 인터페이스 사용 예: " + function.apply("sldkfjalsdkfjasldkfj"));

//         // Consumer: Consumer<T>
//         // 매개변수 T를 받아서 소비(사용)만 하고 반환하는 값이 없는 함수형 인터페이스.
//         // 실행 메소드: accept()
//         Consumer<String> consumer = str -> System.out.println(str.split(" ")[0]); // str.split(" ")[0] --> space를 분리자로 하여 문자열을 분리하고 배열에 저장 후, 해당 배열의 0번째 요소에 해당하는 값 리턴
//         consumer.accept("Hello Wonderful World !!!");
//         // Chainning 기법 (함수형 프로그램에서 가능한 기법)
//         // andThen이 해당 역할을 수행
//         // 1. accept 메소드를 통해 인자를 받고 명령을 사용(소비) -> 실행 (andthen이 먼저 실행되는 게 아님)
//         // 2. accept에서 받은 인자를 갖고 실행할 명령으로 넘겨주어 실행
//         consumer.andThen(s -> System.out.println("Consumer: 매개변수 T를 받아서 소비(사용)만 하고 반환하는 값이 없는 함수형 인터페이스 사용 예 = " + s))
//                 .accept("Hello Wonderful World !!!");
        
//         // Predicate: Predicate<T>
//         // 매개변수 T를 받아 처리한 후 Boolean을 반환하는 함수형 인터페이스
//         // 실행메소드: test()
//         Predicate<String> predicate = str -> str.equals("Hello World");        
//         System.out.println("매개변수 T를 받아 처리한 후 Boolean을 반환하는 함수형 인터페이스: " + predicate.test("Hello World"));

//         // 표현식을 극단적으로 줄이는 방법
//         // 메소드 참조 표현
//         // 람다 표현식이 단순히 기존에 있는 메소드를 호출하기만 할 때 사용하는 방식으로, 매개변수 전달 과정을 생략
//         // 클래스이름::메소드이름; 또는 인스턴스변수이름::메소드이름
//         // 처음보는 사람들에게는 혼란의 가능성 매우 높지만 종종 사용함(팀바팀).
//         Function<String, Integer> function2 = str -> str.length(); // 람다 표현식
//         System.out.println(function2.apply("Hello World !!!"));
//         Function<String, Integer> function3 = String::length; // 메소드 참조 표현식
//         System.out.println(function3.apply("Hello World !!!"));
        
//         // DoubleUnaryOperator
//         // 한 개의 double형 매개변수를 전달받아 한 개의 double형 값을 반환하는 java.util.function 패키지에서 제공하는 함수형 인터페이스
//         // 실행 메서드: DoubleUnaryOperator 
//         // 거의 쓸 일 없음.
//         DoubleUnaryOperator doubleUnaryOperator; // 선언만 하면 됨
//         doubleUnaryOperator = (n) -> Math.abs(n); // 람다 표현식
//         System.out.println(doubleUnaryOperator.applyAsDouble(-5));
//         doubleUnaryOperator = Math::abs; // 메소드 참조 표현식
//         System.out.println(doubleUnaryOperator.applyAsDouble(-5));
        
//         // 표현식을 극단적으로 줄이는 방법
//         // 생성자 참조 표현
//         // double[] arrays = new double[3];
//         Function<Integer, double[]> function4 = a -> new double[a]; // 람다 표현식
//         Function<Integer, double[]> function5 = double[]::new; // 생성자 참조 표현식
//     }
// }
