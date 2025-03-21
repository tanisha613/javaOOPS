//mention all the packages
import java.util.*;

class Medicine{
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine(String MedicineName, String batch, String disease, int price){
        this.MedicineName = MedicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }
    public String getMedicineName(){
       return MedicineName;
    }
    public String getBatch(){
        return batch;
    }
    public String getDisease(){
       return disease;
    }
    public int getPrice(){
        return price;
    }
}
public class medS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine[] med = new Medicine[4];
        for (int i = 0; i < med.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            med[i] = new Medicine(a, b, c, d);

        }
        String PassedDisease = sc.nextLine();
        int[] ans = getPriceByDisease(med, PassedDisease);
        if(ans!=null)
        {
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i]);
            }
        }
        else{
            System.out.println("No medS found");
        }
    }

    public static int[] getPriceByDisease(Medicine[] med, String PassedDisease) {
        int[] med1 = new int[0];
        for (int i=0;i< med.length;i++) {
            if (med[i].getDisease().equalsIgnoreCase(PassedDisease)) {

                med1 = Arrays.copyOf(med1, med1.length + 1);
                med1[med1.length - 1] = med[i].getPrice();
                Arrays.sort(med1);
            }
        }
        if (med1.length > 0) {
            return med1;
        } else {
            return null;
        }
    }
}
































