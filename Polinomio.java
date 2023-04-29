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
        Iterator<Monomio> it= c.iterator(); //xq es iterador de E? lo cambie a Monomio
        maxExponent=0; //
        for(Monomio mono : c){
            Monomio newmono;
            lista.add(new Monomio(mono));
            if(mono.getExponente()>maxExponent){ //si el exponente del monomio es más grande que el de max entonces ahota ese exponente es el max
                maxExponent=mono.getExponente(); 
            }
        }
    }

    public Polinomio simplifica(Collection<Monomio> c){
        Iterator<E> it=c.iterator();
        for(Monomio mono : c){ //Vamos a ver si la colección tiene a monomios con exponentes iguales
            if(mono.getExponente()==it.next().getExponente()){ //si el exponente es igual que al exponente del siguiente monomio entonces se suman los coeficientes
                Monomio suma= new Monomio(mono.getCoeficiente()+it.next().getCoeficiente(), mono.getExponente());
            }
            Polinomio simplificado= new Polinomio(c);
            return simplificado; //se regresa un polinomio nuevo con la colección de monomios pero (según yo con cada monomio de distintos exponentes, es decir, simplificada XD);
        }
        return null;
    }

    public Polinomio ordena(Polinomio polinomio){//Suponiendo que ya esta simplificado
        LinkedList listaNueva= new LinkedList(); //lista con nulls 
        Iterator it= new iterator(); //Se itera sobre la lista con nulls
        while(listaNueva.next()==null){ //no sé cuando usar lista.(algo) y cuando it.(algo)
            listaNueva.remove(); //borra los nulls
            listaNueva.add(listas.next()); //Nambre, ni idea de como agregar a mi lista listaNueva los monomios de mayor exp a menor exp, help
        }
        Polinomio ordenado= new Polinomio(listaNueva); //Creamos un nuevo Polinomio ordenado 
        return ordenado;
    }

    public Polinomio producto(){
        return null;
    }

    public Polinomio suma(){
        return null;
    }

    @Override
    public String toString(){
        return null;
    }

}