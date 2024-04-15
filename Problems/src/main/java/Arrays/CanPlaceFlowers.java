package Arrays;

/*
You have a long flowerbed in which some of the plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's,
where 0 means empty and 1 means not empty, and an integer n,
return true if n new flowers can be planted in the flowerbed without
violating the no-adjacent-flowers rule and false otherwise.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

*/

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int a = 0;

        if (flowerbed.length <= 1) {
            if (flowerbed[0] != 1) {
                ++a;
            }
            if (a == n || a > n) {
                return true;
            }

            return false;
        }

        if (flowerbed[1] != 1 && flowerbed[0] != 1) {
            ++a;
            flowerbed[0] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1 && flowerbed[i] != 1) {
                ++a;
                flowerbed[i] = 1;
            }
        }

        if (flowerbed[flowerbed.length - 1] != 1 && flowerbed[flowerbed.length - 2] != 1) {
            ++a;
            flowerbed[flowerbed.length - 1] = 1;
        }

        if (a == n || a > n) {
            return true;
        }

        return false;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i += 2) {
            if (flowerbed[i] == 0)
                if (i == len - 1 || flowerbed[i] == flowerbed[i + 1]) {
                    n--;
                    continue;
                }
            i++;
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {0};
        int n1 = 1;
        int[] arr2 = {1, 0, 0, 0, 0, 1};
        int n2 = 1;
        int n3 = 2;

        System.out.println("true edge case: " + canPlaceFlowers2(arr1, n1));
        System.out.println("true example: " + canPlaceFlowers2(arr2, n2));
        System.out.println("false example: " + canPlaceFlowers2(arr2, n3));

    }
}
