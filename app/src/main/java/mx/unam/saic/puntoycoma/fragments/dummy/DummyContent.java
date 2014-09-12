package mx.unam.saic.puntoycoma.fragments.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Item 1"));
        addItem(new DummyItem("2", "Item 2"));
        addItem(new DummyItem("3", "Item 3"));
        addItem(new DummyItem("1", "Item 11"));
        addItem(new DummyItem("2", "Item 21"));
        addItem(new DummyItem("3", "Item 31"));
        addItem(new DummyItem("1", "Item 12"));
        addItem(new DummyItem("2", "Item 23"));
        addItem(new DummyItem("3", "Item 34"));
        addItem(new DummyItem("1", "Item 15"));
        addItem(new DummyItem("2", "Item 26"));
        addItem(new DummyItem("3", "Item 37"));
        addItem(new DummyItem("1", "Item 18"));
        addItem(new DummyItem("2", "Item 29"));
        addItem(new DummyItem("3", "Item 32"));
        addItem(new DummyItem("1", "Item 13"));
        addItem(new DummyItem("2", "Item 25"));
        addItem(new DummyItem("3", "Item 37"));
        addItem(new DummyItem("1", "Item 13"));
        addItem(new DummyItem("2", "Item 22"));
        addItem(new DummyItem("3", "Item 32"));
        addItem(new DummyItem("1", "Item 1"));
        addItem(new DummyItem("2", "Item 22"));
        addItem(new DummyItem("3", "Item 31"));
        addItem(new DummyItem("1", "Item 11"));
        addItem(new DummyItem("2", "Item 12"));
        addItem(new DummyItem("3", "Item 13"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
