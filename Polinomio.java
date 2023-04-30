package ed.aplicaciones.algebra;
import java.util.LinkedList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.Iterator;

public class Polinomio{
    //Atributos
    private LinkedList<Monomio> lista;
    private int maxExponent; 

    //Constructores
    public Polinomio(Collection<Monomio> c){
        lista=new LinkedList();
        maxExponent=0; 
        for(Monomio mono : c){
            Monomio newmono;
            lista.add(new Monomio(mono));
            if(mono.getExponente()>maxExponent){ //si el exponente del monomio es más grande que el de max entonces ahota ese exponente es el max
                maxExponent=mono.getExponente(); 
            }
        }
    }

    public Polinomio simplifica(){ 
        LinkedList<Monomio> newList= new LinkedList();
        newList.addAll(lista);
        for(int i=0;i<newList.size();i++){ //length: atributo de arreglo(es como tam, no se puede modificar), size: método que regresa número de elementos) (puede tener length 5 pero estar vacio y tener 0 size)
            for(int j=i+1; j<newList.size(); j++){
                Monomio monomio=newList.get(i);
                Monomio monomioDos= newList.get(j);
                if(monomio.getExponente()==monomioDos.getExponente()){
                    newList.remove(monomio);
                    newList.remove(monomioDos);
                    if(monomio.getCoeficiente()+ monomioDos.getCoeficiente()!=0){
                        Monomio nuevo= new Monomio(monomio.getCoeficiente()+monomioDos.getCoeficiente(), monomio.getExponente());
                        newList.add(i,nuevo);
                        j--;
                    }
                    else{
                        i--;
                        break;
                    }
                }
            }
        }
        Polinomio polinomio= new Polinomio(newList);
        return polinomio;
    }

    public Polinomio ordena(){//Suponiendo que ya esta simplificado (No sé como verificar que sí esta simplificada)
        LinkedList ordenada= new LinkedList(); //Se crea nueva lista ordenada
        for(int i=0; i<maxExponent+1; i++){ 
            ordenada.add(null); //va a rellenar maxExponent + 1 veces de null 
        }
        for(int i=0; i<lista.size(); i++){ //para cada monomio en lista
            ordenada.remove(maxExponent-lista.get(i).getExponente()); //se va a eliminar lo que este en el indice maxExponent-Exponente del monomio
            ordenada.add(maxExponent-lista.get(i).getExponente(), lista.get(i));//(Ej, si el maxExp es 5 y el exp del monomio es 5, entonces va a borrar el null del indice 0)
        } //y se va a agregar en el indice 0 el monomio con mayor exponente
        for(int j=0; j<maxExponent;j++){ //Para eliminar los nulls (si le pongo maxExpo+1 hay error en indice unu)
            if(ordenada.get(j)==null){ //si el indice j es null entonces lo borra
                ordenada.remove(j); //si no es null lo deja y pasa al siguiente indice
            }
        }
        Polinomio polinado= new Polinomio(ordenada); //no sé xq me da NullPointerException unu
        return polinado; //Estoy truste unu
    }

      /*for(int j=0;j<lista.size();j++){
            ordenada.remove(maxExponent-lista.get(j).getExponente());
            ordenada.add(maxExponent-lista.get(j).getExponente(), lista.get(j));
        }
        it.remove(null);
        while(it.hasNext()){
            if(it.next()==null){
                it.remove();
            }
        }*/

     /*LinkedList ordenada= new LinkedList(); //Se crea nueva lista ordenada
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
        return polinado;*/
    public Polinomio por(){
        return null;
    }

    public Polinomio mas(){
        return null;
    }

    @Override
    public String toString(){
        String cadena="";
        for(Monomio m : lista){
            cadena+=m.toString()+"\n";
        }
        return cadena;
    }

}