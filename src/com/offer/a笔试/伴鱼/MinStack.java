package com.offer.a笔试.伴鱼;

import java.util.Stack;

class MinStack{
    Stack<Integer> stack;
    Stack<Integer> stackMin;


    public MinStack(){
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num){
        stack.push(num);
        if(stackMin.isEmpty()){
            stackMin.push(num);
        } else{
            int temp = stackMin.peek();
            if(num < temp){
                stackMin.push(num);
            }else{
                stackMin.push(temp);
            }
        }

    }

    public int pop(){
        if(stack.isEmpty()){
            return -1;
        }else{
            stackMin.pop();
            return stack.pop();
        }
    }

    public int getMin(){
        if(stackMin.isEmpty()){
            return -1;
        }else{
            return stackMin.peek();
        }
    }
}

