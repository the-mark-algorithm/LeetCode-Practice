package medium.datatypes;

public class ListNode {
    private int val;
    private ListNode next;
    
    public ListNode() {}

    public ListNode(int val) { 
        this.val = val; 
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next; 
    }

    public ListNode getNext() {
        return this.next;
    }

    public int getVal() {
        return val;
    }
}
