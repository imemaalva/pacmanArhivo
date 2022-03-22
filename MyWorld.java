import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyWorld extends World
{
    public static final int FILAS = 18;
    public static final int COL = 11;
    public String arr[][];
    public String reading = " ";
    private static final int WALL_SIDE = 28;
    
    public MyWorld()
    {      
        super(WALL_SIDE*FILAS,WALL_SIDE*COL, 1);
        
        getBackground().fill();
        int j=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader ("PacmanLevel1.txt"));
    
            String currLine=br.readLine();
            while(currLine != null){
                reading = currLine;
                currLine = br.readLine();
                String []arr = reading.split("");
                for (int i=0; i<arr.length; i++){
                    switch(arr[i]){
                        case "b":
                            SmallBall smallBall = new SmallBall();
                            addObject(smallBall,WALL_SIDE*i+14,WALL_SIDE*j+14);      
                        break;
                        case "X" :   
                            Wall wall = new Wall();
                            addObject(wall,WALL_SIDE*i+14,WALL_SIDE*j+14); 
                        break;
                        case "B":
                            BigBall bigBall = new BigBall();
                            addObject(bigBall,WALL_SIDE*i+14,WALL_SIDE*j+14);
                        break;
                        
                        case "S":
                            Strowberry strawberry = new Strowberry();
                            addObject(strawberry,WALL_SIDE*i+14,WALL_SIDE*j+14);
                        break;
                         case "C":
                            Cherry cherry = new Cherry();
                            addObject(cherry,WALL_SIDE*i+14,WALL_SIDE*j+14);
                        break;
                    }
                  
                }   
                j++;
            }
            br.close();
            
              
        }catch(IOException e){
            e.printStackTrace();
        }
      
    }
       
}