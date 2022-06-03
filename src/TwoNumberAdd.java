/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class TwoNumberAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode result = new ListNode(0);
       ListNode cur = result;
       int carry = 0;
       while(l1!= null || l2!=null){
           int sum = carry;
           if(l1!=null){
               sum += l1.val;
               l1 =l1.next;

           }
           if(l2!=null){
               sum += l2.val;
               l2 = l2.next;

           }

           carry = sum/10;
           cur.next = new ListNode(sum%10);
           cur = cur.next;

       }
       if(carry==1){
           cur.next = new ListNode(carry);

       }
       return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        TwoNumberAdd twoNumberAdd = new TwoNumberAdd();
        ListNode result = twoNumberAdd.addTwoNumbers(l1,l2);
        while(result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
