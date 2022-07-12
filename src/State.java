import java.util.HashMap;
import java.util.Stack;

public class State {
    private char accept;
    private HashMap<Character, State> nextStates;

    public State(char accept){
        this.accept = accept;
        nextStates = new HashMap<>();
    }

    public void setAccept(char setValue){
         accept = setValue;
    }

    public void setNextState(State nextState,char x){
        nextStates.put(x,nextState);
    }

    public State nextState(char x){
        if (accept(x)){
            return nextStates.get(x);
        }else {
            return null;
        }
    }

    public boolean accept(char input){
        if (input==accept){
            return true;
        }else {
            return false;
        }
    }
}
