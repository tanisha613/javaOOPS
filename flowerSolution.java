import java.util.*;
class Flowers{
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    public Flowers(int flowerId, String flowerName, int price, int rating, String type){
        this.flowerId=flowerId;
        this.flowerName=flowerName;
        this.price=price;
        this.rating=rating;
        this.type=type;
    }
    public int getFlowerId(){
        return flowerId;
    }
    public String getFlowerName(){
        return flowerName;
    }
    public int getPrice(){
        return price;
    }
    public int getRating(){
        return rating;
    }
    public String getType(){
        return type;
    }
}
public class flowerSolution
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Flowers[] f = new Flowers[4];
        for(int i=0;i<f.length;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();
            f[i] =new Flowers(a,b,c,d,e);
        }

        String t =sc.nextLine();
        Flowers ans1 =findMinPriceByType(f,t);
        if(ans1!=null){
            System.out.println(ans1.getFlowerId());
        }
        else{
            System.out.println("There is no flower with given type");
        }
    }
    public static Flowers findMinPriceByType(Flowers[] f, String t){
        Flowers minPriceFlower =null;
        for(int i=0;i<f.length;i++) {
            if (f[i].getType().equalsIgnoreCase(t) && f[i].getRating() > 3) {
                if (minPriceFlower == null || f[i].getPrice() < minPriceFlower.getPrice()) {
                    minPriceFlower = f[i];
                }
            }
        }
        return minPriceFlower;
        }
}
