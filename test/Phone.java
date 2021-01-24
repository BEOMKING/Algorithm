package test;

public class Phone {
    private String name = "Note";
    private char color;
    private int price;

    public int getRealDebt(){
        return price / 2;
    }

    public Phone(String name){
        this.name = name;
    }
    public int getSalePrice(){
        if(this.color == 'A'){
            return this.price;
        }else{
            return this.price + 1000;
        }
    }

    public Phone() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String toString() {
        return this.name + ", " + this.color + ", " + this.price;
    }

}
