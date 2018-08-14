package com.zhangyl.boqian;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //进
    public void push(int num) {
        stack1.push(num);
    }

    //出
    public int pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("the queue is empty!");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

