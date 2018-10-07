package org.lhqz.demo.thinkinginjava.strings;

/**
 * 内部使用Formatter对象实现。
 * 与其自己做这些事情，不如使用便捷的String.format()方法，何况这样的代码更加清晰易读。
 */
public class DatabaseException extends Exception {

    public DatabaseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d,q%d) %s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
