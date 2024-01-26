package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        if (!table.contains(t)) {
            table.add(t);
            return true;
        }
        return false;
    }
    

    public Ensemble<T> union(Ensemble<? extends T> e) {
        Ensemble<T> result = new Ensemble<T>();
        result.addAll(this);
        result.addAll(e);
        return result;  
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble<T> result = new Ensemble<T>();
        for (T item : this) {
            if (e.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble<T> result = new Ensemble<T>();
        for (T item : this) {
            if (!e.contains(item)) {
                result.add(item);
            }
        }
        return result;  
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble<T> result = new Ensemble<T>();
        for (T item : this) {
            if (!e.contains(item)) {
                result.add(item);
            }
        }
        for (T item : e) {
            if (!this.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
}
