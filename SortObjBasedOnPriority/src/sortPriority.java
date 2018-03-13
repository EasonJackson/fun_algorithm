import java.util.List;

/**
 * Created by easonjackson on 3/12/18.
 */
public class sortPriority {

    public static void sortByPriority(List<Thing> thingList) {
        if (thingList.size() == 0) {
            return;
        }

        int anchor = 0;
        for (int prio = 0; prio < 4; prio++) {
            int scanner = anchor;
            for (; scanner < thingList.size(); scanner++) {
                int curr = thingList.get(scanner).getPriority();
                if (curr == prio) {
                    swap(thingList, anchor, scanner);
                }
            }
        }

        for (Thing thing : thingList) {
            System.out.print(thing.getPriority() + " ");
        }
    }

    private static void swap(List<Thing> thingList, int src, int tar) {
        Thing temp = thingList.get(src);
        thingList.set(src, thingList.get(tar));
        thingList.set(tar, temp);
    }
}
