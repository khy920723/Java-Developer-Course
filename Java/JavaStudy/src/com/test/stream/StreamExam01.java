// package com.test.stream;

// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;
// import java.util.stream.Stream;

// /*
//     Stream API
//     - 등장 배경: 
//         - 자바 8 버전부터 함수형 프로그래밍의 특성을 가진 stream API 도입
//         - 자바에서는 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션(List, Map, Set, HashMap)을 사용하여 매번 새로운 코드를 작성해야 했음.
//         - 하지만 이렇게 작성된 코드의 길이가 너무 길고 가독성도 떨어지며, 코드의 재사용이 거의 불가능 했음.
//         - 데이터베이스의 쿼리와 같이 정형화된 처리 패턴을 가지지 못 했기에 데이터마다 다른 방법으로 접근해야만 했음.
//         - 위의 문제들을 극복하기 위해 도입됨.
//         - 이전 모습:
//             - 명령형 프로그래밍(Imperative Programming) 방식, 즉 외부 반복(External Iteration)을 사용
//             - for문 또는 for-each문을 통한 직접 반복(Stream API 이전에는 for문과 if문을 조합하여 데이터를 하나씩 직접 꺼내서 처리하는 방식이 일반적)
//     - 연산 속도에는 영향이 있을까?
//         - 일반적인 상황(작은 데이터셋, 단순 반복)에서는 Stream API가 느림
//         - 대용량 데이터에서 멀티코어 프로세서를 활용할 때 병렬 스트림은 순차 처리보다 압도적 빠름
//     - Stream API의 특성
//         1. 스트림은 외부 반복을 통해 작업하는 컬렉션과 달리, 내부 반복(internal iteration)을 통해 작업을 수행
//         2. 스트림은 재사용이 가능한 컬렉션과 달리, 단 한 번만 사용 가능
//         3. 스트림은 원본 데이터를 변경하지 않음
//         4. 스트림의 연산은 filter-map 기반의 API를 사용하여 지연(lazy) 연산을 통해 성능 최적화
//             - 지연 연산: 
//                 - 전부 수행하지 않고 수행이 필요한 것만 수행
//                 - 속도가 빠름 
//                 - 전통적 방식:
//                     - 100개 필터링? 100번 변환
//                 - 지연 연산은 원래 100개 해야되는 것을 5번만 돌리니까 결과 나오면 연산을 끝내버림
//                 - 1번 필터 -> 변환, 2번 필터 -> 변환, 중간에라도 결정이 나면 종료
//     - Stream API 동작흐름 ****
//         - 데이터 소스 확보 -> 스트림 생성 -> 중개 연산(필터) -> 중개 연산(맵) -> 최종 연산(출력) 
// */
// public class StreamExam01 {
//     public static void main(String[] args) {
//         /*
//             Stream API 예제
//         */
//         System.out.println("<--- 1부터 10까지의 정수를 갖는 List에서 6보다 작고, 짝수인 요소를 찾아 10배 증가시킨 리스트 출력 --->");
//         List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 1. 데이터 소스 확보
//         list.stream() // 2. 스트림 생성(기본적으로 stream을 생성할 수 있는 메소드를 갖고 있음
//             .filter(i -> i < 6) // 3. 중개연산
//             .filter(i -> i % 2 == 0) // 중개연산 필터(특정 조건을 만족하는 요소만 선택)
//             .map(i -> i * 10) // 중개연산 맵(모든 요소에 동일한 함수를 적용하여 새로운 형태의 데이터로 변환)
//             .collect(Collectors.toList()) // supplier Collectors
//             .forEach(result -> System.out.println(result + " ")); // 20, 40

//         /*
//             스트림 생성
//             - 자바에서 제공하는 모든 컬렉션의 최고 상위 객체인 Collection 인터페이스에는 stream 메소드가 정의되어 있음.
//             - 따라서 Collection 인터페이스를 구현한 구현체인 List와 Set 컬렉션 클래스에도 stream 메소드를 생성할 수 있음.
//             - 배열을 다루는 Arrays 클래스에서도 다양한 형태의 stream 메소드가 정의 되어 있음.
//             - 또한 기본 데이터 타입인 int, long, double 형을 다룰 수 있는 배열에 관한 스트림이 별도로 정의되어 있음.
//             - 이러한 스트림은 java.util.stream 패키지의 IntStream, LongStream, DoubleStream 인터페이스로 각각 제공. 
//         */
//         System.out.println("\n");
//         System.out.println("<--- 리스트 객체로부터 스트림 생성 --->");
//         // Array: 고정 크기의 기본 자료구조
//         // ArrayList: Array를 확장한 동적 크기의 컬렉션 클래스
//         // List: 인터페이스(ArrayList가 List를 구현한 구체적 클래스) 
//         ArrayList<Integer> arrayList = new ArrayList<>();
//         arrayList.add(4);
//         arrayList.add(2);
//         arrayList.add(3);
//         arrayList.add(1);
//         Stream<Integer> stream = arrayList.stream(); // 컬렉션에서 스트림 생성
//         stream.forEach(System.out::println); // forEach 메소드를 이용한 스트림 요소 순차 접근 및 출력
//         // 4 2 3 1 출력

//         System.out.println("\n");
//         System.out.println("<--- 배열로부터 스트림 생성 --->");
//         int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//         IntStream intStream = Arrays.stream(arr); // 그냥 Stream<Integer> 타입으로 만들어도 됨, Arrays는 배열 도구 클래스
//         intStream.forEach(System.out::println); // 1 2 3 4 5 6 7 8 9 10 출력

//         System.out.println("\n");
//         System.out.println("<--- 가변 매개변수로부터 스트림 생성 --->");
//         Stream<Double> stream2 = Stream.of(4.2, 2.5, 3.1, 1.9); // of 메소드의 동적(가변) 매개변수로부터 값을 받아들임
//         stream2.forEach(System.out::println);
//         // 4.2 2.5 3.1 1.9 출력

//         /*
//             스트림 중개 연산
//             - Stream API에 의해 생성된 초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환
//             - 즉, 스트림 결과값을 연결하여 받고, 이걸 다시 재가공해서 넘겨주는 방식으로 연결을 통한 데이터 연산 가능(파이프라인)
//             - 스트림 중개 연산은 필터-맵(filter-map) 기반의 API를 사용함으로서 지연 연산을 통해 성능을 최적화
//             1. 스트림 필터링: 
//                 - filter(), distinct(): 중복 제거
//             2. 스트림 변환:
//                 - map(): 일반 사용
//                 - flatMap(): 중첩 stream 처리 시 사용.
//             3. 스트림 제한:
//                 - limit(): 해당 스트림의 첫 번째 요소부터 전달된 개수 만큼의 요소만으로 이루어진 새로운 스트림 반환
//                 - skip(): 해당 스트림의 첫 번째 요소부터 전달된 개수 만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림 반환
//             4. 스트림 정렬:
//                 - sorted()
//             5. 스트림 연산 결과 확인:
//                 - peek(): 결과를 디버그 할 용도로 사용, 스트림을 소비하지 않음(스트림에 어떠한 행위도 하지 않음)
//         */ 
//         System.out.println("\n");
//         System.out.println("<--- 스트림 필터링 예제: 스트림에서 중복된 요소를 제거하고 홀수만을 골라내서 출력 --->");
//         IntStream intStream2 = IntStream.of(3, 4, 3, 3, 3, 5, 5, 5, 6, 123, 12, 45, 67, 1231); // 데이터 가공 및 스트림 생성
//         intStream2.distinct().filter(n -> n % 2 !=0 ).forEach(System.out::println);
//         // 3 5 123 45 67 1231 출력

//         System.out.println("\n");
//         System.out.println("<--- 스트림 변환 예제1: 문자열로 이루어진 스트림을 각 문자열의 길이로 이루어진 스트림으로 변환 --->");
//         Stream<String> stream3 = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
//         stream3.map(str -> str.length()).forEach(System.out::println);
//         // 4 3 4 10 출력

//         System.out.println("\n");
//         System.out.println("<--- 스트림 변환 예제2: 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환 --->");
//         String[] arrStrings = {"I study hard", "You study Java", "I am hungry"};
//         Stream<String> stream4 = Arrays.stream(arrStrings); // 배열이 스트림으로 변환
//         stream4.flatMap(str -> Stream.of(str.split(" "))).forEach(System.out::println); // 스트림 안에 스트림
//         // I study hard You study Java I am hungry 출력

//         System.out.println("\n");
//         System.out.println("<--- 스트림 제한 예제 --->");
//         IntStream intStream3 = IntStream.range(0, 10);
//         intStream3.skip(4).forEach(n -> System.out.println(5));
//         //5 5 5 5 5 5 출력

//         // intStream3.limit(5).forEach(n -> System.out.println(n)); 
//         // IllegalStateException: stream has already been operated upon or closed 출력
//         // 바로 윗줄에서 스트림이 소모(메모리에서 사라짐)가 되므로 에러 발생.

//         System.out.println("\n");
//         IntStream intStream4 = IntStream.range(0, 10); // 이와 같이 그냥 스트림을 하나 새로 생성하는 게 낫다.
//         intStream4.skip(4).forEach(n -> System.out.println(n));
//         // 4 5 6 7 8 9 출력

//         System.out.println("\n");
//         IntStream intStream5 = IntStream.range(0, 10);
//         intStream5.skip(3).limit(5).forEach(n -> System.out.println(n)); // 3 4 5 6 7

//         System.out.println("\n");
//         System.out.println("<--- 스트림 정렬 예제 --->");
//         // 오름차순
//         Stream<String> stream5 = Stream.of("Park", "Kim", "Lee", "Choi");
//         stream5.sorted().forEach(n -> System.out.println(n));
//         // Choi Kim Lee Park 출력
        
//         // 내림차순
//         System.out.println("\n"); 
//         Stream<String> stream6 = Stream.of("Park", "Kim", "Lee", "Choi");
//         stream6.sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));
//         // Park Lee Kim Choi 출력
        
//         System.out.println("\n");        
//         System.out.println("<-- 스트림 디버그 예제 -->");
//         // intStream4.peek("스트림 생성").limit().peek("limit 자동")skip(4).forEach(n -> System.out.println("skip() 사용 예제: " + n + " ")); // 대략 이런식으로 작동함

//         /*
//             스트림 최종 연산
//             1. 요소의 출력: 
//                 - forEach()
//             2. 요소의 소모: 
//                 - reduce()
//                     - 해당 메소드는 첫 번째와 두 번째 요소를 가지고 연산을 수행한 뒤, 그 결과와 세번 째 요소를 가지고 또 다시 연산을 수행.
//                     - 이런식으로 해당 스트림의 모든 요소를 소모하여 연산 수행 결과 반환(메모리를 삭제하면서 연산까지 하는 것)
//             3. 요소의 검색: 
//                 - findFirst()
//                 - findAny()
//             4. 요소의 검사: 
//                 - anyMatch() 
//                 - allMatch() 
//                 - noneMatch()
//             5. 요소의 통계: 
//                 - count() 
//                 - min() 
//                 - max()
//             6. 요소의 연산: 
//                 - sum() 
//                 - average()
//             7. 요소의 수집****
//                 - collect()
//                     - 스트림의 아이템들을 List 또는 Set 자료형으로 변환
//                     - 스트림의 아이템들을 joining
//                     - 스트림의 아이템들을 sorting하여 가장 큰 객체를 리턴
//                     - 스트림의 아이템들의 평균값을 리턴 ...
//         */
//         System.out.println("\n");        
//         System.out.println("<-- reduce 메소드를 이용하여 1부터 10까지의 합 구하기 -->");
//         Stream<Integer> inStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 숫자형 Stream이 아니라면 Stream.range() 사용 불가능
//         Stream<Integer> inStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//         Optional<Integer> sumOptional = inStream.reduce((x, y) -> x + y); // NPE에 대한 처리 옵셔널(실무에서 종종 사용)
//         Optional<Integer> sumOptional2 = Optional.ofNullable(inStream2.reduce(10, (x, y) -> x + y)); // reduce의 초기값 사용, ofNullable(): 인자로 null이 들어와도 에러를 발생시키지 않습
//         sumOptional.ifPresent(s -> System.out.println(s)); // Optional 안에 값이 있으면 람다식 실행, 없으면 무시
//         // 55 출력
//         sumOptional2.ifPresent(s -> System.out.println(s));
//         // 65 출력

//         /*
//             Object 객체
//             - 모든 형태의 타입을 다룰 수 있는 최상위 Wrapper 객체
//             - Object::toString
//                 - 스트림으로 변환된 요소들 각각에 대해 Object 객체가 각 요소들 타입을 스트림으로 변환(객체가 가진 정보를 문자열 형태로 변환하여 반환하는 기능)
//             - Object는 모든 종류의 타입을 다 손댈 수 있음(따라서 스트림으로 변환된 요소들도 접근하여 String 타입으로 변환 가능)
//         */
//         System.out.println("\n");        
//         System.out.println("<-- collect 메소드를 이용하여 스트림 아이템을 합친 후 분리자(,)로 구분하기 -->");
//         Stream<String> fruitStream = Stream.of("banana", "apple", "mango", "kiwi", "peach");
//         String result = fruitStream.map(Object::toString).collect(Collectors.joining(", ")); // result는 문자열로 변환된 데이터 요소들을 합쳐서 (banana, apple, mango, kiwi, peach) result에 전달
//         System.out.println(result);
//         // banana, apple, mango, kiwi, peach 출력

//     }
    
// }





// /* ----------------- 기존 코드 ------------------------------- */
// // import java.util.ArrayList;
// // import java.util.Arrays;
// // import java.util.Comparator;
// // import java.util.List;
// // import java.util.Optional;
// // import java.util.stream.Collectors;
// // import java.util.stream.IntStream;
// // import java.util.stream.Stream;

// // /*
// //     Stream API
// //     - 등장 배경: Java 8 버전부터 함수형 프로그래밍의 특성을 가진 stream API 도입
// //     - 자바에서는 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션(List, Map, Set, HashMap)을 사용하여 매번 새로운 코드를 작성해야 함. 하지만 이렇게 작성된 코드의 길이가 너무 길고 가독성도 떨어지며, 코드의 재사용이 거의 불가능 함. 즉, 데이터베이스의 쿼리와 같이 정형화된 처리 패턴을 가지지 못했기에 데이터마다 다른 방법으로 접근해야만 했음. 이러한 문제점을 극복하기 위해 도입됨.
// //     - stream API는 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기 위한 공통된 방법을 제공. 따라서 stream API를 이용하면 배열이나 컬렉션 뿐만 아니라 파일에 저장된 데이터도 모두 같은 방법으로 처리가 가능.

// //     Stream API의 특성
// //     1. 스트림은 외부 반복을 통해 작업하는 컬렉션과 달리, 내부 반복(internal iteration)을 통해 작업을 수행
// //     2. 스트림은 재사용이 가능한 컬렉션과 달리, 단 한 번만 사용
// //     3. 스트림은 원본 데이터를 변경하지 않음
// //     4. 스트림의 연산은 필터-맵(filter-map) 기반의 API를 사용하여 지연(lazy) 연산을 통해 성능을 최적화
// //         - 지연연산: 전부 수행하지 않고 수행이 필요한 것만 수행 --> 속도가 빠름
// //             - 전통적 방식: 100개 필터링(100번 변환)
// //             - 지연연산: 원래 100개 해야하는데 5번 돌리니까 결과 나오면 연산을 끝내버림 --> 1번 필터 --> 변환, 2번 필터 --> 변환 --> 중간에라도 결정이 나면 종료
// //     5. 스트림은 병렬 처리를 지원(parallelStream())
    
// //     stream API 동작 흐름****
// //     데이터 소스 확보 -> 스트림 생성 -> 중개 연산(필터) -> 중개연산(맵) -> 최종 연산(출력)
// // */
// // // 스트림 API 예제
// // public class StreamExam01 {
// //     public static void main(String[] args) {
// //         System.out.println("<--- 1부터 10까지의 정수를 갖는 List에서 6보다 작고, 짝수인 요소를 찾아 10배 시킨 리스트를 출력 --->");

// //         // 1. 데이터 소스 확보
// //         List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// //         // 2. 스트림 생성 -> 3. 중개 연산
// //         list.stream() // 기본적으로 stream을 생성할 수 있는 메소드 갖고 있음
// //         .filter(i -> i < 6)
// //         .filter(i -> i % 2 == 0)
// //         .map(i -> i * 10)
// //         .collect(Collectors.toList()) // supplier Collertors
// //         .forEach(result -> System.out.println(result + " "));

// //         /*
// //             스트림 생성
// //             - 자바에서 제공하는 모든 컬렉션의 최고 상위 객체인 Collection 인터페이스에는 stream() 메소드가 정의되어 있음. 
// //             - 따라서 Collection 인터페이스를 구현한 구현체인 List와 Set 컬렉션 클래스에서도 stream() 메소드를 생성할 수 있음.
// //             - 배열을 다루는 Arrays 클래스에서도 다양한 형태의 stream() 메소드가 정의되어 있음.
// //             - 또한 기본 데이터 타입인 int, long, double 형을 다룰 수 있는 배열에 관한 스트림이 별도로 정의되어 있음.
// //             - 이러한 스트림은 java.util.stream 패키지의 IntStream, LongStream, DoubleStream 인터페이스로 각각 제공.
// //         */
// //        System.out.println("\n");
// //        System.out.println("<-- 리스트 객체로부터 스트림 생성 -->");
// //        ArrayList<Integer> arrayList = new ArrayList<>();
// //        arrayList.add(4);
// //        arrayList.add(2);
// //        arrayList.add(3);
// //        arrayList.add(1);
// //         Stream<Integer> stream = arrayList.stream(); // 컬렉션에서 스트림 생성
// //         stream.forEach(System.out::println); // forEach 메소드를 이용한 스트림 요소 순차 접근 및 출력

// //         System.out.println("\n");
// //         System.out.println("<-- 배열로부터 스트림 생성 -->");
// //         int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
// //         IntStream intStream = Arrays.stream(arr); // 그냥 Stream 타입으로 만들기도 가능
// //         intStream.forEach(System.out::println);

// //         System.out.println("\n");        
// //         System.out.println("<-- 가변 매개변수로부터 스트림 생성 -->");
// //         Stream<Double> stream2 = Stream.of(4.2, 2.5, 3.1, 1.9); // of 메소드의 동적(가변) 매개변수로부터 값을 받아들임
// //         stream2.forEach(System.out::println);
        
// //         /*
// //             스트림 중개 연산
// //             - 스트림 API에 의해 생성된 초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환
// //             - 즉, 스트림 결과값을 연결하여 받고 이걸 다시 재가공해서 넘겨주는 방식으로 연결을 통한 데이터 연산 가능(파이프 라인)
// //             - 스트림 중개 연산은 필터-맵(filter-map) 기반의 API를 사용함으로서 지연(lazy) 연산을 통해 성능을 최적화
// //             1. 스트림 필터링: filter(), distinct() 중복제거
// //             2. 스트림 변환: map(): 일반 사용, flatMap()--> 중첩 stream 처리 시 사용
// //             3. 스트림 제한: limit(), skip()
// //             4. 스트림 정렬: sorted()
// //             5. 스트림 연산 결과 확인: peek()--> 결과를 디버그 할 용도로 사용, 스트림을 소비하지 않음(스트림에 어떠한 행위도 하지 않음).
// //         */
// //        System.out.println("\n");        
// //         System.out.println("<-- 스트림 필터링 예제: 스트림에서 중복된 요소를 제거하고 홀수만을 골라내서 출력 -->");
// //         IntStream intStream2 = IntStream.of(3, 4, 3, 3, 3, 5, 5, 5, 6, 123, 12, 45, 67, 1231); // 데이터 가공 및 스트림 생성
// //         intStream2.distinct().filter(n -> n % 2 != 0).forEach(System.out::println);
    
// //         System.out.println("\n");        
// //         System.out.println("<-- 스트림 변환 예제1: 문자열로 이루어진 스트림을 각 문자열의 길이로 이루어진 스트림으로 변환 -->");
// //         Stream<String> stream3 = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
// //         stream3.map(str -> str.length()).forEach(System.out::println);
    
// //         System.out.println("\n");        
// //         System.out.println("<-- 스트림 변환 예제2: 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환 -->");
// //         String[] arr1 = {"I study hard", "You study Java", "I am hungry"};
// //         Stream<String> stream4 = Arrays.stream(arr1); // 배열이 스트림으로 변환
// //         stream4.flatMap(str -> Stream.of(str.split(" "))).forEach(System.out::println); // 스트림 안에 스트림

// //         System.out.println("\n");        
// //         System.out.println("<-- 스트림 제한 예제 -->");
// //         // limit(): 해당 스트림의 첫 번째 요소부터 전달된 개수 만큼의 요소만으로 이루어진 새로운 스트림 반환
// //         // skip(): 해당 스트림의 첫 번째 요소부터 전달된 개수 만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림 반환
// //         IntStream intStream3 = IntStream.range(0, 10);
// //         intStream3.limit(5).forEach(n -> System.out.println("limit() 사용 예제: " + n + " ")); // 이때는 왜 println만으로 자동완성이 안 되지? 람다로 쓸 때는 참조형을 못 쓰나?
// //         // intStream3.skip(4).forEach(n -> System.out.println("skip() 사용 예제: " + n + " ")); // 바로 윗줄에서 스트림이 소모(메모리에서 사라짐)가 되므로 에러 발생
// //         IntStream intStream4 = IntStream.range(0, 10); // 그냥 스트림 하나 다시 파는 게 나음.
// //         intStream4.skip(4).forEach(n -> System.out.println("skip() 사용 예제: " + n + " ")); // 바로 윗줄에서 스트림이 소모(메모리에서 사라짐)가 되므로 에러 발생
// //         IntStream intStream5 = IntStream.range(0, 10);
// //         intStream5.skip(3).limit(5).forEach(n -> System.out.println("skip() + limit() 사용 예제: " + n + " "));
        
// //         System.out.println("\n");        
// //         System.out.println("<-- 스트림 정렬 예제 -->");
// //         // 오름차순
// //         Stream<String> stream5 = Stream.of("Park", "Kim", "Lee", "Choi");
// //         stream5.sorted().forEach(n -> System.out.println("sorted() 오름차순 예제: " + n + " ")); // 기본 오름차순
// //         // 내림차순
// //         Stream<String> stream6 = Stream.of("Park", "Kim", "Lee", "Choi");
// //         stream6.sorted(Comparator.reverseOrder()).forEach(n -> System.out.println("sorted()  내림차순 예제: " + n + " "));

// //         System.out.println("\n");        
// //         System.out.println("<-- 스트림 디버그 예제 -->");
// //         // intStream4.peek("스트림 생성").limit().peek("limit 자동")skip(4).forEach(n -> System.out.println("skip() 사용 예제: " + n + " ")); // 대략 이런식으로 작동함
                
// //         /*
// //             스트림 최종 연산
// //             1. 요소의 출력: forEach()
// //             2. 요소의 소모: reduce()--> 해당 메소드는 첫 번째와 두 번째 요소를 가지고 연산을 수행한 뒤, 그 결과와 세번 째 요소를 가지고 또 다시 연산을 수행. 이런식으로 해당 스트림의 모든 요소를 소모하여 연산 수행 및 결과 반환(메모리를 삭제하면서 연산까지 하는 것)
// //             3. 요소의 검색: findFirst(), FindAny()
// //             4. 요소의 검사: anyMatch(), allMatch(), noneMatch()
// //             5. 요소의 통계: count(), min(), Max()
// //             6. 요소의 연산: sum(), average()
// //             7. 요소의 수집*****: collect() --> 스트림의 아이템들을 List 또는 Set 자료형으로 변환, 스트림의 아이템들을 joining, 스트림의 아이템들을 sorting하여 가장 큰 객체를 리턴, 스트림의 아이템들의 평균값을 리턴 ...
// //         */
// //        System.out.println("\n");        
// //         System.out.println("<-- reduce 메소드를 이용하여 1부터 10까지의 합 구하기 -->");
// //         Stream<Integer> inStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// //         Stream<Integer> inStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// //         // NPE에 대한 처리 옵셔널 // 실무에서 많이 사용함
// //         Optional<Integer> sumOptional = inStream.reduce((x, y) -> x + y); // for문 안 돌리고 리듀스 하나로 끝 // reduce 메소드에서 초기값을 사용하지 않는 형태
// //         Optional<Integer> sumOptional2 = Optional.ofNullable(inStream2.reduce(10, (x, y) -> x + y)); // 초기값 사용
// //         sumOptional.ifPresent(s -> System.out.println(s));
// //         sumOptional2.ifPresent(s -> System.out.println(s));

// //         System.out.println("\n");        
// //         System.out.println("<-- collect 메소드를 이용하여 스트림 아이템을 합친 후 분리자(,)로 구분하기 -->");
// //         Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach");
// //         // Object: 모든 형태의 타입을 다룰 수 있는 최상위 Wrapper 객체
// //         // Object::toString -> 스트림으로 변환된 요소들을 각각에 대해 Object 객체가 각가의 요소들 타입을 스트림으로 변환 
// //         // Object는 모든 종류의 타입을 다 손댈 수 있음. 그래서 스트림으로 변환된 요소들도 접근해서 스트링 타입으로 변환이 가능
// //         // result는 문자열로 변환된 데이터 요소들을 합쳐서 (banana, apple, mango, kiwi, peach) result에 전달       
// //         String result = fruits.map(Object::toString).collect(Collectors.joining(", "));
// //         System.out.println(result);
    
// //     }
// // }
