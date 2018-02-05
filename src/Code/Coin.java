package Code;

public class Coin {
    private int value;
    private int year;

    public Coin(int value, int year) {
        this.value = value;
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String flip(){
        String[] values ={"Tails", "Heads"};
        return values[(int)(Math.random()*2)];
    }
}
