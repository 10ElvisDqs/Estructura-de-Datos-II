package proyecto1_ed2;
import java.util.Random;
import javax.swing.JOptionPane;
/******************************************
 *                                        *
 *   @author Quinteros Siles Elvis David  *
 *              5to Semestre              * 
 *                  2022                  * 
 *          Estructura de Datos 2         *
 *              lenguaje Java             *
 *            Proyecto Recursivo          *
 *                                        * 
 ******************************************/
public class Matriz {
//dimenciones para la matriz
 private int f; //fila
 private int c; //columnas
 private String [][]m;

	

/////////////////////////  M E T O D O S  ///////////////////////////////////

Matriz(){
	f=0;
	c=0;
        m=new String [f][c];
}

Matriz(int _fila, int _columna)
{
  f=_fila;
  c=_columna;
  m=new String [f][c];
}

public void setFilas(int _fila){
	this.f=_fila;
}

public void setColumnas(int _columna){
	this.c= _columna;
}

public void setElemento(int _fila, int _columna, String _valor){
	if (_fila<f && _columna<c){
		m[_fila][_columna]= _valor;
	}
}

public int getFilas(){
	return f;
}

public int getColumnas(){
	return c;
}

 public String getElemento(int _fila, int _columna){
	//if (_fila<f && _columna<c){
		return m[_fila][_columna];
	//}
      }
 public void cargarMatriz (Vector vec){
        Random Naleatorio=new Random();
	//metodo "" que nos permite iniciar la funcion rand
	for (int i=0; i<f; i++){      //filas   f
		for (int j=0; j<c; j++ ){ //columnas  c
		       
                                
                                int n=Naleatorio.nextInt(4);
		      boolean repeated=false; 
                                //m[i][j]=vec.getNombre(n);
                                 for (int k = 0; k < j; k++)
                                {
                                    if (m[i][k].equals(vec.getNombre(n)))
                                    {
                                        repeated = true;
                                    }
                                 }
                                 
                                 if (!repeated)
                                    {
                                       m[i][j]=vec.getNombre(n);
                                    }else{
                                     j--;
                                 }
                  
		}
	}
}
 
public void seRepite(int fila){
    for (int i = 0; i < fila; i++) {
        for (int j = 0; j < c; j++) {
         if( m[i][j+1] == m[0][0]){
            JOptionPane.showMessageDialog(null, m[i][j]+"="+m[0][0]);
            
         }   
        }
    }
}

public void iniciarTablero(int posf){
    
    if (posf<f) {       
        int posc=0;    
        while(posc<c) {   
            m[posf][posc]=null;
            posc++;         
        }
        //JOptionPane.showMessageDialog(null,"salio del bucle");
        iniciarTablero(posf+1);
    }
}

public boolean verificarDiaAriIzq(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarDiaAriIzq(dato,posf-1,posc-1); 
        }
    }
    return resultado;
    
}

public boolean verificarDiaAriDer(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarDiaAriDer(dato,posf-1,posc+1);
        }
    }
    return resultado;
    
}

public boolean verificarDiaAbaIzq(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarDiaAbaIzq(dato,posf+1,posc-1); 
        }
    }
    return resultado;
    
}

public boolean verificarDiaAbaDer(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarDiaAbaDer(dato,posf+1,posc+1); 
        }
    }
    return resultado;  
}

public boolean verificarAriba(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarAriba(dato,posf+1,posc); 
        }
    }
    return resultado;
}

public boolean verificarAbajo(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarAbajo(dato,posf-1,posc); 
        }
    }
    return resultado;
}

public boolean verificarIzquierda(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarIzquierda(dato,posf,posc-1); 
        }
    }
    return resultado;
}

public boolean verificarDerecha(String dato,int posf,int posc){
    boolean resultado=false;
    if (posf>=0 && posf<f && posc>=0 && posc<c) {
        if (m[posf][posc] == dato) {
            return true;
        }else{
           resultado=verificarDerecha(dato,posf,posc+1); 
        }
    }
    return resultado;
}

public void cargarReina(String reina){
    do {
       
        iniciarTablero(0);
        int posf=(int) (Math.random()*(f-0)+0);
        int posc=(int) (Math.random()*(c-0)+0);
        for (int i = posf; i >=0; i--) {
            int inicioC=0;
            if (posf==i) {
                
                inicioC=posc;
            }else{
               
                inicioC=c-1;
            }
            for (int j = inicioC; j >=0; j--) {
                if(verificarDiaAriIzq(reina,i,j)==false &&
                verificarDiaAriDer(reina,i,j)==false &&
                verificarDiaAbaIzq(reina,i,j)==false &&
                verificarDiaAbaDer(reina,i,j)==false &&
                verificarAriba(reina,i,j)==false &&
                verificarAbajo(reina,i,j)==false &&
                verificarIzquierda(reina,i,j)==false &&
                verificarDerecha(reina,i,j)==false ){
                    
                    m[i][j]=reina;
                }

            }
        }
        
        for (int i = posf; i <f; i++) {
            int inicioC=0;
            if (posf==i) {
                inicioC=posc;
            }else{
                inicioC=0;
            }
            for (int j = inicioC; j <c; j++) {
                if(verificarDiaAriIzq(reina,i,j)==false &&
                verificarDiaAriDer(reina,i,j)==false &&
                verificarDiaAbaIzq(reina,i,j)==false &&
                verificarDiaAbaDer(reina,i,j)==false &&
                verificarAriba(reina,i,j)==false &&
                verificarAbajo(reina,i,j)==false &&
                verificarIzquierda(reina,i,j)==false &&
                verificarDerecha(reina,i,j)==false ){
                    m[i][j]=reina;
                }
            }
        }
    }
    while (CantidaReinas(reina) < 8);
}

public int CantidaReinas(String dato){
    int cantidad=0;
    for (int i = 0; i < f; i++) {
        for (int j = 0; j < c; j++) {
            if (dato == m[i][j]) {
                cantidad++; 
            }
        }
    }
    return cantidad;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
/*                                               PROYECTO                                               */
//////////////////////////////////////////////////////////////////////////////////////////////////////////

public void iniciarTablero1(int posf){
    
    if (posf<f) {       
        int posc=0;    
        while(posc<c) {   
            m[posf][posc]=null;
            posc++;         
        }
        //JOptionPane.showMessageDialog(null,"salio del bucle");
        //iniciarTablero(posf+1);
    }
  // JOptionPane.showMessageDialog(null,"fila ="+posf);
}
//public void cargarNombre{Vector vec,int n){
  //  cargarNombre(vec,n,0);
//}
public void cargarNombre(Vector vec,int n,int posf){
        if (n==4) {
         n=0;
         posf++;}
        if(posf!=12){
           if (n!=4) {
           int posc=(int) (Math.random()*(c-0)+0);
                if (m[posf][posc]==null) {
                    m[posf][posc]=vec.getNombre(n);
                    n++;
                    cargarNombre(vec,n,posf);
                 }else {   
                  cargarNombre(vec,n,posf);  
                 }
           }
        }
     
}


public void modificar(int fila,Vector vec,int n){
    iniciarTablero1(fila);
     if (n!=4) {
            int posc=(int) (Math.random()*(c-0)+0);    
            if(m[fila][posc]==null){
                m[fila][posc]=vec.getNombre(n);
                n++;
                modificar(fila,vec,n);
                }else{
                modificar(fila,vec,n);
                 }
     }
     for (int i = 0; i < c; i++) {
         if ("elvis".equals(m[fila][i]) ){
             if (verificarIzq("ayelen",fila,i)==false && verificarDer("ayelen",fila,i)==false) {
                   // JOptionPane.showMessageDialog(null,"no choca en ningugo");
                  
                }else{
                    modificar(i,vec,0);
                }
         }
    }
}

public void verificando(Vector vec) {
 
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if ("elvis".equals(m[i][j])) {
              //  JOptionPane.showMessageDialog(null,"encontro ♠"+i+j);
                if (verificarIzq("ayelen",i,j)==false && verificarDer("ayelen",i,j)==false) {
                   // JOptionPane.showMessageDialog(null,"no choca en ningugo");
                  
                }else{
                    modificar(i,vec,0);
                }
                 
            }
        }
    }
}


public boolean verificarIzq(String nombre,int pfil,int pcol){
    
    boolean res=false;
    if (pfil>=0 && pfil<f && pcol>=0 && pcol<c) {
        if (pcol==0) {
            pcol=1;
        }
    if (m[pfil][pcol-1].equals(nombre)) {
        // JOptionPane.showMessageDialog(null,"encontro a la izq♦");
       return true; 
    }
    //JOptionPane.showMessageDialog(null," no encontro a  la izq ♦");
    }
    return res;
}
public boolean verificarDer(String nombre,int pfil,int pcol){
    
    boolean res=false;
    if (pfil>=0 && pfil<f && pcol>=0 && pcol<c) {
        if (pcol==4){
            pcol=5;
        }
    if (m[pfil][pcol+1].equals(nombre)) {
       // JOptionPane.showMessageDialog(null,"encontro a la der ♦");
       return true; 
    }
   //JOptionPane.showMessageDialog(null,"no encontro a la der ♦");
}
     return res;
}
public void xxx(){    
    for (int i = 0; i < 4; i++) {
       int posf=(int) (Math.random()*(f-0)+0);
       int posc=(int) (Math.random()*(c-0)+0);
       m[posf][posc]="▲"; 
    }
    
    
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////
/*                                                 FIN                                                  */
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
      Formulario v1=new Formulario();
      v1.setVisible(true);
      
      
    }

}

