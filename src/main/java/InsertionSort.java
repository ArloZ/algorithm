import utils.MiscUtil;

/**
 * @author arloz
 * @version $Id: InsertionSort.java, v 0.1 2018/09/23 下午5:07 arloz Exp $$
 */
public class InsertionSort {
    private static void sort(Integer[] a) {
        if (MiscUtil.isEmpty(a)) {
            return;
        }

        // 从第二个元素开始遍历数组
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i;

            // 如果前一个元素大于当前元素key 则向后移动
            while (j > 0 && a[j - 1] > key) {
                a[j] = a[j - 1];
                j--;
            }

            // 将当前元素key插入的到合适的位置
            a[j] = key;
        }
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{12, 2, 31, 4, 15, 5, 6,};
        MiscUtil.log("before sort", a);

        sort(a);
        MiscUtil.log("after sort", a);
    }
}
