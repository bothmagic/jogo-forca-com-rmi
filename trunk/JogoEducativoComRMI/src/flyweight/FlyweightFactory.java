package flyweight;

import java.util.ArrayList;
import java.util.Iterator;

public final class FlyweightFactory {
    private ArrayList tdsAsClassesAddDinamico = new ArrayList();
    private String nomeClasseDesejada;

    
    public Object getFlyweight(Object classeDesejada){
        this.nomeClasseDesejada = classeDesejada.getClass().getSimpleName();
       Object object = null;
        for (Iterator it = tdsAsClassesAddDinamico.iterator(); it.hasNext();) {
            object = it.next();
            if(object.getClass().getSimpleName().equalsIgnoreCase(this.nomeClasseDesejada)){
               break;
            }else{
                object = null;
            }
        }
        if(object == null){
            tdsAsClassesAddDinamico.add(classeDesejada);
            object = classeDesejada;
//            try {
//                object = classeDesejada.getClass().newInstance();
//                tdsAsClassesAddDinamico.add(object);
//            } catch (InstantiationException ex) {
//                ex.printStackTrace();
//            } catch (IllegalAccessException ex) {
//                ex.printStackTrace();
//            }
        }
        return object;
    }
}
