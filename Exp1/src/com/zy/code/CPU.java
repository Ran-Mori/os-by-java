package com.zy.code;

import java.util.LinkedList;

public class CPU {
    private LinkedList<Process> processes=new LinkedList<Process>();
    private Process currentProcess;

    public void addProcess(Process process){
        int index=0;
        if(this.processes.size()==0)
            this.processes.add(process);
        else {
            for (Process foreeachProcess : processes) {
                if(process.getPriority()<foreeachProcess.getPriority())
                    index++;
            }
            this.processes.add(index,process);
        }
    }

    public void deletProcess(Process process){
        this.processes.remove(process);
    }

    public void showString(){
        for (int i=0;i<this.processes.size();i++)
            System.out.println(this.processes.get(i));
    }
    public void schedule(){
        if(this.processes.size()==0)
            System.out.println("CPU调度执行结束");
        else {
            currentProcess=this.processes.getFirst();
            if(currentProcess.isStatus()){
                currentProcess.decreaseRunningTime();
                currentProcess.decreasePriority();
            }
            if (currentProcess.isStatus()){
                this.deletProcess(currentProcess);
                this.addProcess(currentProcess);
            }else
                this.deletProcess(currentProcess);
        }
    }

    public LinkedList<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(LinkedList<Process> processes) {
        this.processes = processes;
    }
}
