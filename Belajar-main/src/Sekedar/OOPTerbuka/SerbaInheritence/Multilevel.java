package Sekedar.OOPTerbuka.SerbaInheritence;

public class Multilevel {
    public static void main(String[] args) {
        shark hiu = new shark();
        hiu.mbadok();
        hiu.huwa();
        hiu.ngombe();
    }
}

class Kewan {
    void mbadok() {
        System.out.println("makan o kesehatanmu looh..");
    }
}

class Dino extends Kewan {
    void ngombe(){
        System.out.println("ngombe dino, banget!");
    }
} 

class shark extends Dino {
    void huwa() {
        System.out.println("huwahuwahua...");
    }
}
