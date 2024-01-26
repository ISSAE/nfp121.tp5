package question2;
import java.util.Stack;


public class CareTaker {
    private Stack<ListMemento> mementos = new Stack<>();

    public void addMemento(ListMemento memento) {
        mementos.push(memento);
    }

    public ListMemento getMemento() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}
