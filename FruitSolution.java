import java.util.Scanner;

class Fruits {
    private int fruitId;
    private String fruitName;
    private int price;
    private int rating;

    public Fruits(int fruitId, String fruitName, int price, int rating) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.rating = rating;
    }

    public int getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}

public class FruitSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fruits[] fruits = new Fruits[4];

        for (int i = 0; i < fruits.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            int rating = sc.nextInt();
            sc.nextLine();
            fruits[i] = new Fruits(id, name, price, rating);
        }

        int ratingParam = sc.nextInt();
        Fruits result = findMaximumPriceByRating(fruits, ratingParam);

        if (result != null) {
            System.out.println(result.getFruitId());
        } else {
            System.out.println("No such Fruit");
        }
    }

    public static Fruits findMaximumPriceByRating(Fruits[] fruits, int ratingParam) {
        Fruits maxFruit = null;
        int maxPrice = -1;

        for (Fruits fruit : fruits) {
            if (fruit.getRating() > ratingParam && fruit.getPrice() > maxPrice) {
                maxPrice = fruit.getPrice();
                maxFruit = fruit;
            }
        }
        return maxFruit;
    }
}
