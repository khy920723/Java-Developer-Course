// package com.test.exam01;

// public class GenericTest {
//     public static void main(String[] args) {       
//         GStack<String> stringStack = new GStack<String>();
//         // tos=0; Object[10] stck;
        
//         stringStack.push("Seoul"); 
//         // push(Stirng "Seoul");
//         // [0] -> Seoul
//         // tos++ -> 1

//         stringStack.push("busan");
//         // push(Stirng "busan");
//         // [1] -> busan
//         // tos++ -> 2

//         stringStack.push("LA");
//         // push(Stirng "LA");
//         // [2] -> LA
//         // tos++ -> 3

//         for(int i = 0; i < 3; i++)
//             System.out.println(stringStack.pop());
//         // i = 0; pop(); -> tos = 3 -> return 
//         // 
//     }
// }

// class GStack<T> {
//     int tos;
//     Object [] stck;
    
//     public GStack() {
//         tos = 0;
//         stck = new Object[10];
//     }
    
//     public void push(T item) {
//     if(tos == 10) return; //반환 타입이므로 메소드 종료
//         stck[tos] = item;
//         tos++;
//     }
    
//     // @SuppressWarnings("unchecked") -> 이거 안 넣으면 리턴쪽에서 warnning 발생하는데 시간나면 찾아보기
//     public T pop() {
//     if(tos == 0) return null;
//         tos--;
//         return (T)stck[tos];
//     }
// }

