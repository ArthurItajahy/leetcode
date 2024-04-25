class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Reverse linked lists
        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);

        // Transform into string
        String numberl1 = listToString(reversedL1);
        String numberl2 = listToString(reversedL2);

        // Perform Addition
        String sum = addString(numberl1, numberl2);


        // Turn sum into list
        ListNode sumList = stringToList(sum);

        // Reverse the sum list
        ListNode result = reverseList(sumList);

        return result;
    }

    public static ListNode stringToList(String number) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        String strNumber = String.valueOf(number);
        for (int i = 0; i < strNumber.length(); i++) {
            current.next = new ListNode(Character.getNumericValue(strNumber.charAt(i)));
            current = current.next;
        }
        return dummyHead.next;
    }


    public static String addString(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            int digit1 = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int digit2 = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }
        return sb.toString();
    }
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Example 1:
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        solution.printList(result1);
        // Output: 7 0 8

        // Example 2:
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        solution.printList(result2);
        // Output: 0

        // Example 3:
        // Output: 8 9 9 9 0 0 0 1
    }
}
