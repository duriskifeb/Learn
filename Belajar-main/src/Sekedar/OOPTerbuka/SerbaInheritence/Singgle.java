package Sekedar.OOPTerbuka.SerbaInheritence;

public class Singgle {
    public static void main(String[] args) {
        Dog kerek = new Dog();
        kerek.asu();
        kerek.eat();
    }    
}

class Animal {
    void eat() {
        System.out.println("Eating.. lah men");
    }
}

class Dog extends Animal {
    void asu () {
        System.out.println("Asu, Asu");
    }
}
