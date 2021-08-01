package com.jiker.workorderms.dao;

import com.jiker.workorderms.bean.WorkOrder;
import com.jiker.workorderms.bean.WorkOrderPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface WorkOrderDao {

    @Select("select * from workorderms.workorder_plan where status=0 and plan_start_time>=date_format('${start_time}','%Y-%m-%d %H:%i:%s') and plan_start_time < date_format('${end_time}','%Y-%m-%d %H:%i:%s')")
    List<WorkOrderPlan> queryWorkOrder(String start_time, String end_time);


    @Insert("insert into workorder(number,name,content,start_time,end_time,role,executor,status) values(#{number}, #{name}, #{content}, #{start_time}, #{end_time}, #{role}, #{executor}, #{status})")
    void insertWorkOrder(WorkOrder workOrder);

    @Update("update workorderms.workorder_plan set status=1 where id = #{id}")
    void updateWorkOrderPlanById(int id);
}
