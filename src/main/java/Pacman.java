import java.util.*;


import utils.UtilFunctions;

public class Pacman {
    public static void main(String[] args) {
        UtilFunctions utils = new UtilFunctions();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        int x = 0;
        int y = 0;
    // Create Play Field
        System.out.println("Info : For play are of 4*5,Enter X=4 and Y=5");
        System.out.println("Please enter X");


        while (!sc.hasNextInt()) {
            System.out.println("Please Enter a valid number");
            sc.next();
        }
        x= sc.nextInt();

        System.out.println("Please enter Y");
        while (!sc.hasNextInt()) {
            System.out.println("Please Enter a valid number");
            sc.next();
        }
        y= sc.nextInt();

        utils.gameInfo();

    // Make First Move. It has to be Place to fix a start position
        System.out.println("Enter the First Move in the format PLACE X,Y,F");
        String[] splitWord1 = sc.next().split(" ");

        splitWord1 = utils.checkPlaceValidity(splitWord1,x,y,sc);
        String[] splitWord2 = splitWord1[1].split(",");
        System.out.println("array size " + splitWord2.length + " " + splitWord2[0]);
        int[] cordinates = utils.calculateNewCords(splitWord2);
        String direction = splitWord2[2];
        splitWord1 = new String[splitWord1.length];
        splitWord2 = new String[splitWord2.length];
        int[][] pacmanPlayArea = new int[x][y];
        pacmanPlayArea[cordinates[0]][cordinates[1]] = 1;
        utils.printArea(pacmanPlayArea,x,y);

    //Start Playing the game
        System.out.println("Pacman is placed in the desired spot. Start Play");
        String input=sc.next();
        while(!input.equalsIgnoreCase("exit")){
            if(input.equalsIgnoreCase("L")){

                direction = utils.turnLeft(direction);
                input=sc.next();
            }
            else if(input.equalsIgnoreCase("R")){
                direction= utils.turnRight(direction);
                input=sc.next();
            }
            else if(input.equalsIgnoreCase("M")){
                pacmanPlayArea[cordinates[0]][cordinates[1]] = 0;
                cordinates=utils.move(cordinates,x,y,direction);
                pacmanPlayArea[cordinates[0]][cordinates[1]] = 1;
                input=sc.next();
            }
            else if((splitWord1=input.split(" "))[0].equalsIgnoreCase("Place")){
                splitWord1 = utils.checkPlaceValidity(splitWord1,x,y,sc);
                splitWord2=splitWord1[1].split(",");
                cordinates = utils.calculateNewCords(splitWord2);
                direction = splitWord2[2];
                pacmanPlayArea = new int[x][y];
                pacmanPlayArea[cordinates[0]][cordinates[1]]=1;
                input=sc.next();

            }
            else if(input.equalsIgnoreCase("D")){
                utils.printArea(pacmanPlayArea,x,y);
                System.out.println("-------------");
                System.out.println(cordinates[0]+","+cordinates[1]+","+direction.toUpperCase());
                input=sc.next();
            }
            else{
                System.out.println("Enter Valide Command");
                input = sc.next();}

        }

    }

}
