import java.util.*;
 class Employee{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary ;
    public Employee(int employeeId, String employeeName, int age, char gender, double salary)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age=age;
        this.gender=gender;
        this.salary = salary;


    }
    public  int getEmployeeId(){
        return employeeId;
    }
    public  String getEmployeeName(){
        return employeeName;
    }
    public  int getAge(){
        return age;
    }
    public  char getGender(){
        return gender;
    }
    public  double getSalary(){
        return salary;
    }
}
class empl{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            char d = sc.next().charAt(0);
            double e = sc.nextDouble();
            sc.nextLine();
            emp[i] = new Employee(a, b, c, d, e);
        }
        Employee ans = getEmployeeWithSecondLowestSalary(emp);
        int eAge = sc.nextInt();
        sc.nextLine();
        if (ans != null) {
            System.out.println(ans.getEmployeeId() + "#" + ans.getEmployeeName());
        } else {
            System.out.println("Null");
        }

        int ans2 = countEmployeesBasedOnAge(emp, eAge);
        if (ans2 > 0) {
            System.out.println(ans2);
        } else {
            System.out.println("No employee found for the given age");
        }

    }

        public static Employee getEmployeeWithSecondLowestSalary(Employee[] emp){
            if(emp.length<2){
                return null;
            }
            Arrays.sort(emp,Comparator.comparingDouble(Employee::getSalary));
            double first = emp[0].getSalary();
            double second = Double.MAX_VALUE;
            for(int i=1;i<emp.length;i++){
                if(emp[i].getSalary()!=first){
                    second = emp[i].getSalary();
                    break;
                }
            }
            for(Employee e: emp){
                if(e.getSalary() == second){
                    return e;
                }
            }
            return null;
        }
        public static int countEmployeesBasedOnAge(Employee[] emp, int eAge){
            int count=0;
            for(int i=0;i<emp.length;i++){
                if(emp[i].getAge()==eAge){
                    count++;
                }}
            return count;


        }

    }

