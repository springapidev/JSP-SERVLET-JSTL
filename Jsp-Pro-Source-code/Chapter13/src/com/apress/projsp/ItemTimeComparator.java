package com.apress.projsp;

import java.util.Comparator;


/**
 * @author dmj
 */
public class ItemTimeComparator implements Comparator {
    /**
     * @see java.util.Comparator#compare(Object, Object)
     */
    public int compare(Object o1, Object o2) {
        Item i1 = (Item) o1;
        Item i2 = (Item) o2;

        return i1.getTime().compareTo(i2.getTime());
    }
}
