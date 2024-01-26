package question2;

import java.util.List;
import java.util.LinkedList;

public class ListMemento {
    private List<String> state;

    public ListMemento(List<String> state) {
        this.state = new LinkedList<>(state);
    }

    public List<String> getState() {
        return state;
    }
}