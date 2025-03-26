import java.util.*;
class Associate{
    private int id;
    private String name;
    private String technology;
    private int experienceInYears;


    public Associate(int id, String name, String technology, int experienceInYears){
        this.id=id;
        this.name=name;
        this.technology=technology;
        this.experienceInYears=experienceInYears;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTechnology(){
        return technology;
    }
    public int getExperienceInYears(){
        return experienceInYears;
    }
}
public class AssociateSolution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Associate[] associate = new Associate[5];
        for (int i = 0; i < associate.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            associate[i] = new Associate(a, b, c, d);
        }

        String searchTechnology = sc.nextLine();
        Associate[] ans = associatesForGivenTechnology(associate, searchTechnology);
        if (ans != null) {
            for (int i = 0; i < ans.length; i++) {
                System.out.println(ans[i].getId());
            }
        }
    }
        public static Associate[] associatesForGivenTechnology(Associate[] associate, String searchTechnology){
            Associate[] asso =new Associate[0];
            for(int i=0;i<associate.length;i++){
                if(associate[i].getTechnology().equalsIgnoreCase(searchTechnology) && associate[i].getExperienceInYears()%5==0){
                    asso=Arrays.copyOf(asso,asso.length+1);
                    asso[asso.length-1]=associate[i];
                }
            }
            if(asso.length>0){
                return asso;
            }
            else{
                return null;
            }
        }
    }























