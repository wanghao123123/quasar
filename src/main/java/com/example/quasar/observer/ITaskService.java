package com.example.quasar.observer;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public interface ITaskService {
    void addClient(TaskConfig client);		//添加观察者
    boolean deleteClient(TaskConfig client);//删除观察者
    void notifyClients();				//通知
    void updateWeather(TaskInfo info);//主题内容更新
}
