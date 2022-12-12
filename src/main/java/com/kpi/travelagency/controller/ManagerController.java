package com.kpi.travelagency.controller;

import com.kpi.travelagency.service.UserService;
import com.kpi.travelagency.service.UserServiceImpl;
import org.apache.log4j.Logger;

public class ManagerController {
    UserService userService = new UserServiceImpl();

    private final static Logger LOGGER = Logger.getLogger(ManagerController.class);
}
