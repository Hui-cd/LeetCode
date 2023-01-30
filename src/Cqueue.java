import java.util.Stack;


/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )


queue 是先进先出的，stack 是先进后出的，所以我们可以把 stack1 当作队列的尾部，stack2 当作队列的头部
当stack2 为空的时候，我们把 stack1 的元素全部倒入 stack2 中，这样 stack2 就是先进先出的，
当 stack2 不为空的时候，直接从 stack2 中 pop 元素即可


e.g.
输入：
["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
[[],[3],[],[],[]]
输出：[null,null,3,-1,-1]



 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
         if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();

    }
}
