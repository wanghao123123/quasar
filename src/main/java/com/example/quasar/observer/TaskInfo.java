package com.example.quasar.observer;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public class TaskInfo {
    /**
     * 任务消息内容
     */
    private long time;
    private String weather;
    public TaskInfo(long time,String weather){
        this.time = time;
        this.weather = weather;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    @Override
    public boolean equals(Object obj) {
        TaskInfo info = (TaskInfo) obj;
        return info.time==this.time&&info.weather.equals(this.weather);
    }
}
