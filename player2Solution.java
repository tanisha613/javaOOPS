import java.util.*;
class Player2{
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;

    public Player2(int id, String name, int iccRank, int matchesPlayed, int runsScored){
        this.id=id;
        this.name=name;
        this.iccRank=iccRank;
        this.matchesPlayed=matchesPlayed;
        this.runsScored=runsScored;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getIccRank(){
        return iccRank;
    }
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    public int getRunsScored(){
        return runsScored;
    }
}

public class player2Solution{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Player2[] p =new Player2[4];
        for(int i=0;i<p.length;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d =sc.nextInt();
            sc.nextLine();
            int e=sc.nextInt();
            sc.nextLine();
            p[i]= new Player2(a,b,c,d,e);
        }

        int target =sc.nextInt();
        sc.nextLine();
        double[] ans =findAverageOfRuns(p,target);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                if(ans[i]>=80 && ans[i]<=100){
                    System.out.println("Grade A");
                }
                else if(ans[i]>=59 && ans[i]<=79){
                    System.out.println("Grade B");
                }
                else{
                    System.out.println("Grade C");
                }
            }
        }
    }

    public static double[] findAverageOfRuns(Player2[] p,int target){
        double[] arr =new double[0];
        for(int i=0;i<p.length;i++){
            if(p[i].getMatchesPlayed()>=target){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=(p[i].getRunsScored()/p[i].getMatchesPlayed());
            }
        }
        if(arr.length>0){
            return arr;
        }
        else{
            return null;
        }
    }
}




















