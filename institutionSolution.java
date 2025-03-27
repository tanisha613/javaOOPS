import java.util.*;
public class institutionSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institution[] institution = new Institution[4];
        for (int i = 0; i < institution.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            institution[i] = new Institution(a, b, c, d, e);
        }
        String PassedLocation = sc.nextLine();
        String PassedInstitutionName = sc.nextLine();
        int ans1 = findNumClearencedByLoc(institution, PassedLocation);
        if (ans1 != 0) {
            System.out.println(ans1);

        } else {
            System.out.println("There are no cleared students in this particular location");
        }
        Institution[] ans2 = UpdateInstitutionGrade(institution, PassedInstitutionName);
        if (ans2 != null) {
            for (int i = 0; i < ans2.length; i++) {
                int Rating = (ans2[i].getNoOfStudentsPlaced() * 100) / ans2[i].getNoOfStudentsCleared();
                if (Rating >= 80) {
                    System.out.println(ans2[i].getInstitutionName() + "::A");
                } else {
                    System.out.println(ans2[i].getInstitutionName() + "::B");
                }
            }
        } else {
            System.out.println("No Institute is available with the specified name");
        }
    }


    public static int findNumClearencedByLoc(Institution[] institution, String PassedLocation) {
        int sum = 0;
        for (int i = 0; i < institution.length; i++) {
            if (institution[i].getLocation().equalsIgnoreCase(PassedLocation)) {
                sum += institution[i].getNoOfStudentsCleared();
            }
        }
       return sum;
    }

    public static Institution[] UpdateInstitutionGrade(Institution[] institution, String PassedInstitutionName) {
        Institution[] institution1 = new Institution[0];
        for (int i = 0; i < institution.length; i++) {
            if (institution[i].getInstitutionName().equalsIgnoreCase(PassedInstitutionName)) {
                institution1 = Arrays.copyOf(institution1, institution1.length + 1);
                institution1[institution1.length - 1] = institution[i];

            }
        }
        if(institution1.length>0){
            return institution1;
        }
        else{
            return null;
        }
    }
}

            class Institution{
                private int institutionId;
                private String institutionName;
                private int noOfStudentsPlaced;
                private int noOfStudentsCleared;
                private String location;
                public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location){
                    this.institutionId=institutionId;
                    this.institutionName=institutionName;
                    this.noOfStudentsPlaced=noOfStudentsPlaced;
                    this.noOfStudentsCleared=noOfStudentsCleared;
                    this.location=location;
                }
                public int getInstitutionId(){
                    return institutionId;

                }
                public String getInstitutionName(){
                    return institutionName;
                }
                public int getNoOfStudentsPlaced(){
                    return noOfStudentsPlaced;
                }
                public int getNoOfStudentsCleared(){
                    return noOfStudentsCleared;
                }
                public String getLocation(){
                    return location;
                }

        }


