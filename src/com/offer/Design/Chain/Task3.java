package com.offer.Design.Chain;

public class Task3 implements IBaseTask{
    @Override
    public void doAction(String isTask, IBaseTask iBaseTask) {
        if("yes".equals(isTask)){
            System.out.println("拦截器3");
        }else {
            iBaseTask.doAction(isTask, iBaseTask);
        }
    }
}
