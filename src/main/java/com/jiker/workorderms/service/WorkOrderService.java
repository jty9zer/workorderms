package com.jiker.workorderms.service;

import com.jiker.workorderms.dao.WorkOrderDao;
import com.jiker.workorderms.dao.WorkOrderPlanDao;
import com.jiker.workorderms.bean.WorkOrder;
import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public interface WorkOrderService {

    void produceWorkOrder() throws ParseException;
}
