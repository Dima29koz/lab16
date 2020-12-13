package tasks;

public class ListNode {
    Item item;
    ListNode next;
    ListNode previous;

    public ListNode(Item item, ListNode next, ListNode previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }

    public ListNode(Item item) {
        this.item = item;
        this.next = null;
        this.previous = null;
    }
}