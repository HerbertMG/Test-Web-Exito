package models;

import lombok.Data;

import java.util.Objects;

@Data
public class productList {

    private final String productName;
    private final double price;
    private final int amount;

    public productList(String productName, double price, int amount) {
        this.productName = productName;
        this.price = price;
        this.amount = amount + 1;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public double totalCost() {
        return price * amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + productName + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        productList item = (productList) o;
        return Double.compare(price, item.price) == 0 && amount == item.amount && Objects.equals(productName, item.productName);
    }

    public boolean equalsName(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        productList item = (productList) o;
        return Objects.equals(productName, item.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, amount);
    }


}
