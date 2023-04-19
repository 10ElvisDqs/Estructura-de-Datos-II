/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_ed2;

import javax.swing.JOptionPane;

/**
 *
 * @author romina
 */
public class Vector {
    private int n;//cantidad de nombres en el vector
    private String[] v;//vector
    
    public Vector(){
        n=0;
        v=new String[100];
    }
    
    public Vector(int _n){
        n=_n;
        v=new String[n];
    }
    public void setNombre(int pos,String nombre){
        v[pos]=nombre;
    }
    public String getNombre(int pos){
        return v[pos];
    }
    public int getN(){
        return n;
    }
    public void AgregarNombre(String nombre){
            v[n]=nombre;
           //JOptionPane.showMessageDialog(null,"vector["+n+"]"+nombre);
            n++;
    
    }
    public int posNombre (String nombre){
	int posicion=-1;
	for (int i=0; i<n; i++){
		if (v[i]==nombre){
			posicion =i;
		}
	}
	return posicion;
    }

    public void eliminarNommbre(int pos){
 // recorrer vector
	for (int i=pos; i<n-1; i++){
		v[i]=v[i+1];
	}
	 n--;//disminuye en uno la dimencion
 }
    public void cargadoNombres(){
        v[0]="elvis";
        v[1]="maria";
        v[2]="ayelen";
        v[3]="lupe";
        
    } 
    
}
