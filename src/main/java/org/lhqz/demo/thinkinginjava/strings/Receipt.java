package org.lhqz.demo.thinkinginjava.strings;

import java.util.Formatter;

/**
 * %[argument_index$][flags][width][.precision]conversion
 * <p>
 * width:最小尺寸，通过在必要时添加空格。默认情况下，数据是右对齐的，可以使用"-"标志来改变对齐方向。
 * precision:最大尺寸，String:表示打印时输出字符的最大数量。
 * 浮点数:它表示小数部分要显示出来的位数(默认6位数)，如果小数位数过多则舍入，太少则在尾部补零。
 * 由于整数没有小数部分，所以无法应用于整数。
 */
public class Receipt {

    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.6);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }

}