import java.sql.SQLOutput;
import java.util.*;
class Antenna{
    private int antennaid;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;

    public Antenna(int antennaid, String antennaName, String projectLead, double antennaVSWR){
        this.antennaid=antennaid;
        this.antennaName=antennaName;
        this.projectLead=projectLead;
        this.antennaVSWR=antennaVSWR;
    }

    public int getAntennaid(){
        return antennaid;
    }
    public String getAntennaName(){
        return antennaName;
    }
    public String getProjectLead(){
        return projectLead;
    }
    public double getAntennaVSWR(){
        return antennaVSWR;
    }
}
public class ant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Antenna[] a = new Antenna[4];
        for (int i = 0; i < a.length; i++) {
            int x = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            a[i] = new Antenna(x, b, c, d);
        }
        String antN = sc.nextLine();
        double vswr = sc.nextDouble();
        sc.nextLine();
        int ans1 = searchAntennaByName(a, antN);
        if (ans1 > 0) {
            System.out.println(ans1);
        } else {
            System.out.println("There is no antenna with the given paramter");

        }
        Antenna[] ans2 = sortAntennaByVSWR(a, vswr);
        if (ans2 != null) {
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getProjectLead());
            }
        } else {
            System.out.println("No Antenna found");
        }
    }

    public static int searchAntennaByName(Antenna[] a, String antN) {
        for (int i = 0; i < a.length; i++) {

            if (a[i].getAntennaName().equalsIgnoreCase(antN)) {
                return a[i].getAntennaid();
            }
        }
        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna[] a, double vswr) {
        Antenna[] b = new Antenna[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i].getAntennaVSWR() < vswr) {
                b = Arrays.copyOf(b, b.length + 1);
                b[b.length - 1] = a[i];
            }
        };
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i].getAntennaVSWR() > b[j].getAntennaVSWR()) {
                   Antenna temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        if (b.length > 0) {
            return b;
        } else {
            return null;
        }
    }
}

