import java.util.*;
class AutonomousCar{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;

    public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment)
    {	 this.carId=carId;
        this.brand = brand;
        this.noOfTestsConducted=noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment =environment;
    }

    public int getCarId(){
        return carId;

    }
    public String getBrand(){
        return brand;

    }
    public int getNoOfTestsConducted(){
        return noOfTestsConducted;

    }
    public int getNoOfTestsPassed(){
        return noOfTestsPassed;

    }
    public String getEnviornment(){
        return environment;

    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
public class car1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] car = new AutonomousCar[4];
        for (int i = 0; i < car.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            car[i] = new AutonomousCar(a, b, c, d, e);
        }

        String envi = sc.nextLine();
        String passedBrand = sc.nextLine();
        int ans1=findTestPassedByEnv(car,envi);
        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("There are no tests passed in this particular enviornment");
        }
        AutonomousCar ans2=updateCarGrade(car,passedBrand);
        if(ans2!=null){
            System.out.println(ans2.getBrand()+"::"+ans2.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }

    }


    public static int findTestPassedByEnv(AutonomousCar[] car,String envi){
        int sum=0;
        for(AutonomousCar c:car){
            if(c.getEnviornment().equalsIgnoreCase(envi)){
                sum+=c.getNoOfTestsPassed();
            }
        }
        if(sum>0){
            return sum;
        }
       return sum;
    }
    public static AutonomousCar updateCarGrade(AutonomousCar[] car, String passedBrand){

        for(AutonomousCar  c:car){
            if(c.getBrand().equalsIgnoreCase(passedBrand)){

                int Rating = (c.getNoOfTestsPassed()*100)/c.getNoOfTestsConducted();

                if(Rating>=80){
                    c.setGrade("A1");
                }
                else{
                    c.setGrade("B2");
                }
                return c;
            }
        }
        return null;

    }}


