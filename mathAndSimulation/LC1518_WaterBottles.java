package mathAndSimulation;

public class LC1518_WaterBottles {

    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    static int numWaterBottles(int numBottles, int numExchange) {

        int empty = numBottles;
        while(numBottles >= numExchange) {
            empty += (numBottles / numExchange);
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return empty;
    }
}


//https://leetcode.com/problems/water-bottles/description/?envType=daily-question&envId=2024-07-07