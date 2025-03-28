import java.util.*;
class Inventory{
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public Inventory(String inventoryId,int maximumQuantity, int currentQuantity, int threshold){
        this.inventoryId=inventoryId;
        this.maximumQuantity=maximumQuantity;
        this.currentQuantity=currentQuantity;
        this.threshold=threshold;
    }
    public String getInventoryId(){
        return inventoryId;
    }
    public int getMaximumQuantity(){
        return maximumQuantity;
    }
    public int getCurrentQuantity(){
        return currentQuantity;
    }
    public int getThreshold(){
        return threshold;
    }
}
public class inventorySolution{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Inventory[] in =new Inventory[4];
        for(int i=0;i<in.length;i++){
            String a =sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d =sc.nextInt();
            sc.nextLine();
            in[i]=new Inventory(a,b,c,d);
        }

        int limit =sc.nextInt();
        sc.nextLine();
        Inventory[] ans =Replenish(in,limit);
        if(ans!=null) {
            for (int i = 0; i < ans.length; i++) {
                if (ans[i].getThreshold() > 75) {
                    System.out.println("Critical Filling");
                } else if (ans[i].getThreshold() >=50 && ans[i].getThreshold() <=75) {
                    System.out.println("Moderate Filling");


                } else {
                    System.out.println("Non-Critical Filling");
                }
            }
        }

        }
        public static Inventory[] Replenish(Inventory[] in, int limit){
            Inventory[] in1 =new Inventory[0];
            for(Inventory k:in){
                if(limit>=k.getThreshold()){
                    in1=Arrays.copyOf(in1,in1.length+1);
                    in1[in1.length-1]=k;
                }
            }
            if(in1.length>0){
                return in1;
            }
            else {
                return null;

            }
        }
    }













































