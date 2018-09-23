package sort;

import utils.MiscUtil;

/**
 * 选择排序
 * - 时间复杂度：O(n^2)
 *
 * @author arloz
 * @version $Id: SelectionSort.java, v 0.1 2018/09/23 下午6:44 arloz Exp $$
 */
public class SelectionSort {
    private static void sort(Integer[] a) {
        if (MiscUtil.isEmpty(a)) {
            return;
        }

        // 选择剩余子数组的最小元素与当前元素进行交换
        for (int i = 0; i < a.length - 1; i++) {

            // 遍历选择数组中最小的元素
            int min = i + 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            // 将i位置的元素与最小的元素进行交换
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{12, 2, 31, 4, 15, 5, 6,};
        MiscUtil.log("before sort", a);

        sort(a);
        MiscUtil.log("after sort", a);
    }
}
