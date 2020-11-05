import java.util.ArrayList;
import java.util.List;
/*
simple stack class that removes the last value and pushes the first value in the arraylist
 */
public class stack<I extends Number> {
    private List<Integer> list = new ArrayList<>();
public int pop() {
    return list.remove(list.size() -1);
}

public void push (int value){
    list.add(value);
}
/*
has items just returns true if it has items or false if it doesnt
 */
public boolean hasItems(){
    return !list.isEmpty();
}
/*
this class just returns the reverse of the default stack
 */
public stack reversestack(){
    stack reverse = new stack();
    for (int i =list.size()-1;i >= 0;i--){
        reverse.push(list.get(i));
    }
    return reverse;
}
}
