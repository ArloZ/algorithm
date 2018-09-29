package sort;

import utils.MiscUtil;

/**
 * 二分插入排序
 *
 * @author arloz
 * @version $Id: BinaryInsertionSort.java, v 0.1 2018/09/29 下午5:11 arloz Exp $$
 */
public class BinaryInsertionSort {
    private static void sort(Integer[] a) {
        if (MiscUtil.isEmpty(a)) {
            return;
        }

        // 从第2个元素开始，依次向前插入
        for (int i = 1; i < a.length; i++) {
            Integer key = a[i];

            // 使用二分法查找需要插入的元素位置（与普通插入排序有差异的点）
            int left = 0;
            int right = i;
            while (left < right) {
                int middle = (left + right) >>> 1;
                if (key < a[middle]) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }

            // 将Key需要插入的位置的所有元素向后移动一位，并插入key
            int n = i - left;
            switch (n) {
                // 元素小于等于2个，则直接通过赋值操作
                case 2:
                    a[left + 2] = a[left + 1];
                case 1:
                    a[left + 1] = a[left];
                    break;
                default:
                    System.arraycopy(a, left, a, left + 1, n);
            }
            a[left] = key;
        }
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{12, 2, 31, 4, 15, 5, 6,};
        MiscUtil.log("before sort", a);

        sort(a);
        MiscUtil.log("after sort", a);
    }
}
