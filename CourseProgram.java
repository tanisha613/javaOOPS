import java.util.*;
class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    public Course(int courseId,String courseName,
                  String courseAdmin,int quiz, int handson){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }
    public int getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getCourseAdmin(){
        return courseAdmin;
    }
    public int getQuiz(){
        return quiz;
    }
    public int getHandson(){
        return handson;
    }
}

//create main class


public class CourseProgram{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        Course[] course = new Course[n];
        for(int i=0;i<course.length;i++){
            int cId =sc.nextInt();
            sc.nextLine();
            String cName=sc.nextLine();
            String cAdmin=sc.nextLine();
            int quiz = sc.nextInt();
            sc.nextLine();
            int handson = sc.nextInt();
            sc.nextLine();
            course[i] = new Course(cId,cName,cAdmin,quiz,handson);

        }
        String val = sc.nextLine();
        int hand = sc.nextInt();
        sc.nextLine();
        int ans1 = findAvgOfQuizByAdmin(course,val);
        if(ans1!=0){
            System.out.println(ans1);
        }
        else{
            System.out.println("No Course found.");
        }
        Course[] ans2 =sortCourseByHandsOn(course,hand);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getCourseName());
            }
        }
        else{
            System.out.println("No Course found with mentioned attribute.");
        }
    }
    //Implementing methods
    public static int findAvgOfQuizByAdmin(Course[] course, String val){
        int avg =0;
        int sum=0;
        int count=0;
        for(Course c:course){
            if(c.getCourseAdmin().equalsIgnoreCase(val)){

                sum+=c.getQuiz();
                count++;

            }}
        if(count>0) {
            avg = sum / count;
        }else {
            return avg;
        }
        return avg;
    }

    public static Course[] sortCourseByHandsOn(Course[] course,int hand){
        Course[] obj = new Course[0];
        for(int i=0;i<course.length;i++){
            if(course[i].getHandson()<hand){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=course[i];
            }
        }
        Course val;
        for(int i=0;i<obj.length;i++){
            for(int j=i+1;j<obj.length;j++){

                if(obj[i].getHandson()>obj[j].getHandson())
                {
                    val=obj[i];
                    obj[i]=obj[j];
                    obj[j]=val;}
            }

        }
        if(obj.length>0)
        {
            return obj;
        }
        else{
            return null;
        }
    }
}
