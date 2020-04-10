import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<?> l1 = new ArrayList<Object>() {
            {
                add(1);
                add(1);
                add(3);
                add(3);
                add(5);
                add(5);
                add(7);
                add(7);
                add(9);
                add(9);
                add(11);
                add(11);
            }
        };
        System.out.println("list: "+l1);
        removeEveryNthElement(l1, 3);
        System.out.println("list: "+l1);
    }

    public static void removeEveryNthElement(List<?> list, int n) {
        if (n <= 0) throw new IllegalArgumentException("n needs to ba positive number");
        else if (list.isEmpty()) throw new NullPointerException("the list must not be null");
        else {
            List<Object> l2 = new ArrayList<Object>();
            //iterator to go through the generic list
            Iterator iterator = list.iterator();
            //had to use a counter the nth position starts at 1 while an index start at 0
            int counter = 1;
            int index = 0;

            while (iterator.hasNext()) {
                if ((counter%n)!=0) l2.add(list.get(index));
                 counter++;
                 index++;
                 iterator.next();
            }

            //removed every element in the list
            list.clear();
            //had to cast list to a list of objects in order to get access to the methods available to the interface List (every object inherits from object)
            ((List<Object>) list).addAll(l2);
        }
    }
}
