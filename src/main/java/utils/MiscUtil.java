package utils;

/**
 * @author arloz
 * @version $Id: MiscUtil.java, v 0.1 2018/09/23 下午5:46 arloz Exp $$
 */
public class MiscUtil {
    public static <T> boolean isEmpty(T[] values) {
        return values == null || values.length <= 0;
    }

    public static <T> void log(T[] values) {
        log(null, values);
    }

    public static <T> void log(String msg, T[] values) {
        if (isEmpty(values)) {
            System.out.println(msg == null ? "" : msg);
            return;
        }

        StringBuffer sb = new StringBuffer(msg == null ? "" : msg);
        sb.append(":");
        for (T value : values) {
            sb.append(value).append(",");
        }

        System.out.println(sb.toString());
    }

}
