/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Toloza XD
 */

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;

    public ArbolBB() {
        raiz = null;
    }
    
    public boolean agregar(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }
    
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }
    
    public int MaximoPar(){
        return MaximoPar(raiz);
    }
    private int MaximoPar(Nodo p){
        int maxValue=0;
        if (p==null)
        {
            //nada
        }else{
            if(p.getDato()%2==0 &&  p.getDato()> maxValue){
               maxValue=p.getDato();
            }
            if(p.getIzq()!=null){
                int maxParIzq=MaximoPar(p.getIzq());
                if (maxParIzq>maxValue)
                {
                    maxValue=maxParIzq;
                }
            }
            if(p.getDer()!=null){
                int maxParDer=MaximoPar(p.getDer());
                if (maxParDer>maxValue)
                {
                    maxValue=maxParDer;
                }
            }
            
        }
        return maxValue;
    }
    public int AlturaABB(){
        return AlturaABB(raiz);
    }
    
    private int AlturaABB(Nodo p){
        int a=0;
        int ahi=0;
        int ahd=0;
        
        if(p==null){
            a=0;
        }else{
            if(p.getIzq()==null && p.getDer()==null){
                a=1;
            }else{
                ahi=ahi+AlturaABB(p.getIzq());
                ahd=ahd+AlturaABB(p.getDer());
                if(ahi>ahd){
                    a=ahi+1;
                }else{
                    a=ahd+1;
                }
            }
        }
        return a;
    }
    
    public boolean EsABB(){
        return /*esArbolBinarioBusqueda(raiz);*/isBSTHelper(raiz);
    }
    private boolean EsABB(Nodo t){
        boolean es=true;
        if (t==null)
        {
            es=true;
        }else{
            if (t.getIzq()!=null && t.getIzq().getDato()>t.getDato())
            {
                es=false;
            }
            if (t.getDer()!=null && t.getDer().getDato()<t.getDato())
            {
                es=false;
            }
            if (EsABB(t.getIzq())==true && EsABB(t.getDer())==true)
            {
                es=true;
            }else{
                es=false;
            }
        }
        return es;
    }
    private static boolean isBSTHelper(Nodo t) {
        boolean a=true;
    if (t == null) {
            return true;
            //a=true;
        }

        if (t.getIzq() != null && t.getIzq().getDato() > t.getDato()) {
            return false;
            //a=false;
        }

        if (t.getDer() != null && t.getDer().getDato() < t.getDato()) {
            return false;
            //a=false;
        }

        if (!isBSTHelper(t.getIzq()) || !isBSTHelper(t.getDer())) {
            JOptionPane.showMessageDialog(null, "Entro ala recursividad ", "----", 0);
            return false;
            //a=false;
        }

        return true;
      }
    public boolean esArbolBinarioBusqueda(Nodo raiz) {
        return (raiz == null) ||
                ((raiz.getIzq() == null || raiz.getIzq().getDato() <= raiz.getDato()) &&
                (raiz.getDer() == null || raiz.getDer().getDato() >= raiz.getDato()) &&
                esArbolBinarioBusqueda(raiz.getIzq()) &&
                esArbolBinarioBusqueda(raiz.getDer()));
    }
    public void Modificar(int dato){
        raiz=Modificar(raiz,dato);
    }
    
    private Nodo Modificar(Nodo p,int dato){
        if (p==null)
        {
            //nada
        }else{
            Nodo t=new Nodo(0,null,null);
            t=p;
            t.getIzq().getIzq().setDato(dato);
            p=t;
        }
        return p;
    }
    
    public void eliminarHoja(){
        raiz=EliminarHoja(raiz);
    }
    private Nodo EliminarHoja(Nodo t){
        Nodo p=new Nodo(0,null,null);
        p=t;
        if (t==null)
        {
            return p;
        }else{
            if(p.getDer()==null && p.getIzq()==null){
                return null;
            }
            if (p.getIzq()!=null)
            {
                p.setIzq(EliminarHoja(p.getIzq()));
                t=p;
            }
            if (p.getDer()!=null)
            {
                p.setDer(EliminarHoja(p.getDer()));
                t=p;
            }
            
        }
        return t;
    }
    public int SumRootToLeafNumbers(){
        return dfs(raiz, 0);//SumRootToLeafNumbers(raiz,1);
    }
    //pendiente-------------en el multiplicador 
    private int SumRootToLeafNumbers(Nodo p,int inc){
        int sum=0;
        int pp=1;
        int c=0;
        if (p==null)
        {
            sum=0;
        }else{
            if (p.getIzq()==null && p.getDer()==null)
            {
                return p.getDato();
            }else{
                if(p.getIzq()!=null){
                    
                    JOptionPane.showMessageDialog(null, "SumRootToLeafNumbers "+c+"-"+sum, "SumRootToLeafNumbers", 0);
                    sum=sum+p.getDato()*inc+SumRootToLeafNumbers(p.getIzq(),inc*10);
                    
                    
                }
                /*if(p.getDer()!=null){
                    c=p.getDato()*10;
                    sum=sum+SumRootToLeafNumbers(p.getDer())+c;
                }*/
            }
        }
        return sum;
    }
    public int sumNumbers() {
        return dfs(raiz, 0);
    }
    
    private int dfs(Nodo node, int num) {
        if (node == null) {
            return 0;
        }
        
        num = num * 10 + node.getDato();
        
        if (node.getIzq() == null && node.getDer() == null) {
            return num;
        }
        
        return dfs(node.getIzq(), num) + dfs(node.getDer(), num);
    }

    public int ConIncompletos(){
        return ConIncompletos(raiz);
    }
    
    private int ConIncompletos(Nodo t){
        int cont=0;
        if(t==null){
            cont=0;
        }else{
            if(t.getIzq()==null && t.getDer()==null){
                cont=0;
            }else{
                if(t.getIzq()!=null && t.getDer()==null){
                    cont=cont+1;
                    cont=cont+ConIncompletos(t.getIzq());
                }
                if(t.getDer()!=null && t.getIzq()==null){
                    cont=cont+1;
                    cont=cont+ConIncompletos(t.getDer());
                }
                if(t.getIzq()!=null && t.getDer()!=null){
                    cont=cont+ConIncompletos(t.getIzq());
                    cont=cont+ConIncompletos(t.getDer());
                }
                    
            }
            
        }
        return cont;
    }
    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
