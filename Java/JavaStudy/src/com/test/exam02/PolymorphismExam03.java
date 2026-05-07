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
    @Override
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
    Animal animal;
    
    public AnimalMove(Animal animal){
        this.animal = animal;
        animal.move();
    };
}

// 이거 오류나는데 해결 필요

