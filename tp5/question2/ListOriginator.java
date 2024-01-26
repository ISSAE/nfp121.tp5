package question2;
import java.util.List;


public class ListOriginator {
    private List<String> state;

    public void set(List<String> state) {
        this.state = state;
    }

    public ListMemento saveToMemento() {
        return new ListMemento(this.state);
    }

    public void restoreFromMemento(ListMemento memento) {
        this.state = memento.getState();
    }

    public List<String> getState() {
        return state;
    }
}
