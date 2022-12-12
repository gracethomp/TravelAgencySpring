package com.kpi.travelagency.service;

import com.kpi.travelagency.repo.OrderRepository;

import java.time.LocalDate;

public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    @Override
    public void createOrder(String tour, LocalDate dateFrom, LocalDate dateTo, String client) {

    }

    @Override
    public void editOrder(String order, LocalDate dateFrom, LocalDate dateTo) {

    }

    @Override
    public void editOrder(String order, Integer tour) {

    }

    @Override
    public void editOrder(String order, String user) {

    }

    @Override
    public void cancelOrder(String order) {

    }
}
