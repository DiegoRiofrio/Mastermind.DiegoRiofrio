package es.upm.miw.iwvg.classes;

import java.util.Random;
class MastermindModel{

    private int[] solutionArray = new int[4];
    private char[] colorSolutionArray = new char[4];

    public MastermindModel(){
        solutionArray[1] = (int)(Math.random()*6+1);
        solutionArray[2] = (int)(Math.random()*6+1);
        solutionArray[3] = (int)(Math.random()*6+1);
        solutionArray[0] = (int)(Math.random()*6+1);
        colorSolutionArray[0] = getColorAt(0);
        colorSolutionArray[1] = getColorAt(1);
        colorSolutionArray[2] = getColorAt(2);
        colorSolutionArray[3] = getColorAt(3);
    }

    public char getColorAt(int i){
        char color='x'; //variable initialized to x as it doesn't corrrespond to any color.
        if (solutionArray[i]==1){
            color = 'A' ;
        }
        else if (solutionArray[i]==2){
            color = 'R';
        }
        else if (solutionArray[i]==3){
            color = 'V';
        }
        else if (solutionArray[i]==4){
            color = 'Z';
        }
        else if (solutionArray[i]==5){
            color = 'B';
        }
        else if (solutionArray[i] ==6){
            color = 'N';
        }
        return color;
    }

    public char[] getSolution(){
        return colorSolutionArray;
    }
}
