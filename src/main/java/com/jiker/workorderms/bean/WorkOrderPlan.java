package com.jiker.workorderms.bean;

import java.util.Date;

public class WorkOrderPlan {
    int id;
    String number, name, content, cycle, role, executor, status;
    Date plan_start_time, plan_end_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPlan_start_time() {
        return plan_start_time;
    }

    public void setPlan_start_time(Date plan_start_time) {
        this.plan_start_time = plan_start_time;
    }

    public Date getPlan_end_time() {
        return plan_end_time;
    }

    public void setPlan_end_time(Date plan_end_time) {
        this.plan_end_time = plan_end_time;
    }
}
