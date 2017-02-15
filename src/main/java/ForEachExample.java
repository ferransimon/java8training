import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sample forEach java8 features.
 */
public class ForEachExample {

    public static void main(String[] args){
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<1000; i++) myList.add(i);

        //Traversing in java7
        Iterator<Integer> iter = myList.iterator();
        while (iter.hasNext()){
            System.out.println("Value java7: "+iter.next());
        }

        //Traversion in java8
        myList.forEach( v -> System.out.println("Value java8: "+v));

    }
}
