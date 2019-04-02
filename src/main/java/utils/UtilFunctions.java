package utils;

import java.util.Scanner;

public class UtilFunctions {

// Print the Playfield Matrix showing location of Pacman
    public void printArea(int[][] arr , int x,int y){

        for(int i=0 ; i<x;i++){
            String pacmanOrg = "";
            for(int j=0; j<y;j ++){

                pacmanOrg += arr[i][j] + " ";
                if(j == y-1)
                System.out.println(pacmanOrg);

            }
        }

    }

//Function to check If a String is Numeric
    public boolean isNumeric(String strNum) {

        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

//Convert or Type Cast String to Int
    public int convertToInt(String val){
        int retVal=0;
        if(isNumeric(val)){
            retVal = Integer.parseInt(val);

        }
        return retVal;
    }

// Command Processing : Left Turn
    public String turnLeft(String dir){
        String dirRet="";
        if(dir.equalsIgnoreCase("E"))
            dirRet="N";
        else if (dir.equalsIgnoreCase("W"))
            dirRet="S";
        else if (dir.equalsIgnoreCase("S"))
            dirRet="E";
        else
            dirRet="W";


        return dirRet;
    }

// Command Processing : Right Turn
    public String turnRight(String dir){
        String dirRet="";
        if(dir.equalsIgnoreCase("E"))
            dirRet="S";
        else if (dir.equalsIgnoreCase("W"))
            dirRet="N";
        else if (dir.equalsIgnoreCase("S"))
            dirRet="W";
        else
            dirRet="E";


        return dirRet;
    }


// Command Processing : Move a Step Forward
    public int[] move(int[]cords,int x, int y ,String dir){

        if(dir.equalsIgnoreCase("E") && cords[0]<x-1){
            cords[0]=cords[0]+1;
        }

        else if (dir.equalsIgnoreCase("W") && cords[0]>0){
            cords[0]=cords[0]-1;
        }
        else if (dir.equalsIgnoreCase("S") && cords[1]>0){

            cords[1]=cords[1]-1;
        }

        else if (dir.equalsIgnoreCase("N")  && cords[1] < y - 1) {
                cords[1] = cords[1] + 1;
        }
        else
            System.out.println("Cannot Move out of Play Area : Turn Right or Left");


        return cords;
    }


//Game Rules Information Panel
    public void gameInfo(){
        System.out.println("###############################\n" +
                "Info : Moves Allowed : \n" +
                "1. PLACE X,Y,F \n" +
                "2. L : For Left \n" +
                "3. R : For Right \n" +
                "4. D : Report \n" +
                "5. M : Move \n" +
                "EXIT : To stop the game \n" +
                "Note : First move hase to be PLACE X,Y,F \n" +
                "Valid Valuse for X and Y are numbers \n" +
                "Valid Values for F are : \n" +
                "E For East \n" +
                "N For North \n" +
                "W for West \n" +
                "S for South \n" +
                "################################"
        );
    }



//Cheking If the Place command is in Correct Format
    public String[] checkPlaceValidity(String[] splitWord1, int x,int y,Scanner sc) {

        while (!(splitWord1.length==2)){
            System.out.println("Enter Valid Place");
            splitWord1 = sc.next().split(" ");
        }
        String[] splitWord2 = splitWord1[1].split(",");
        while (!splitWord1[0].equalsIgnoreCase("place") ||
                !isNumeric(splitWord2[0]) ||
                !(convertToInt(splitWord2[0]) < x) ||
                !(convertToInt(splitWord2[1]) < y) ||
                !isNumeric(splitWord2[1]) ||
                !(splitWord1.length == 2) ||
                !(splitWord2.length == 3) ||
                !(splitWord2[2].equalsIgnoreCase("E") ||
                        splitWord2[2].equalsIgnoreCase("W") ||
                        splitWord2[2].equalsIgnoreCase("N") ||
                        splitWord2[2].equalsIgnoreCase("S"))


                ) {
            System.out.println("Enter Valide Place");
            splitWord1 = sc.next().split(" ");
            if (splitWord1[0].equalsIgnoreCase("exit")){
                System.exit(0);
            }
            while (!(splitWord1.length==2)){
                System.out.println("Enter Valid Place");
                splitWord1 = sc.next().split(" ");
                if (splitWord1[0].equalsIgnoreCase("exit")){
                    System.exit(0);
                }
            }
            splitWord2 = splitWord1[1].split(",");
        }
        return splitWord1;
    }


//Calculating New Cordinates after making a Move
    public int[] calculateNewCords(String[] splitWord2){
        int x_cord = convertToInt(splitWord2[0]);
        int y_cord = convertToInt(splitWord2[1]);
        int[] newCords = {x_cord,y_cord};
        return newCords;

    }


}
