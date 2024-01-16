package utils;

public class cleanPrice {

    public static double number(String number){
        return Double.parseDouble(number.replace("$", "").replace(".", "").trim());
    }
    private cleanPrice(){}
}