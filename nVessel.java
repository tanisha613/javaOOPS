import java.util.*;
class NavalVessel{
    private int vesselId;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;
    private String classification;

    public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned,int noOfVoyagesCompleted, String purpose){
        this.vesselId=vesselId;
        this.vesselName=vesselName;
        this.noOfVoyagesPlanned=noOfVoyagesPlanned;
        this.noOfVoyagesCompleted=noOfVoyagesCompleted;
        this.purpose=purpose;
    }
    public int getVesselId(){
        return vesselId;
    }
    public String getVesselName(){
        return vesselName;
    }
    public int getNofVoyagesPlanned(){
        return noOfVoyagesPlanned;
    }
    public int getNoOfVoyagesCompleted(){
        return noOfVoyagesCompleted;
    }
    public String getPurpose(){
        return purpose;
    }
    public String getClassification(){
        return classification;
    }
    public void setClassification(String classification){
        this.classification=classification;
    }
}
public class nVessel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavalVessel[] nv = new NavalVessel[4];
        for (int i = 0; i < nv.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            nv[i] = new NavalVessel(a, b, c, d, e);
        }
        int passedPercentage = sc.nextInt();
        sc.nextLine();
        String pur = sc.nextLine();
        int ans1 = findAvgVoyagesByPct(nv, passedPercentage);
        if (ans1 > 0) {
            System.out.println(ans1);
        } else {
            System.out.println(0);
        }
        NavalVessel ans2 = findVesselByGrade(nv, pur);
        if (ans2 != null) {
            System.out.println(ans2.getVesselName() + "%" + ans2.getClassification());

        } else {
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
    }


    public static int findAvgVoyagesByPct(NavalVessel[] nv, int passedPercentage) {
        int count = 0;
        int sum = 0;
        for (NavalVessel n : nv) {
            int p = n.getNoOfVoyagesCompleted() * 100 / n.getNofVoyagesPlanned();
            if (p >= passedPercentage) {
                sum += n.getNoOfVoyagesCompleted();
                count++;
            }
        }
        if (count > 0) {
            return sum / count;
        }
        return 0;
    }

    public static NavalVessel findVesselByGrade(NavalVessel[] nv, String pur) {
        int p = 0;
        for (NavalVessel n : nv) {
            if (n.getPurpose().equalsIgnoreCase(pur)) {
                String classification;
                p = n.getNoOfVoyagesCompleted() * 100 / n.getNofVoyagesPlanned();
                if (p == 100) {
                    classification = "Star";
                } else if (p >= 80 && p <= 99) {
                    classification = "Leader";
                } else if (p >= 55 && p <= 79) {
                    classification = "Inspirer";
                } else {
                    classification = "Striver";

                }
                n.setClassification(classification);
                return n;
            }
        }
        return null;
    }

}


