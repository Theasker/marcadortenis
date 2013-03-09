
package marcadortenis;

public class MarcadorTenis {
  public static void main(String[] args){
    SolicitarDatos pedir = new SolicitarDatos();
    Marcador marcador = new Marcador();
    while(marcador.setCounter != 6){
      marcador.sumarPunto(pedir.pedirJugador());
      marcador.verMarcador();
    }
    
    
  }
}
