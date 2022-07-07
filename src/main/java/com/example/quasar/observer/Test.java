package com.example.quasar.observer;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public class Test {

    public static void main(String[] args) {
        //创建主题
        TaskServiceImpl instance = TaskServiceImpl.instance;
        //添加观察者
        instance.addClient(new PeriodicTask());
        instance.addClient(new WeekTask());
        //更新主题
        instance.updateWeather(new TaskInfo(System.currentTimeMillis(), "多云"));
        instance.updateWeather(new TaskInfo(System.currentTimeMillis()+1000*60*60*24, "多云转晴"));
        instance.updateWeather(new TaskInfo(System.currentTimeMillis()+1000*60*60*24*2, "晴"));
    }
}
