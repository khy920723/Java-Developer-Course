package com.test.exam01;

public class GenericTest {
    public static void main(String[] args) {       
        GStack<String> stringStack = new GStack<String>();
        stringStack.push("Seoul");
        stringStack.push("busan");
        stringStack.push("LA");
        
        for(int i=0;i<3;i++)
            System.out.println(stringStack.pop());
    }
}

class GStack<T> {
    int tos;
    Object [] stck;
    
    public GStack() {
        tos = 0;
        stck = new Object[10];
    }
    
    public void push(T item) {
    if(tos == 10) return; //반환 타입이므로 메소드 종료
        stck[tos] = item;
        tos++;
    }
    
    public T pop() {
    if(tos == 0) return null;
        tos--;
        return (T)stck[tos];
    }
}

