package com.zy.code;

public class Process {
    private String name;
    private int runningTime;
    private int priority;
    private boolean status=true;

    public Process() {
    }

    public Process(String name, int runningTime, int priority) {
        this.name = name;
        this.runningTime = runningTime;
        this.priority = priority;
    }

    public void decreaseRunningTime(){
        runningTime--;
        if(this.runningTime==0)
            this.status=false;
    }

    public void decreasePriority(){
        if(this.priority>0)
            this.priority--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", runningTime=" + runningTime +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }

    public void printString(){
        System.out.println(this.toString());
    }
}
