package algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序实现：
 * - 三数取中选择枢轴，降低最坏情况概率
 * - Hoare 分区法，交换次数较少
 * - 尾递归优化：每次先排序较小的区间，较大的区间用循环继续，减少递归深度
 *
 * 使用方法：
 *   int[] arr = {5, 2, 9, 1, 5, 6};
 *   QuickSort.sort(arr);
 *   System.out.println(Arrays.toString(arr));
 */

public class QuickSort2 {

    // 对外入口
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // 主过程：尾递归优化版本
    private static void quickSort(int[] a, int left, int right) {
        while (left < right) {
            // 选择枢轴并做 Hoare 分区，返回分区后的边界位置
            int pivotIndex = medianOfThree(a, left, right);
            int pivot = a[pivotIndex];
            int i = left - 1;
            int j = right + 1;

            while (true) {
                // 从左向右找 >= pivot 的位置前一个
                do { i++; } while (a[i] < pivot);
                // 从右向左找 <= pivot 的位置后一个
                do { j--; } while (a[j] > pivot);

                if (i >= j) {
                    // j 是左侧区间的右边界
                    break;
                }
                swap(a, i, j);
            }

            // 分成两段 [left..j] 和 [j+1..right]
            // 尾递归优化：先处理较小段，较大段用循环继续
            int leftSize = j - left + 1;
            int rightSize = right - (j + 1) + 1;

            if (leftSize < rightSize) {
                // 递归较小的左段
                quickSort(a, left, j);
                // 迭代处理右段
                left = j + 1;
            } else {
                // 递归较小的右段
                quickSort(a, j + 1, right);
                // 迭代处理左段
                right = j;
            }
        }
    }

    // 三数取中：从 left, mid, right 三个位置选中位数，返回其索引
    private static int medianOfThree(int[] a, int left, int right) {
        int mid = left + ((right - left) >>> 1);
        // 通过比较把三者排成 a[left] <= a[mid] <= a[right]
        if (a[left] > a[mid]) swap(a, left, mid);
        if (a[mid] > a[right]) swap(a, mid, right);
        if (a[left] > a[mid]) swap(a, left, mid);
        // 现在 a[mid] 为三数中位数，返回 mid 作为枢轴位置
        return mid;
    }

    // 交换工具
    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 简单测试
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        QuickSort2.sort(arr1);
        System.out.println("示例1: " + Arrays.toString(arr1));

        int[] arr2 = {3, -1, 0, 7, 2, 2, 2, 8, 1};
        QuickSort2.sort(arr2);
        System.out.println("示例2: " + Arrays.toString(arr2));

        // 较大随机数组测试
        int n = 20;
        int[] arr3 = new int[n];
        Random rnd = new Random(42);
        for (int i = 0; i < n; i++) arr3[i] = rnd.nextInt(100);
        System.out.println("原始: " + Arrays.toString(arr3));
        QuickSort2.sort(arr3);
        System.out.println("排序: " + Arrays.toString(arr3));
    }


}
