package com.jiker.workorderms.service.Impl;

import com.jiker.workorderms.bean.WorkOrder;
import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.dao.WorkOrderDao;
import com.jiker.workorderms.dao.WorkOrderPlanDao;
import com.jiker.workorderms.service.WorkOrderService;
import com.jiker.workorderms.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("workOrderService")
public class WorkOrderServiceImpl implements WorkOrderService {
    /**
     * 根据工单计划生成工单
     * @throws ParseException
     */

    @Autowired
    WorkOrderPlanDao workOrderPlanDao;
    @Autowired
    WorkOrderDao workOrderDao;
    @Autowired
    Utils utils;

    @Override
    public void produceWorkOrder() throws ParseException {
        List<WorkOrderPlan> workOrderPlanList=new ArrayList<>();
        List<WorkOrder> workOrderList=new ArrayList<>();
        Map<String ,Object> map =new HashMap<String,Object>();

        //1.获取当天的启动和结束时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String start_time=sdf.format(new Date())+" 00:00:00";
        sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate=utils.dateAdd(sdf.parse(start_time),5,1);//date参数加1天
        String end_time = sdf.format(newDate);

        //2. 获得当天时间范围内的任务
        workOrderPlanList=workOrderDao.queryWorkOrder(start_time, end_time);


        //3.更新时间值，作为打印时间戳
        String strDate=sdf.format(new Date());

        //4.调用工单生成方法
        if(workOrderPlanList.size()<0){
            //当日无工单计划
            return;
        }
        map=utils.produceWorkOrder(workOrderPlanList);
        workOrderList=(List<WorkOrder>) map.get("workOrder");
        workOrderPlanList=(List<WorkOrderPlan>)map.get("workOrderPlan");

        //5 工单数据入库
        for(WorkOrder workOrder:workOrderList){
            workOrder.setStatus("0");
            workOrderDao.insertWorkOrder(workOrder);
        }

        //6 更新工单计划数据：工单生成状态置为1-已生成
        for(WorkOrderPlan workOrderPlan:workOrderPlanList){
            workOrderDao.updateWorkOrderPlanById(workOrderPlan.getId());
        }

        System.out.println(strDate+":根据工单号生成工单入库成功");
    }
}
