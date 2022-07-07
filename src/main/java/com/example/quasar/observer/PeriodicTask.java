package com.example.quasar.observer;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public class PeriodicTask implements TaskConfig{
    private static String name = "七日任务";
    private TaskInfo taskInfo;

    @Override
    public void getWeather(TaskInfo info) {
        this.taskInfo=info;
        dealMsg();

    }
    private void dealMsg(){
        System.out.println(name + "收到最新天气：time="+taskInfo.getTime()+"msg="+taskInfo.getWeather()+"。马上开始推送消息...");
    }
}
