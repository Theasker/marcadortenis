package marcadortenis;

public class Marcador {
  final int PUNTOS = 0;
  final int JUEGOS = 1;
  final int SETS = 2;
  final int SET1 = 3;
  final int SET2 = 4;
  final int SET3 = 5;
  final int SET4 = 6;
  final int SET5 = 7;
  public int setCounter = 1;
  private int[] m1 = {0,0,0,0,0,0,0,0};
  private int[] m2 = {0,0,0,0,0,0,0,0};
  final String[] tanteo = {"0","15","30","40","Vent"};
  
  public void verMarcador(){
    int dif;
    if (this.setCounter < 6){ //si aun no ha acabado el partido
      System.out.println("Set en juego:"+this.setCounter);
    }else System.out.println("Final de partido");
    System.out.println("Puntos\tJuegos\tSets\tSet1\tSet2\tSet3\tSet4\tSet5");
    
    // m1: puntos en juego 0,15,30,40,Vent.
    if(this.m1[PUNTOS]<4){// es 0,15,30,40
      System.out.print(this.tanteo[this.m1[PUNTOS]]+"\t");
    }else{ //Ventaja
      if (this.m1[PUNTOS] > this.m2[PUNTOS]){ // va ganando m1
        System.out.print(this.tanteo[4]+"\t");
      }else {
        System.out.print(this.tanteo[3]+"\t");
      }
    }
    for(int cont=1;cont<8;cont++){
      System.out.printf("%d\t",this.m1[cont]);
    }
    System.out.print("\n");
    
    // m2: puntos en juego 0,15,30,40,Vent.
    if(this.m2[PUNTOS]<4){// es 0,15,30,40
      System.out.print(this.tanteo[this.m2[PUNTOS]]+"\t");
    }else{ //Ventaja
      if (this.m2[PUNTOS] > this.m1[PUNTOS]){ // va ganando m1
        System.out.print(this.tanteo[4]+"\t");
      }else {
        System.out.print(this.tanteo[3]+"\t");
      }
    }
    for(int cont=1;cont<8;cont++){
      System.out.printf("%d\t",this.m2[cont]);
    }
    System.out.print("\n");
  }
  public void sumarPunto(int jugador){
    switch (jugador){
      case 1:
        this.m1[PUNTOS]++;
        this.comprobarMarcadores(1);
        break;
      case 2:
        this.m2[PUNTOS]++;
        this.comprobarMarcadores(2);
        break;
    }
  } 
  private void comprobarMarcadores(int jugador){
    int dif;//variable para la diferencia entre el tanteo de un jugador y otro.
    switch (jugador){
      case 1:
        dif = this.m1[PUNTOS] - this.m2[PUNTOS];
        if ((this.m1[PUNTOS] > 3 ) && (dif > 1)){ // ha ganado el juego
          this.m1[JUEGOS]++;
          this.m1[PUNTOS] = 0;
          this.m2[PUNTOS] = 0;
          if ((this.m1[JUEGOS]) == 6){ // ha ganado el set
            this.m1[SETS]++;
            this.setGanado();            
          }
        }
        break;
      case 2:
        dif = this.m2[PUNTOS] - this.m1[PUNTOS];
        if ((this.m2[PUNTOS] > 3 ) && (dif > 1)){ // ha ganado el juego
          this.m2[JUEGOS]++;
          this.m1[PUNTOS] = 0;
          this.m2[PUNTOS] = 0;
          if ((this.m2[JUEGOS]) == 6){ // ha ganado el set
            this.m2[SETS]++;
            this.setGanado();            
          }
        }
        break;
    }
  }
  private void setGanado(){
    //movemos el marcador de juegos al set que corresponde
    switch (this.setCounter){
      case 1:
        this.m1[SET1] = this.m1[JUEGOS];
        this.m2[SET1] = this.m2[JUEGOS];
        break;
      case 2:
        this.m1[SET2] = this.m1[JUEGOS];
        this.m2[SET2] = this.m2[JUEGOS];
        break;
      case 3:
        this.m1[SET3] = this.m1[JUEGOS];
        this.m2[SET3] = this.m2[JUEGOS];
        break;
      case 4:
        this.m1[SET4] = this.m1[JUEGOS];
        this.m2[SET4] = this.m2[JUEGOS];
        break;
      case 5:
        this.m1[SET5] = this.m1[JUEGOS];
        this.m2[SET5] = this.m2[JUEGOS];
        break;
    }
    this.m1[JUEGOS] = 0;
    this.m2[JUEGOS] = 0;
    this.setCounter++;
  }
}
