package com.company.Design.Chain;

public class Task2 implements IBaseTask{
    @Override
    public void doAction(String isTask, IBaseTask iBaseTask) {
        if("null".equals(isTask)){
            System.out.println("拦截器2");
        }else {
            iBaseTask.doAction(isTask, iBaseTask);
        }
    }
}
