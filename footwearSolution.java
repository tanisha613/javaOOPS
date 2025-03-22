import java.util.*;
class Footwear{
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    public Footwear(int footwearId, String footwearName, String footwearType, int price){
        this.footwearId=footwearId;
        this.footwearName=footwearName;
        this.footwearType=footwearType;
        this.price=price;
    }

    public int getFootwearId(){
        return footwearId;
    }
    public String getFootwearName(){
        return footwearName;
    }
    public String getFootwearType(){
        return footwearType;
    }
    public int getPrice(){
        return price;
    }
}
public class footwearSolution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Footwear[] foot = new Footwear[5];
        for(int i=0;i<foot.length;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c =sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            foot[i]=new Footwear(a,b,c,d);
        }

        String footType =sc.nextLine();
        String inputFootwearName=sc.nextLine();
        int ans1 = getCountByType(foot,footType);
        if(ans1>0){
            System.out.println(ans1);

        }
        else{
            System.out.println("Footwear not available");
        }
        Footwear ans2 = getSecondHighestPriceByBrand(foot,inputFootwearName);
        if(ans2!=null){
            System.out.println(ans2.getFootwearId());
            System.out.println(ans2.getFootwearName());
            System.out.println(ans2.getPrice());
        }
        else{
            System.out.println("Brand not available");
        }
    }
    public static int getCountByType(Footwear[] foot, String footType){
        int count=0;
        for(Footwear f:foot){
            if(f.getFootwearType().equalsIgnoreCase(footType)){
                count++;
            }
        }
        return count;
    }
    public static Footwear getSecondHighestPriceByBrand(Footwear[] foot, String inputFootwearName){
        Footwear[] f1 = new Footwear[0];
        for(int i=0;i<foot.length;i++){
            if(foot[i].getFootwearName().equalsIgnoreCase(inputFootwearName)){
                f1=Arrays.copyOf(f1,f1.length+1);
                f1[f1.length-1]=foot[i];
            }
        }
        if(f1.length<2){
            return null;
        }
        Arrays.sort(f1,Comparator.comparingInt(Footwear::getPrice).reversed());
        return f1[1];
    }
}
