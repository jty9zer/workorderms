package com.jiker.workorderms.service;

import com.jiker.workorderms.bean.WorkOrderPlan;

public interface WorkOrderPlanService {
    int createWorkOrderPlan(WorkOrderPlan workOrderPlan);

    int updateWorkOrderPlan(WorkOrderPlan workOrderPlan);

    int deleteWorkOrderPlan(WorkOrderPlan workOrderPlan);
}
