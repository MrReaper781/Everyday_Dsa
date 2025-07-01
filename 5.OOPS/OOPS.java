public class OOPS {
    public static void main(String[] args) {
        Pen pen1 = new Pen();
        pen1.color = "blue";
        pen1.tip = 5;
        System.out.println(pen1.color);
        System.out.println(pen1.tip);
        pen1.setColor("Yellow");
        pen1.setTip(7);
        System.out.println(pen1.color);
        System.out.println(pen1.tip);
    }
}

class BanAccount {
    public String username;
    private String password;
}

class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}