package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * <p>
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 */
public class LC904_Fruits_Into_Baskets {
    public static void main(String[] args) {
        int[] trees = {1, 2, 1};
        int[] trees2 = {0, 1, 2, 2};
        int[] trees3 = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(trees));
        System.out.println(totalFruit(trees2));
        System.out.println(totalFruit(trees3));
    }

    static int totalFruit(int[] fruits) {
        int ans = 0, l = 0, r = 0;
        Map<Integer, Integer> m = new HashMap<>();

        while (r < fruits.length) {
            m.merge(fruits[r], 1, Integer::sum);
            if (m.size() > 2) {
                m.merge(fruits[l], -1, Integer::sum);
                if (m.get(fruits[l]) == 0) m.remove(fruits[l]);
                l++;
            }
            if (m.size() <= 2) {
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }
        return ans;
    }
}
