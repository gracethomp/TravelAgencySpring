package com.kpi.travelagency.controller;

import com.kpi.travelagency.service.OrderService;
import com.kpi.travelagency.service.OrderServiceImpl;
import org.apache.log4j.Logger;

public class OrderController {
    OrderService orderService = new OrderServiceImpl();

    private final static Logger LOGGER = Logger.getLogger(OrderController.class);
}
