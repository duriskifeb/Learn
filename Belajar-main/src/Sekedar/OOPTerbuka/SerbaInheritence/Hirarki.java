package Sekedar.OOPTerbuka.SerbaInheritence;

public class Hirarki {
    public static void main(String[] args) {
        walah lee = new walah();
        lee.bersihkan();
        lee.kenter();
        
    }
}

class tai {
    void kenter() {
        System.out.println("Tak terkumpul");
    }
}

class asu extends tai {
    void loe() {
        System.out.println("Asu menyeramkan");
    }
}

class walah extends tai {
    void bersihkan() {
        System.out.println("Walah membersihkan tangan");
    }
}