package com.company.Design.Chain;

import java.util.ArrayList;
import java.util.List;

public class ChainManager implements IBaseTask{
    private List<IBaseTask> iBaseTasks = new ArrayList<>();

    public void addTask(IBaseTask iBaseTask){
        iBaseTasks.add(iBaseTask);
    }

    private int index = 0;

    @Override
    public void doAction(String isTask, IBaseTask iBaseTask) {
        if(iBaseTasks.isEmpty()){ }
        if(index > iBaseTasks.size()){
            return;
        }
        IBaseTask bt = iBaseTasks.get(index);
        index++;
        bt.doAction(isTask, iBaseTask);
    }
}
