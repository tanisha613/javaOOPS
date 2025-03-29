import java.util.*;
class Cinema{
    private int movieId;
    private String director;
    private int rating;
    private int budget;

    public Cinema(int movieId, String director,int rating,int budget){
        this.movieId=movieId;
        this.director=director;
        this.rating =rating;
        this.budget=budget;
    }
    public int getMovieId(){
        return movieId;
    }
    public String getDirector(){
        return director;
    }
    public int getRating(){
        return rating;
    }
    public int getBudget(){
        return budget;
    }
}
public class cinemaSolution{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Cinema[] c =new Cinema[4];
        for(int i=0;i<c.length;i++){
            int m=sc.nextInt();
            sc.nextLine();
            String d =sc.nextLine();
            int r =sc.nextInt();
            sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            c[i]=new Cinema(m,d,r,b);
        }
        String passedDirector =sc.nextLine();
        int pRating =sc.nextInt();
        sc.nextLine();
        int pBudget =sc.nextInt();
        sc.nextLine();
        int ans1 =findAvgBudgetByDirector(c,passedDirector);
        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("Sorry-The given director has not yet directed any movie");
        }
        Cinema[] ans2 =getMovieByRatingBudget(c,pRating,pBudget);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getMovieId());
            }
        }else{
            System.out.println("Sorry-No movie is  available with the specified rating and budget requirement");
        }
    }

    public static int findAvgBudgetByDirector(Cinema[] c ,String passedDirector){
        int sum=0;
        int count=0;
        for(int i=0;i<c.length;i++){
            if(c[i].getDirector().equalsIgnoreCase(passedDirector)){
                sum+=c[i].getBudget();
                count++;
            }
        }if(count>0){
            return sum/count;
        }
        else{
            return 0;
        }
    }
    public static Cinema[] getMovieByRatingBudget(Cinema[] m,int pRating, int pBudget){
        Cinema[] c1 =new Cinema[0];
        for(int i=0;i<m.length;i++){
            if(m[i].getRating()==pRating && m[i].getBudget()==pBudget && m[i].getBudget()%m[i].getRating()==0){
                c1=Arrays.copyOf(c1,c1.length+1);
                c1[c1.length-1]=m[i];
            }
        }
        if(c1!=null){
            return c1;
        }
        else{
            return null;
        }
    }
}

