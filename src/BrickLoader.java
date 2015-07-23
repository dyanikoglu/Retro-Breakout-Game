import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BrickLoader {
    public static Brick brickArr[] = new Brick[110];
    private static String splitArr[][] = new String[110][];
    private static Path workingDirectory= Paths.get("").toAbsolutePath();

    public static void create() {
        read();
        for(int i=0;i<splitArr.length;i++) {
            if(Integer.parseInt(splitArr[i][2])==0) {
                brickArr[i]= new NormalBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==1) {
                brickArr[i]= new StoneBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==2) {
                brickArr[i]= new GemBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==3) {
                brickArr[i]= new GlassBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
            else if(Integer.parseInt(splitArr[i][2])==4) {
                brickArr[i]= new BorderBrick(Integer.parseInt(splitArr[i][0]),Integer.parseInt(splitArr[i][1]));
            }
        }
    }

    private static void read() {
        int i=0;
        File f = new File(workingDirectory.toString()+"\\src\\txt\\bricks.txt"); // EDIT
        try {
            Scanner scan = new Scanner(f);

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                splitArr[i++]=line.split(",");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
