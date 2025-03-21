import java.util.*;
class Movie{
    private  String movieName;
    private String company;
    private String genre;
    private int budget;

    public Movie(String movieName, String company, String genre, int budget){
        this.movieName=movieName;
        this.company =company;
        this.genre =genre;
        this.budget=budget;
    }
    public String getMovieName(){
        return movieName;
    }
    public String getCompany(){
        return company;
    }
    public String getGenre(){
        return genre;
    }
    public int getBudget(){
        return budget;
    }

}
public class mov1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Movie[] m = new Movie[4];
        for(int i=0;i<m.length;i++){
            String a =sc.nextLine();
            String b =sc.nextLine();
            String c =sc.nextLine();
            int d =sc.nextInt();
            sc.nextLine();
            m[i]=new Movie(a,b,c,d);
        }
        String searchGenre = sc.nextLine();
        Movie[] ans = getMovieByGenre(m,searchGenre);
        for (Movie an : ans) {
            if (an.getBudget() > 80000000) {
                System.out.println("High Budget Movie");
            } else {
                System.out.println("Low Budget Movie");
            }
        }
    }

    public static Movie[] getMovieByGenre(Movie[] m,String searchGenre){
        Movie[] m1 = new Movie[0];
        for (Movie movie : m) {
            if (movie.getGenre().equalsIgnoreCase(searchGenre)) {
                m1 = Arrays.copyOf(m1, m1.length + 1);
                m1[m1.length - 1] = movie;
            }
        }
        return m1;
    }
}
