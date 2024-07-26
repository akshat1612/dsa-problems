package leetCodeDailyProblem;

public class LC9_Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(124));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123454321));
        System.out.println(isPalindrome(012453));
    }
    static boolean isPalindrome(int x) {
        if( x == 0) return true;
        if(x < 0 || x % 10 == 0) {
            return false;
        }
        int num = 0;
        int temp = x;
        while(x > 0) {
            num = (num*10) + (x % 10);
            x = x / 10;
        }
        return num == temp;
    }
}
