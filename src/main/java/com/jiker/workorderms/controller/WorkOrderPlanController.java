package com.jiker.workorderms.controller;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.service.WorkOrderPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WorkOrderPlanController {

    @Autowired
    WorkOrderPlanService workOrderPlanService;

    @RequestMapping("/createWorkOrderPlan")
    public String CreateWorkOrderPlan(@RequestBody WorkOrderPlan workOrderPlan) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resDate = sdf.format(new Date());
        int result = 0;   //用于接收SQL执行返回码

        //1、判断前端传过来的数据是否满足要求
        //需要处理字段Number、Name、Content、Cycle、Role、Executor
        if ((workOrderPlan.getNumber() == null)
                || (workOrderPlan.getName() == null)
                || (workOrderPlan.getContent() == null)
                || (workOrderPlan.getCycle() == null)
                || (workOrderPlan.getRole() == null)
                || (workOrderPlan.getExecutor() == null)) {
            return "参数不能为空";
        }
        if ((workOrderPlan.getPlan_start_time() == null) && (workOrderPlan.getPlan_end_time() == null) && (workOrderPlan.getPlan_start_time().getTime() >= workOrderPlan.getPlan_end_time().getTime())) {
            return "参数不能为空或开始时间大于等于结束时间";
        }

        workOrderPlan.setStatus("0");
        result = workOrderPlanService.createWorkOrderPlan(workOrderPlan);
        //根据返回结果值,完成工单计划成功或失败逻辑处理
        if (result == 0) {
            return resDate + ": 创建工单计划失败";
        } else {
            return resDate + ": 创建工单成功";
        }

    }

    @RequestMapping("/updateWorkOrderPlan")
    public String UpdateWorkOrderPlan(@RequestBody WorkOrderPlan workOrderPlan) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resDate = sdf.format(new Date());
        int result = 0;   //用于接收SQL执行返回码

        workOrderPlan.setStatus("0");
        result = workOrderPlanService.updateWorkOrderPlan(workOrderPlan);
        //根据返回结果值,完成工单计划成功或失败逻辑处理
        if (result == 0) {
            return resDate + ": 创建工单计划失败";
        } else {
            return resDate + ": 创建工单成功";
        }
    }

    @RequestMapping("/deleteWorkOrderPlan")
    public String DeleteWorkOrderPlan(@RequestBody WorkOrderPlan workOrderPlan) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resDate = sdf.format(new Date());
        int result = 0;   //用于接收SQL执行返回码

        workOrderPlan.setStatus("0");
        result = workOrderPlanService.deleteWorkOrderPlan(workOrderPlan);
        //根据返回结果值,完成工单计划成功或失败逻辑处理
        if (result == 0) {
            return resDate + ": 创建工单计划失败";
        } else {
            return resDate + ": 创建工单成功";
        }
    }
}
