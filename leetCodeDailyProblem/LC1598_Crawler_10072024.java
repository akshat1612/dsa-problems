package leetCodeDailyProblem;

/**
 * The Leetcode file system keeps a log each time some user performs a change folder operation.
 * <p>
 * The operations are described below:
 * <p>
 * "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
 * "./" : Remain in the same folder.
 * "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 * <p>
 * The file system starts in the main folder, then the operations in logs are performed.
 * <p>
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 */
public class LC1598_Crawler_10072024 {
    public static void main(String[] args) {
        String[] logs = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(minOperations(logs));
    }

    static int minOperations(String[] logs) {
        int count = 0;
        for (String operation : logs) {
            if (operation.equals("../")) {
                if (count > 0) {
                    count--;
                }
            } else if (!operation.equals("./")) {
                count++;
            }
        }
        return count;
    }
}
