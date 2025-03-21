//mention all the packages
import java.util.*;

//creating class named Player
class Player{
    private int playerId;
    private String skill;
    private String level;
    private int points;

    //creating constructor
    public Player(int playerId,String skill,String level,int points){
        this.playerId=playerId;
        this.skill=skill;
        this.level=level;
        this.points=points;
    }

    //writing getters
    public int getPlayerId(){
        return playerId;
    }
    public String getSkill(){
        return skill;
    }
    public String getLevel(){
        return level;
    }
    public int getPoints(){
        return points;
    }
}

//creating main method

public class player1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
//creating array of Player objects
        Player[] player = new Player[n];
        for(int i=0;i<player.length;i++){
            int pId = sc.nextInt();
            sc.nextLine();
            String sk = sc.nextLine();
            String lev = sc.nextLine();
            int points = sc.nextInt();
            sc.nextLine();
            player[i] = new Player(pId,sk,lev,points);
        }
        String passedSkill = sc.nextLine();
        String passedLevel = sc.nextLine();
//printing the answers
        int firstMethod = findPointsForGivenSkill(player,passedSkill);
        if(firstMethod!=0){
            System.out.println(firstMethod);
        }
        else{
            System.out.println("The given Skill is not available");
        }
        Player secondMethod = getPlayerBasedOnLevel(player,passedLevel,passedSkill);
        if(secondMethod!=null){
            System.out.println(secondMethod.getPlayerId());
        }
        else{
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }
    // creating first method
    public static int findPointsForGivenSkill(Player[] player,String passedSkill){
        int sum=0;
        for(Player p:player){
            if(p.getSkill().equalsIgnoreCase(passedSkill)){
                sum+=p.getPoints();
            }
        }
        if(sum>0){
            return sum;
        }
        return 0;
    }
//Creating second method

    public static Player getPlayerBasedOnLevel(Player[] player, String passedLevel, String passedSkill){
        for(Player p:player){
           	if(p.getLevel().equalsIgnoreCase(passedLevel)&&p.getSkill().equalsIgnoreCase(passedSkill)&&p.getPoints()>=20){

                return p;

            }
        }
        return null;
    }}


