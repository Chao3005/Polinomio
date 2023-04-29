package ed.aplicaciones.algebra;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Iterator;

public class Polinomio{
    //Atributos
    private LinkedList<Monomio> lista;
    private int maxExponent; 

    //Constructores
    public Polinomio(Collection<Monomio> c){
        lista=new LinkedList();
        Iterator<E> it= c.iterator(); //xq es iterador de E? lo cambie a Monomio
        maxExponent=0; //
        for(Monomio mono : c){
            Monomio newmono;
            lista.add(new Monomio(mono));
            if(mono.getExponente()>maxExponent){ //si el exponente del monomio es más grande que el de max entonces ahota ese exponente es el max
                maxExponent=mono.getExponente(); 
            }
        }
    }

    public Polinomio simplifica(){
        Iterator it= new iterator(); //iterador que itera sobre la lista xd
        for(Monomio mono : lista){
            if(mono.getExponente()==it.next().getExponente()){ //si mono tiene el mismo exponente que el siguiente mono
                remove(); //quita a mono
                it.next().remove(); //quita al siguiente
                Monomio suma; new Monomio(mono.getCoeficiente()+ it.next().getCoeficiente(), mono.getExponente()); 
                lista.add(suma); //agrega a la lista un nuevo mono' con mismo exponente que mono pero con el coeficiente sumado con el siguiente
            }//Esta mal porque puede pasar que el coeficiente sea 0 y se muera, no sé cuando usar it.(algo) y cuando lista.(algo), y y y estoy truste
        }
        Polinomio polinomio= new Polinomio(lista); //Se crea polinomio nuevo con la lista de monomios ya sumados
        return polinomio;        
    }

    public Polinomio ordena(){//Suponiendo que ya esta simplificado
        LinkedList ordenada= new LinkedList(); //Se crea nueva lista ordenada
        Iterator it= iterator(); //iterador que va a iterar sobre esa lista
        for(int i=0; i<maxExponent+1; i++){ 
            ordenada.add(null); //va a rellenar maxExponent + 1 veces de null
        }
        while(it.hasNext()){ //mientras esa lista tenga siguiente
            if(it.next()==null){ //si es igual a null
                remove(); //va a quitar ese null 
                add(lista.next()); //va a adear el primer elemento de la lista que tiene a los monomios ordenados
            }
            //Esta mal xq no sé usar iteradores yy y y y y y no sé xq se llena de nulls y y y quiero llorar
        }
        Polinomio polinado= new Polinomio(ordenada);
        return polinado;
    }

    public Polinomio por(){
        return null;
    }

    public Polinomio mas(){
        return null;
    }

    @Override
    public String toString(){
        return null;
    }

}