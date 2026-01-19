package model;

public class prov {
}
//public abstract class Product {
//
//    protected int productId;
//    protected String name;
//    protected double price;
//    protected int stockQuantity;
//
//    public Product(int productId, String name, double price, int stockQuantity) {
//        setProductId(productId);
//        setName(name);
//        setPrice(price);
//        setStockQuantity(stockQuantity);
//    }

//package model;
//public abstract clas Product{
//protected int productId;
//protected String name;
//protected double price;
//protected int stockQuantity;
//}
//Setters
// public Product(int productId, String name, double price, int stockQuantity){
//setProductId(productId);
//setName(name);
//setPrice(price);
//setStockQuantity(stockQuantity);
//}


//Setters with validation
// public void setProductId(int productId) {
//        if (productId <= 0) {
//            throw new IllegalArgumentException("Product ID must be positive");
//        }
//        this.productId = productId;
//    }
//
//
//    public void setName(String name) {
//        if (name == null || name.trim().isEmpty()) {
//            throw new IllegalArgumentException("Product name cannot be empty");
//        }
//        if (name.length() < 2) {
//            throw new IllegalArgumentException("Product name must be at least 2 characters");
//        }
//        this.name = name;
//    }
//
//    public void setPrice(double price) {
//        if (price < 0) {
//            throw new IllegalArgumentException("Price cannot be negative");
//        }
//        this.price = price;
//    }



//public void setProductId(int productId){
//if (productId<=0){
//throw new IllegalArgumentException("Product id must be positive")
//}
//this.productId=prouctId;
//}

//public void setName(string name){
//if (name==null OR name.trim().isEmpty()){
// throw new IllegalArgumentException("")
//if (name.lengh()<2){
//throw new IllegalArgumentException("Name must have 2 or more letters")
//}
//this.name=name;;
//}
//public setPrice(double price){
//if (price<=0){
//throw new IllegalArgumentException("Price can not be a negative")
//}
//this.price=price;
//}