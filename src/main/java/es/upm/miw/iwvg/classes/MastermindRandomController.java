package es.upm.miw.iwvg.classes;
import java.util.Arrays;
import java.util.Scanner;


public class MastermindRandomController {
    public MastermindRandomController(MastermindModel machineA){

        String solutionString = Arrays.toString(machineA.getSolution());
        int guessNumber = 1;
        boolean stopPlaying = false;
        while (stopPlaying==false){
            if (guessNumber > 10){ //board only has 10 rows (tries)
                System.out.println("***********************");
                System.out.println("Fin del Juego. Has perdido!!!.");
                System.out.println("El codigo correcto era: " + solutionString);
                System.out.println("***********************\n");
                break;
            }

            System.out.println("\nIntento? " + guessNumber + ": ");
            MastermindModel machineB=new MastermindModel();
            char[] guess = machineB.getSolution();
            this.print(guess);
            stopPlaying = isCorrect(guess, machineA.getSolution()); //stop playing when you guess correctly
            int rightColorRightPlace = getRightColorRightPlace(guess, machineA.getSolution());
            int rightColorWrongPlace = getRightColorWrongPlace(guess, machineA.getSolution());
            int correctedRightColorWrongPlace = rightColorWrongPlace - rightColorRightPlace;
            System.out.println("\n"+ rightColorRightPlace+ " muertos");
            System.out.println("y "+ correctedRightColorWrongPlace +" heridos");
            guessNumber++;


        }
        if (stopPlaying==true){
            System.out.println("***********************");
            System.out.println("Victoria!!!");
            System.out.println("***********************\n");
        }
    }

    public boolean isCorrect(char[] guess, char[] solution){
        boolean guessIsCorrect = false;
        if (Arrays.equals(guess, solution)) {
            guessIsCorrect=true;
        }
        return guessIsCorrect;
    }

    public int getRightColorRightPlace(char[] guess,char[] solution){
        int rightColorRightPlace = 0;
        for (int i=0; i<guess.length;i++){

            if (guess[i] == solution[i]){
                rightColorRightPlace++;
            }
        }
        return rightColorRightPlace;
    }

    public int getRightColorWrongPlace(char[] guess, char[] solution){
        int totalMalpositioned = 0;
        int [] guessArrayCounts = new int[6];
        int [] solutionArrayCounts = new int[6];
        char guessValue = 'y';
        char solutionValue = 'x';
        for (int i=0; i < 4; i++){
            guessValue = guess[i];
            solutionValue = solution[i];
            int guessColorAsInt = colorChartoInt(guessValue);
            int solutionColorAsInt = colorChartoInt(solutionValue);
            guessArrayCounts[guessColorAsInt-1]+=1;// subtract one as a correction from the numbering scheme I used to array counting from 0
            solutionArrayCounts[solutionColorAsInt-1]+=1;
        }
        for (int j=0; j< solutionArrayCounts.length; j++) {
            totalMalpositioned += Math.min(guessArrayCounts[j], solutionArrayCounts[j]);
        }
        return totalMalpositioned;
    }

    //converts char back to corresponding int to use in an array position. Numbers are arbitrary.
    private int colorChartoInt(char colorChar){
        int colorInt = 0; //0 unassigned to any color.
        if (colorChar == 'A'){
            colorInt = 1;
        }
        else if (colorChar == 'R'){
            colorInt = 2;
        }
        else if (colorChar == 'V'){
            colorInt = 3;
        }
        else if (colorChar == 'Z'){
            colorInt = 4;
        }
        else if (colorChar == 'B'){
            colorInt = 5;
        }
        else if (colorChar == 'N'){
            colorInt = 6;
        }
        return colorInt;
    }

    public void print(char[] guess){
        String line="";
        for (int i = 0; i <guess.length ; i++) {
            line+=Character.toString(guess[i]);
        }
        System.out.println(line);
    }

}
