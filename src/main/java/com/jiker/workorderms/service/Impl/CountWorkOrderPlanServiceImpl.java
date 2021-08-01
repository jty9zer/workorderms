package com.jiker.workorderms.service.Impl;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.dao.CountWorkOrderPlanDao;
import com.jiker.workorderms.service.CountWorkOrderPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("countWorkOrderPlanService")
public class CountWorkOrderPlanServiceImpl implements CountWorkOrderPlanService {
    @Autowired
    CountWorkOrderPlanDao countWorkOrderPlanDao;

    /**
     * 统计某个时间段内的工单计划数
     *
     * @param workOrderPlan
     * @return
     */
    @Override
    public List<WorkOrderPlan> queryWorkOrderPlanForTimeRegin(WorkOrderPlan workOrderPlan) {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        //调用Dao层queryWorkOrderPlanForTimeRegin查询数据
        workOrderPlanList = countWorkOrderPlanDao.queryWorkOrderPlanForTimeRegin(workOrderPlan);
        return workOrderPlanList;
    }


    /**
     * 统计已生成工单的工单计划数
     *
     * @return
     */
    @Override
    public List<WorkOrderPlan> queryWorkOrderPlanComplete() {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        //调用Dao层queryWorkOrderPlanComplete查询数据
        workOrderPlanList = countWorkOrderPlanDao.queryWorkOrderPlanComplete();
        return workOrderPlanList;
    }

    @Override
    public List<WorkOrderPlan> queryWorkOrderNotPlanComplete() {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        //调用Dao层queryWorkOrderNotPlanComplete查询数据
        workOrderPlanList = countWorkOrderPlanDao.queryWorkOrderNotPlanComplete();
        return workOrderPlanList;
    }

    @Override
    public List<WorkOrderPlan> queryWorkOrderAll() {
        List<WorkOrderPlan> workOrderPlanList = new ArrayList<WorkOrderPlan>();
        //调用Dao层queryWorkOrderAll查询数据
        workOrderPlanList = countWorkOrderPlanDao.queryWorkOrderAll();
        return workOrderPlanList;
    }


}
