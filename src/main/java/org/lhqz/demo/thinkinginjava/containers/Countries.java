package org.lhqz.demo.thinkinginjava.containers;

import java.util.*;

import static org.lhqz.demo.tools.Print.*;

/**
 * 享元：可以在普通的解决方案需要过多的对象，或者产生普通对象太占用空间时使用享元。
 * 享元模式使得对象的一部分可以被具体化，因此，与对象中的所有事物都包含在对象内部不同，
 * 我们可以在更加高效的外部表中查找对象的一部分或整体(或者通过某些其他节省空间的计算来产生对象的一部分或整体)
 */
public class Countries {

    public static final String[][] DATA = {
            {"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"},
            {"BENIN", "Porto-Novo"}, {"BOTSWANA", "Gaberone"},
            {"BURKINA FASO", "Ouagadougou"},
            {"BURUNDI", "Bujumbura"},
            {"CAMEROON", "Yaounde"}, {"CAPE VERDE", "Praia"},
            {"CENTRAL AFRICAN REPUBLIC", "Bangui"},
            {"CHAD", "N'djamena"},
    };

    private static class FlyweightMap extends AbstractMap<String, String> {

        /**
         * 这里使用的是享元：每个Map.Entry对象都只存储了它的索引，而不是实际的键和值。
         */
        private static class Entry implements Map.Entry<String, String> {

            int index;

            Entry(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            EntrySet(int size) {
                if (size < 0) {
                    this.size = 0;
                } else if (size > DATA.length) {
                    this.size = DATA.length;
                } else {
                    this.size = size;
                }
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {

                private Entry entry = new Entry(-1);


                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return this.size;
            }
        }

        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

    }

    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {

        println(capitals(10));
        println(names(10));
        println(new HashMap<>(capitals(3)));
        println(new LinkedHashMap<>(capitals(3)));
        println(new TreeMap<>(capitals(3)));
        println(new Hashtable<>(capitals(3)));
        println(new HashSet<>(names(6)));
        println(new LinkedHashSet<>(names(6)));
        println(new TreeSet<>(names(6)));
        println(new ArrayList<>(names(6)));
        println(new LinkedList<>(names(6)));

    }

}