package marcadortenis;

import java.util.Scanner;

public class SolicitarDatos {
  public int pedirJugador(){
    Scanner pedir = new Scanner(System.in);
    int jugador = 0;
    while ((jugador != 1) && (jugador !=2)){
      try{
        System.out.println("Introduce el jugador que ha ganado el punto:");
        jugador = Integer.parseInt(pedir.nextLine());
      }catch (Exception e){
        System.out.println("Hay que introducir el 1 ó el 2");
      }
    }
    return jugador;
  }
}
