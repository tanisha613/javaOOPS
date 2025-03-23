import java.util.*;
class Engine{
    private int engineId;
    private String engineName;
    private String engineType;
    private double enginePrice;

    public Engine(int engineId,String engineName,String engineType,double enginePrice){
        this.engineId=engineId;
        this.engineName=engineName;
        this.engineType=engineType;
        this.enginePrice=enginePrice;
    }
    public int getEngineId(){
        return engineId;
    }
    public String getEngineName(){
        return engineName;
    }
    public String getEngineType(){
        return engineType;
    }
    public double getEnginePrice(){
        return enginePrice;
    }
}
class EngineSolution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Engine[] engine = new Engine[4];
        for(int i=0;i<engine.length;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b =sc.nextLine();
            String c=sc.nextLine();
            double d =sc.nextDouble();
            sc.nextLine();
            engine[i]= new Engine(a,b,c,d);
        }
        String PassedType =sc.nextLine();
        String PassedName =sc.nextLine();
        int ans1 =findAvgEnginePriceByType(engine,PassedType);
        if(ans1>0){
            System.out.println(ans1);

        }
        else{
            System.out.println("There are no engine with given type");
        }
        Engine[] ans2 =searchEngineByName(engine,PassedName);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getEngineId());
            }
        }
        else{
            System.out.println("There are no engine with the given name");
        }
    }
    public static int findAvgEnginePriceByType(Engine[] engine,String PassedType){
        int count=0;
        int sum=0;
        for(int i=0;i<engine.length;i++){
            if(engine[i].getEngineType().equalsIgnoreCase(PassedType)){

                sum+=engine[i].getEnginePrice();
                count++;
            }
        }
        if(count>0){
            return sum/count;
        }
        else{
            return 0;
        }
    }

    public static Engine[] searchEngineByName(Engine[] engine,String PassedName){
        Engine[] e = new Engine[0];
        Arrays.sort(engine,Comparator.comparingInt(Engine::getEngineId));
        for(int i=0;i<engine.length;i++){
            if(engine[i].getEngineName().equalsIgnoreCase(PassedName)){

                e=Arrays.copyOf(e,e.length+1);
                e[e.length-1]=engine[i];
            }
        }
        if(e.length>0){
            return e;
        }
        else{
            return null;
        }
    }
}

