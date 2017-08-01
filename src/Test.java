import java.util.ArrayList;

/**
 * Created by Admin on 2017-07-25.
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        for (Integer i : list) {
            if (i > 5) {
                System.out.println(i);
            }
        }

    }
}
