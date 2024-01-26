package question3;

import java.util.Set;
import java.util.HashSet;

/**
 * hashSet n'est pas comparable 
 */
public class HashSetFactory<E> implements Factory<Set<E>> {
    public Set<E> create() {
        return new HashSet<E>();
    }
}