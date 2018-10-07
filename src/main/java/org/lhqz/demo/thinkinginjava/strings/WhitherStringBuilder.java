package org.lhqz.demo.thinkinginjava.strings;

/**
 * 编译器自动引入了StringBuilder类，虽然我们在源代码中并没有使用StringBuilder类，
 * 但是编译器却自作主张地使用了它，因为他更高效。
 * <p>
 * 也许会觉得可以随意使用String对象，反正编译器会为你自动地优化性能。
 * 可是在这之前，让我们更深入地看看编译器能为我们优化到什么程度。
 * <p>
 * 显示地创建StringBuilder还允许你预先为其指定大小。如果你已经知道最终的字符串大概有多长，
 * 那预先指定StringBuilder的大小可以避免多次重新分配缓冲。
 * <p>
 * 如果字符串操作比较简单，那就可以信赖编译器，它会为你合理地构造最终的字符串结果。
 * 但是，如果你要使用循环，那么最好自己创建StringBuilder对象，用它来构造最终结果。
 */
public class WhitherStringBuilder {

    public String imlicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
        }
        return result.toString();
    }

}
