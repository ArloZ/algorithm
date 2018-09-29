package sort;

import utils.MiscUtil;

/**
 * 归并排序
 *
 * @author arloz
 * @version $Id: MergeSort.java, v 0.1 2018/09/29 下午2:35 arloz Exp $$
 */
public class MergeSort {
    private static void sort(Integer[] a) {
        if (MiscUtil.isEmpty(a)) {
            return;
        }

        // 初始化创建临时数组，用于数组合并
        Integer[] tmp = new Integer[a.length];
        sort(a, 0, a.length - 1, tmp);
    }

    /**
     * 采用归并算法对数组进行排序
     *
     * @param a     待排序数组
     * @param start 数组下标开始值
     * @param end   数组下标结束值
     * @param tmp   临时数组，需要与a等长，用于排序时临时存储
     */
    private static void sort(Integer[] a, int start, int end, Integer[] tmp) {
        // 递归终止条件：数组仅有一个元素或无元素，则该元素保持当前位置不需要排序
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;

        // 左子数组排序
        sort(a, start, middle, tmp);

        // 右子数组排序
        sort(a, middle + 1, end, tmp);

        // 合并两个子数组
        merge(a, start, middle, end, tmp);
    }

    /**
     * 将两个数组[start,middle] / [middle+1, right] 进行有序的合并
     *
     * @param a      原始数组
     * @param start  数组下标开始位置
     * @param middle 数组下标中间分隔位置
     * @param end    数组下标结束位置
     * @param tmp    临时数组
     */
    private static void merge(Integer[] a, int start, int middle, int end, Integer[] tmp) {
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        while (i <= middle) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }

        // 将合并的子数组copy到原数组的指定位置
        System.arraycopy(tmp, 0, a, start, end - start + 1);
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{12, 2, 31, 4, 15, 5, 6,};
        MiscUtil.log("before sort", a);

        sort(a);
        MiscUtil.log("after sort", a);
    }
}
