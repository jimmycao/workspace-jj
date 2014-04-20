package cn.jimmy.dp04.builder.eg0;

public class ZDemo {
  public static void main(String[] args) {
    MealBuilder builder = new MealBuilder();
    
    Meal vegMeal = builder.prepareVegMeal();
    System.out.println("Veg Meal:");
    vegMeal.showItems();
    System.out.println("Total Cost: " + vegMeal.getCost());
    
    Meal nonVegMeal = builder.prepareNonVegMeal();
    System.out.println("\n\nNon-veg Meal:");
    nonVegMeal.showItems();
    System.out.println("Total Cost: " + nonVegMeal.getCost());
  }
}
