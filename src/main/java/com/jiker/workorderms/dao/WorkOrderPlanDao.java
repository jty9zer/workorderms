package com.jiker.workorderms.dao;

import com.jiker.workorderms.bean.WorkOrderPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WorkOrderPlanDao {

    @Insert("insert into workorder_plan(number,name,content,cycle,plan_start_time,plan_end_time,role,executor,status) " +
            "values(#{number},#{name},#{content},#{cycle},#{plan_start_time},#{plan_end_time},#{role},#{executor},#{status})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(WorkOrderPlan workOrderPlan);

    @Select("select max(number) from workorderms.workorder_plan")
    String findMaxNumber();

    @Update("update workorderms.workorder_plan set content=#{content},plan_start_time=#{plan_start_time}, plan_end_time=#{plan_end_time} where id = #{id} ")
    int update(WorkOrderPlan workOrderPlan);

    @Delete("delete from workorderms.workorder_plan where number = #{number}")
    int delete(WorkOrderPlan workOrderPlan);
}
