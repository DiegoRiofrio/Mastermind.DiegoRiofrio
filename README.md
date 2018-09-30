Mastermind.java# DIEGO RIOFRIO

### 1. Opción A: Master Mind

Permite al usuario jugar al Master Mind: https://es.wikipedia.org/wiki/es.upm.miw.iwvg.daoo.classes.Mastermind con las siguientes variaciones en la aplicación:


* Solicitará al usuario por consola si desea jugar contra la máquina (partida) o que juegue la máquina sola (demo)
* En cualquier caso, generará automáticamente el código secreto
* Para la partida, solicitará al usuario por consola la combinación que desea intentar y mostrará automáticamente el número de muertos (acierto en posicióny color) y de heridos (acierto en color y no en posición)
* Para la demo, se generarán intentos automáticos aleatoriamente
* Cuando termine la partida tras 10 intentos fallidos o victoria al coincidir el intento con el secreto, preguntará si desea continuar

### Interfaz de texto parecido a:
1. Partida
2. Demo
Opicón? 1<enter>
Secreto: ****
Intento? [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro] AARR<enter>
0 muertos y 2 heridos
Intento? [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro] NBAA<enter>
4 muertos!!! Victoria

1. Partida
2. Demo
Opicón? 2<enter>
Secreto: ****
Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul,
B-blanco, N-negro] AARR
0 muertos y 2 heridos
Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul,
B-blanco, N-negro] NBAA
4 muertos!!! Victoria


### Tecnologías necesarias
* Java
* Maven
* GitHub


import java.util.Scanner;
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
