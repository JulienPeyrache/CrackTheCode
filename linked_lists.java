import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

public interface linked_lists {

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}

class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        if (this.head == null){
            this.head = end;
            return;
        }
        Node n = this.head;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void deleteNode(int d){
        Node n = this.head;
        if (n.data == d){
            this.head = n.next;
            return;
        }
        while (n.next != null){
            if (n.next.data == d){
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }

    void printList(){
        Node n = this.head;
        while (n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}


// Remove Dups: Write code to remove duplicates from an unsorted linked list.
// Path: linked_lists.java

static void removeDups(LinkedList list){
    Node n = list.head;
    HashSet<Integer> set = new HashSet<Integer>();
    Node prev = null;
    while (n != null){
        if (set.contains(n.data)){
            prev.next = n.next;
        } else {
            set.add(n.data);
            prev = n;
        }
        n = n.next;
    }
};

// Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
// Path: linked_lists.java

static int kthToLast(LinkedList list, int k){
    Node n = list.head;
    int length = 0;
    while (n != null){
        length++;
        n = n.next;
    }
    n = list.head;
    for (int i = 0; i < length - k; i++){
        n = n.next;
    }
    return n.data;
};

// Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
// Path: linked_lists.java

static void deleteMiddleNode(Node n){
    if (n == null || n.next == null) return;
    n.data = n.next.data;
    n.next = n.next.next;
};

//Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
// Path: linked_lists.java

static LinkedList partition(LinkedList list, int x){
    Node n = list.head;
    LinkedList left = new LinkedList();
    LinkedList right = new LinkedList();
    while (n != null){
        if (n.data < x){
            left.appendToTail(n.data);
        } else {
            right.appendToTail(n.data);
        }
        n = n.next;
    }
    n = left.head;
    while (n.next != null){
        n = n.next;
    }
    n.next = right.head;
    return left;
};

// Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
// Path: linked_lists.java

static LinkedList sumLists(LinkedList list1, LinkedList list2){
    Node n1 = list1.head;
    Node n2 = list2.head;
    LinkedList sum = new LinkedList();
    int carry = 0;
    while (n1 != null || n2 != null){
        int val1 = 0;
        int val2 = 0;
        if (n1 != null){
            val1 = n1.data;
            n1 = n1.next;
        }
        if (n2 != null){
            val2 = n2.data;
            n2 = n2.next;
        }
        int val = val1 + val2 + carry;
        carry = val / 10;
        sum.appendToTail(val % 10);
    }
    if (carry > 0){
        sum.appendToTail(carry);
    }
    return sum;
};

// Palindrome: Implement a function to check if a linked list is a palindrome.
// Path: linked_lists.java

static boolean isPalindrome(LinkedList list){
    Node n = list.head;
    int length = 0;
    while (n != null){
        length++;
        n = n.next;
    }
    n = list.head;
    int[] arr = new int[length];
    for (int i = 0; i < length; i++){
        arr[i] = n.data;
        n = n.next;
    }
    for (int i = 0; i < length / 2; i++){
        if (arr[i] != arr[length - i - 1]){
            return false;
        }
    }
    return true;
};

// Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
// Path: linked_lists.java

static Node intersection(LinkedList list1, LinkedList list2){
    Node n1 = list1.head;
    Node n2 = list2.head;
    int length1 = 0;
    int length2 = 0;
    while (n1 != null){
        length1++;
        n1 = n1.next;
    }
    while (n2 != null){
        length2++;
        n2 = n2.next;
    }
    n1 = list1.head;
    n2 = list2.head;
    if (length1 > length2){
        for (int i = 0; i < length1 - length2; i++){
            n1 = n1.next;
        }
    } else {
        for (int i = 0; i < length2 - length1; i++){
            n2 = n2.next;
        }
    }
    while (n1 != null){
        if (n1 == n2){
            return n1;
        }
        n1 = n1.next;
        n2 = n2.next;
    }
    return null;
};

// Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
// Path: linked_lists.java

static Node loopDetection(LinkedList list){
    Node n = list.head;
    HashSet<Node> set = new HashSet<Node>();
    while (n != null){
        if (set.contains(n)){
            return n;
        }
        set.add(n);
        n = n.next;
    }
    return null;
};

}


