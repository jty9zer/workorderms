package com.jiker.workorderms.controller;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.service.CountWorkOrderPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountWorkOrderPlanController {
    @Autowired
    CountWorkOrderPlanService countWorkOrderPlanService;

    /**
     * 统计某个时间段内的工单计划数
     *
     * @param workOrderPlan
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanForTimeRegin")
    public List<WorkOrderPlan> queryWorkOrderPlanForTimeRegin(@RequestBody WorkOrderPlan workOrderPlan) {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        System.out.println(workOrderPlan.getPlan_start_time());
        System.out.println(workOrderPlan.getPlan_end_time());
        //1 校验时间参数是否为空，且开始时间不能大于结束时间
        if ((workOrderPlan.getPlan_start_time() == null) && (workOrderPlan.getPlan_end_time() == null) && (workOrderPlan.getPlan_start_time().getTime() > workOrderPlan.getPlan_end_time().getTime())) {
            return null;
        } else {
            //2 调用业务逻辑层queryWorkOrderPlanForTimeRegin方法查询数据
            workOrderPlanList = countWorkOrderPlanService.queryWorkOrderPlanForTimeRegin(workOrderPlan);
        }
        return workOrderPlanList;
    }

    /**
     * 统计已生成工单的工单计划数
     *
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanComplete")
    public List<WorkOrderPlan> queryWorkOrderPlanComplete() {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        workOrderPlanList = countWorkOrderPlanService.queryWorkOrderPlanComplete();
        return workOrderPlanList;
    }

    /**
     * 统计未生成工单的工单计划数
     *
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanNotComplete")
    public List<WorkOrderPlan> queryWorkOrderPlanNotComplete() {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        workOrderPlanList = countWorkOrderPlanService.queryWorkOrderNotPlanComplete();
        return workOrderPlanList;
    }

    /**
     * 统计提交的工单计划数
     *
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanAll")
    public List<WorkOrderPlan> queryWorkOrderPlanAll() {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        workOrderPlanList = countWorkOrderPlanService.queryWorkOrderAll();
        return workOrderPlanList;
    }
}

