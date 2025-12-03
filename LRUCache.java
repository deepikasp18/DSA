package LinkedList;
import java.util.*;

public class LRUCache {
    
    private int capacity;
    private Map<Integer, DoubleLinkedNode> cache;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DoubleLinkedNode(-1, -1);
        this.tail = new DoubleLinkedNode(-1, -1);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        DoubleLinkedNode node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.setValue(value);
            removeNode(node);
            addToHead(node);
        } else {
            if (cache.size() >= capacity) {
                DoubleLinkedNode lru = tail.getPrev();
                removeNode(lru);
                cache.remove(lru.getKey());
            }
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DoubleLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

