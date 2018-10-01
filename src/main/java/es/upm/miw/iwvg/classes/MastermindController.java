package es.upm.miw.iwvg.classes;

import java.util.Arrays;

public class MastermindController {

    public MastermindController(MastermindModel model){

        String solutionString = Arrays.toString(model.getSolution());
        java.util.Scanner input = new java.util.Scanner(System.in);

        int guessNumber = 1;
        boolean stopPlaying = false;
        while (stopPlaying==false){
            if (guessNumber > 10){
                System.out.println("***********************");
                System.out.println("Fin del Juego. Has perdido!!!.");
                System.out.println("El codigo correcto era: " + solutionString);
                System.out.println("***********************\n");
                break;
            }
            System.out.println("\nIntento? " + guessNumber + ": ");
            String guess = input.nextLine();
            if (guess.length() ==4){
                if ((guess.contains("A") || guess.contains("B") ||guess.contains("N")
                        || guess.contains("R") || guess.contains("V") ||guess.contains("Z"))){
                    stopPlaying = isCorrect(guess, model.getSolution());
                    int rightColorRightPlace = getRightColorRightPlace(guess, model.getSolution());
                    int rightColorWrongPlace = getRightColorWrongPlace(guess, model.getSolution());
                    int correctedRightColorWrongPlace = rightColorWrongPlace - rightColorRightPlace;
                    System.out.println("\n"+ rightColorRightPlace+ " muertos");
                    System.out.println("y "+ correctedRightColorWrongPlace +" heridos");
                    guessNumber++;
                }
                else{
                    System.out.println("Los colores introducidos no son validos. Intenta de nuevo! \n");
                }
            }
            else if (guess.length() != 4){
                System.out.println("Te faltan colores por identificar!");
            }
        }
        if (stopPlaying==true){
            System.out.println("***********************");
            System.out.println("Victoria!!!");
            System.out.println("***********************\n");
        }
    }

    public boolean isCorrect(String guess, char[] solution){
        boolean guessIsCorrect = false;
        char[] guessArray = guess.toCharArray();
        if (Arrays.equals(guessArray, solution)) {
            guessIsCorrect=true;
        }
        return guessIsCorrect;
    }

    public int getRightColorRightPlace(String guess,char[] solution){
        int rightColorRightPlace = 0;
        char[] guessArray = guess.toCharArray();
        for (int i=0; i<guessArray.length;i++){

            if (guessArray[i] == solution[i]){
                rightColorRightPlace++;
            }
        }
        return rightColorRightPlace;
    }

    public int getRightColorWrongPlace(String guess, char[] solution){
        char[] guessArray = guess.toCharArray();
        int totalMalpositioned = 0;
        int [] guessArrayCounts = new int[6];
        int [] solutionArrayCounts = new int[6];
        char guessValue = 'y';
        char solutionValue = 'x';
        for (int i=0; i < 4; i++){
            guessValue = guessArray[i];
            solutionValue = solution[i];
            int guessColorAsInt = colorChartoInt(guessValue);
            int solutionColorAsInt = colorChartoInt(solutionValue);
            guessArrayCounts[guessColorAsInt-1]+=1;
            solutionArrayCounts[solutionColorAsInt-1]+=1;
        }
        for (int j=0; j< solutionArrayCounts.length; j++) {
            totalMalpositioned += Math.min(guessArrayCounts[j], solutionArrayCounts[j]);
        }
        return totalMalpositioned;
    }

    private int colorChartoInt(char colorChar){
        int colorInt = 0;
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
}
