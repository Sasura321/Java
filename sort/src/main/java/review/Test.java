package review;

/**
 * Auther： zsm
 * Date： 2019/8/24 18:42
 * Description：
 */
import java.util.*;

public class Test{
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        int n = 6;
        String str = "AaAAAA";

        int count = 0;
        int k = 0;
        int i = 0;

        while (i < n) {
            if (Character.isLowerCase(str.charAt(i)) && i < n) {
                count++;
                i++;
                continue;
            }
            while (Character.isUpperCase(str.charAt(i)) && i < n-1) {
                k++;
                i++;
            }
            if (k == 1)
                count += 2;
            if (k > 1)
                count += k+1;

            k = 0;
        }
        if (Character.isLowerCase(str.charAt(n-1))) {
            count++;
        }

        System.out.print(count);
    }
}
