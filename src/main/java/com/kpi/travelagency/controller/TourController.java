package com.kpi.travelagency.controller;

import com.kpi.travelagency.service.TourService;
import com.kpi.travelagency.service.TourServiceImpl;
import org.apache.log4j.Logger;

public class TourController {
    TourService tourService = new TourServiceImpl();

    private final static Logger LOGGER = Logger.getLogger(TourController.class);
}
