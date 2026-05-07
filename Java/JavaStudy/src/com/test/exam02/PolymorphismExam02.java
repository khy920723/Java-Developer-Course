package com.test.exam02;

public class PolymorphismExam02 {
    public static void main(String[] args) {
        PolymorphismExam02 animalTest = new PolymorphismExam02(); // PolymorphismExam02의 인스턴스가 생성되기도 전에 main은 이미 메모리에 올라와 있는 상태여서 PolymorphismExam02가 뭔지를 모르므로 이런 형태로 만들어짐
        // 따라서 의존성 주입에 대해 알려면 라이프사이클에 대해 알아야 함.
        // 의존성 주입 찾아봐야될듯
        animalTest.moveAnimal(new Human());
        animalTest.moveAnimal(new Tiger());
        animalTest.moveAnimal(new Eagle());
    }

    public void moveAnimal(Animal animal)
    {
        animal.move();
    }
}

class Animal {
    public void move() { System.out.println("동물이 움직입니다"); }
}
class Human extends Animal {
    @Override
    public void move() { System.out.println("사람이 두발로 걷습니다."); }
}
class Tiger extends Animal {
    @Override
    public void move() { System.out.println("호랑이가 네발로 뜁니다."); }
}
class Eagle extends Animal {
    @Override
    public void move() { System.out.println("독수리가 하늘을 납니다."); }
}

