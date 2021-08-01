package com.jiker.workorderms.dao;

import com.jiker.workorderms.bean.WorkOrderPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountWorkOrderPlanDao {

    @Select("select * from workorderms.workorder_plan where status=0 and plan_start_time>= #{plan_start_time} and plan_start_time < #{plan_end_time}")
    List<WorkOrderPlan> queryWorkOrderPlanForTimeRegin(WorkOrderPlan workOrderPlan);

    @Select("select * from  workorderms.workorder_plan where status=1")
    List<WorkOrderPlan> queryWorkOrderPlanComplete();

    @Select("select * from  workorderms.workorder_plan where status=0")
    List<WorkOrderPlan> queryWorkOrderNotPlanComplete();

    @Select("select * from  workorderms.workorder_plan")
    List<WorkOrderPlan> queryWorkOrderAll();
}
