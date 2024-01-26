package question3;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetFactory<E extends Comparable<E>> implements Factory<Set<E>> {
    public Set<E> create() {
        return new TreeSet<E>();
    }
}
