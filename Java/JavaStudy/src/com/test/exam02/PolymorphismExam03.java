package com.test.exam02;

public class PolymorphismExam03 {
    public static void main(String[] args) {
        new AnimalMove(new Human());
        new AnimalMove(new Tiger());
        new AnimalMove(new Eagle());
    }
}

interface Animal {
    public void move();
}

class Human implements Animal {
    @Override // 필수는 아니지만 인터페이스도 구현하게 되면 오버라이드 어노테이션 사용을 적극 권장
    public void move() { System.out.println("사람이 두발로 걷습니다."); }
}

class Tiger implements Animal {
    @Override
    public void move() { System.out.println("호랑이가 네발로 뜁니다."); }
}

class Eagle implements Animal {
    @Override
    public void move() { System.out.println("독수리가 하늘을 납니다."); }
}

class AnimalMove {
    // Animal animal;
    
    public AnimalMove(Animal animal){
        // this.animal = animal;
        animal.move(); // 구현 클래스의 move를 해야될 듯
    };
}

// 이거 오류나는데 해결 필요 -> 같은 패키지 내에 Exam02에서 똑같은 이름으로 구현한 자바 파일 때문에 일어남
// 파라미터로 인터페이스를 구현하는 객체를 받을 때, 해당 객체에서 구현된 메소드를 실행시키려고 한다. 이 때, 파라미터를 받은 메소드에서 해당 파라미터의 메소드를 실행시키는 코드를 구현했을 때, 인터페이스의 메소드가 아닌 해당 파라미터의 메소드를 실행시키는 방법.

