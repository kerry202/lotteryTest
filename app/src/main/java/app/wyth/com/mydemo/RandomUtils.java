package app.wyth.com.mydemo;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author yangbo
 *  @qq	903023560
 */

public class RandomUtils {

   static ArrayList<String> random = new ArrayList<>();
   static ArrayList<String> random2 = new ArrayList<>();

    public static ArrayList<String> creatRandom() {
        random.clear();

        int number = 36;

        List arr = new ArrayList();
        for (int i = 0; i < 36 ; i++)
            arr.add(i + 1);

        for (int j = 0; j < 6; j++){
            int index = (int) (Math.random() * number);
            int i = (int) arr.get(index);
            String s = i + "";
            random.add(s);
            arr.remove(index);
            number--;
        }

        return random;
    }

    public static ArrayList<String> creatRandom2() {
        random2.clear();
        int number = 16;

        List arr = new ArrayList();
        for (int i = 0; i < 16 ; i++)
            arr.add(i + 1);

        for (int j = 0; j < 1; j++){

            int index = (int) (Math.random() * number);
            int i = (int) arr.get(index);
            String s = i + "";
            random2.add(s);
            arr.remove(index);
            number--;
        }

        return random2;
    }
}
