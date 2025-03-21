
import java.util.*;
class Employeee{
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;

    public Employeee( int employeeId,
                     String name,
                     String branch,
                     double rating,
                     boolean companyTransport){
        this.employeeId=employeeId;
        this.name = name;
        this.branch=branch;
        this.rating=rating;
        this.companyTransport=companyTransport;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }
    public double getRating(){
        return rating;
    }
    public boolean isCompanyTransport(){
        return companyTransport;
    }}
public class Employee3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employeee[] employee = new Employeee[n];
        for(int i=0;i<employee.length;i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            boolean e =sc.nextBoolean();
            employee[i] = new Employeee(a,b,c,d,e);
        }
        sc.nextLine();
    String b = sc.nextLine();
    int ans1 = findCountOfEmployeesUsingCompTransport(employee,b);
if(ans1>0){
        System.out.println(ans1);
    }
else{
        System.out.println("No suchEmployees");
    }
    Employeee ans2 = findEmployeeWithSecondHighestRating(employee);
	if(ans2!=null){
        System.out.println(ans2.getEmployeeId());
        System.out.println(ans2.getName());
    }else{
        System.out.println("All Employees using company transport");
    }
	sc.close();
}


    public static int findCountOfEmployeesUsingCompTransport(Employeee[] employee,String b){
        int count=0;
        for(int i=0;i<employee.length;i++){
            if(employee[i].getBranch().equalsIgnoreCase(b) && employee[i].isCompanyTransport()){
                count++;
            }
        }
        if(count>0){
            return count;
        }

        return count;
    }
    public static Employeee findEmployeeWithSecondHighestRating(Employeee[] employee){
        Employeee highest = null;
        Employeee secondHighest = null;
        for(Employeee emp:employee){
            if (!emp.isCompanyTransport()){
                if(highest ==null || emp.getRating()>highest.getRating()){
                    secondHighest = highest;
                    highest =emp;
                }	else if(secondHighest == null || emp.getRating()>secondHighest.getRating()){
                    secondHighest = emp;
                }
            }

        }
        return secondHighest;
    }
}























