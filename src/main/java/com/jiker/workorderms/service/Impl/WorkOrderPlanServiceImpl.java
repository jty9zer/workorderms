package com.jiker.workorderms.service.Impl;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.dao.WorkOrderPlanDao;
import com.jiker.workorderms.service.WorkOrderPlanService;
import com.jiker.workorderms.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workOrderPlanService")
public class WorkOrderPlanServiceImpl implements WorkOrderPlanService {

    @Autowired
    private WorkOrderPlanDao workOrderPlanDao;

    @Autowired
    Utils utils;

    /**
     * 创建工单业务逻辑处理
     *
     * @param workOrderPlan
     * @return
     */
    @Override
    public int createWorkOrderPlan(WorkOrderPlan workOrderPlan) {
        //1 根据科室代码生成工单号
        String number = utils.createWorkOrderNumber(workOrderPlan.getNumber());
        //2 根据周期生成对应的cron
        String cycle = utils.analysisCycle(workOrderPlan.getCycle());
        //3 调用Dao层入库
        workOrderPlan.setNumber(number);
        workOrderPlan.setCycle(cycle);
        int result = 0;
        result = workOrderPlanDao.insert(workOrderPlan);
        return result;
    }

    @Override
    public int updateWorkOrderPlan(WorkOrderPlan workOrderPlan) {
        int result = 0;
        result = workOrderPlanDao.update(workOrderPlan);
        return result;
    }

    @Override
    public int deleteWorkOrderPlan(WorkOrderPlan workOrderPlan) {
        int result = 0;
        result = workOrderPlanDao.delete(workOrderPlan);
        return result;
    }
}
