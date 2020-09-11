package com.offer.Design.Chain;

public class Task1 implements IBaseTask{
    @Override
    public void doAction(String isTask, IBaseTask iBaseTask) {
        if("no".equals(isTask)){
            System.out.println("拦截器1");
        }else {
            iBaseTask.doAction(isTask, iBaseTask);
        }
    }
}
