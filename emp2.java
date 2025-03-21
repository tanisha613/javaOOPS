import java.util.*;
class Empl{
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Empl(int id,String name,String designation,double salary){
        this.id =id;
        this.name=name;
        this.designation=designation;
        this.salary=salary;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDesignation(){
        return designation;
    }
    public double getSalary(){
        return salary;
    }
    @Override
    public String toString(){
        return "ID: " +id+", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}
class Company{
    private String companyName;
    private Empl[] employees;
    private int numEmployees;

    public Company( String companyName,
                    Empl[] employees,
                    int numEmployees){

        this.companyName=companyName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }
    public  double getAverageSalary(){
        double sum=0;
        for(Empl employee: employees){
            sum+=employee.getSalary();
        }
        return sum/numEmployees;
    }
    public double getMaxSalary(){
        double maxSalary = Double.MIN_VALUE;
        for(Empl employee:employees){
            if(employee.getSalary()>maxSalary){
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }
    public Empl[] getEmployeesByDesignation(String designation){
        int count=0;
        for(Empl employee:employees){
            if(employee.getDesignation().equalsIgnoreCase(designation))
            {
                count++;
            }
        }
        Empl[] result = new Empl[count];
        int index =0;
        for(Empl employee:employees){
            if(employee.getDesignation().equalsIgnoreCase(designation))
            {
                result[index++] =employee;
            }
        }
        return result;
    }
}

public class emp2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	System.out.print("Enter company name:");
            String companyName=sc.nextLine();
	System.out.print("Enter number of employees: ");
            int NumOfEmp = sc.nextInt();
	sc.nextLine();
            Empl[] emp = new Empl[NumOfEmp];
	System.out.println("Enter employee details for Employee: ");
 	for(int i=0;i<emp.length;i++){
                System.out.println("Employee" +(i+1)+":");
                System.out.print("Enter id:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter name:");
                String name = sc.nextLine();
                System.out.print("Enter designation:");
                String designation = sc.nextLine();
                System.out.print("Enter salary:");
                double salary = sc.nextDouble();
                sc.nextLine();
                emp[i] = new Empl(id, name,designation,salary);
            }
     Company company = new Company(companyName,emp,NumOfEmp);



System.out.println("Average salary:" +company.getAverageSalary());

System.out.println("Max salary:" + company.getMaxSalary());

System.out.print("Enter designation to search: ");
            String searchDesignation = sc.nextLine();
            Empl[] employeeByDesignation = company.getEmployeesByDesignation(searchDesignation);
System.out.println("Employees with designation:" +searchDesignation);
for(Empl employee:employeeByDesignation){
                System.out.println(employee);
            }

	sc.close();
        }
    }










































