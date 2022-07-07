package com.example.quasar.observer;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public enum TaskServiceImpl implements ITaskService{
    instance;
    private LinkedList<TaskInfo> TaskInfos = new LinkedList<TaskInfo>();
    private LinkedHashSet<TaskConfig> TaskConfigs = new LinkedHashSet<TaskConfig>();	//存放观察者


    @Override
    public void addClient(TaskConfig client) {
        TaskConfigs.add(client);
    }

    @Override
    public boolean deleteClient(TaskConfig client) {
        return TaskConfigs.remove(client);
    }

    @Override
    public void notifyClients() {
        Iterator<TaskConfig> iterator = TaskConfigs.iterator();
        while(iterator.hasNext()){
            iterator.next().getWeather(TaskInfos.peekFirst());
        }
    }

    //更新天气
    @Override
    public void updateWeather(TaskInfo info) {
        if(TaskInfos.size()>0)
            if(TaskInfos.peekFirst().equals(info)) return;
        TaskInfos.push(info);
        if(TaskConfigs.size()==0) return;
        notifyClients();
    }
}
