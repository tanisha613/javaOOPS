import java.util.*;
class Student{
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;
    public Student(int rollNo, String name, String subject, char grade, String date){
        this.rollNo=rollNo;
        this.name=name;
        this.subject=subject;
        this.grade=grade;
        this.date=date;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getName()
    {
        return name;
    }
    public String getSubject(){
        return subject;
    }
    public char getGrade(){
        return grade;
    }
    public String getDate(){
        return date;
    }
}
public class stud1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] s = new Student[4];
        for(int i=0;i<s.length;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            char d=sc.nextLine().charAt(0);
            String e =sc.nextLine();
            s[i]=new Student(a,b,c,d,e);
        }
        char gra =sc.nextLine().charAt(0);
        int mon =sc.nextInt();
        Student[] ans=findStudentByGradeAndMonth(s,gra,mon);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getName());
                System.out.println(ans[i].getSubject());
            }
            System.out.println(ans.length);

        }
        else{
            System.out.println("No Student found");
        }
    }
    public static Student[] findStudentByGradeAndMonth(Student[] s,char gra,int mon){

        Student[] s1 =new Student[0];
        for(int i=0;i<s.length;i++){
            String[] month =s[i].getDate().split("/");
            if(s[i].getGrade()==gra && Integer.parseInt(month[1])==mon)
            {
                s1=Arrays.copyOf(s1,s1.length+1);
                s1[s1.length-1]=s[i];
            }
        }
        Student data;
        for(int i=0;i<s1.length-1;i++){
            for(int j=i+1;j<s1.length;j++){
                if(s1[i].getRollNo()>s1[j].getRollNo())
                {
                    data=s1[i];
                    s1[i]=s1[j];
                    s1[j]=data;
                }
            }
        }

        if(s1.length>0){
            return s1;
        }
        else{
            return null;
        }

    }
}
