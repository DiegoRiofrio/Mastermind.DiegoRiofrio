package es.upm.miw.iwvg.classes;

public class Mastermind {

    public static void main(String[] args){
        System.out.println("***********************");
        System.out.println("Bienvenido a Mastermind!");
        System.out.println("***********************");
        System.out.println();
        while(true){
            System.out.println("Elige una opción: \n 1. Partida \n 2. Demo \n 3. Salir del juego ");
            java.util.Scanner input = new java.util.Scanner(System.in);
            String playVar = input.nextLine();
            if (playVar.equalsIgnoreCase("1")){
                System.out.println("Intenta adivinar un código de 4 letras de entre:");
                System.out.println(" A-Amarillo, R-Rojo, V-Verde, Z-Azul, B-Blanco, N-Negro");
                MastermindModel gameModel = new MastermindModel();
                MastermindController gameController = new MastermindController(gameModel);
            }
            else if (playVar.equalsIgnoreCase("2")){
                System.out.println("A continuación se realizará una demostración del juego");
                System.out.println("El objetivo del juego es intenta adivinar un código de 4 letras de entre:");
                System.out.println(" A-Amarillo, R-Rojo, V-Verde, Z-Azul, B-Blanco, N-Negro");
                MastermindModel machineModelA = new MastermindModel();
                MastermindRandomController machineController = new MastermindRandomController(machineModelA);
            }
            else if (playVar.equalsIgnoreCase("3")) {
                System.out.println("Adiós!");
                break;
            }
            else{
                System.out.println("Respuesta no válida. Elige entre una de las opciones.");
            }
        }
    }
}