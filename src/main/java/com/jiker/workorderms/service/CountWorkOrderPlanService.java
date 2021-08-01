package com.jiker.workorderms.service;

import com.jiker.workorderms.bean.WorkOrderPlan;

import java.util.List;

public interface CountWorkOrderPlanService {

    List<WorkOrderPlan> queryWorkOrderPlanForTimeRegin(WorkOrderPlan workOrderPlan);

    List<WorkOrderPlan> queryWorkOrderPlanComplete();

    List<WorkOrderPlan> queryWorkOrderNotPlanComplete();

    List<WorkOrderPlan> queryWorkOrderAll();
}
