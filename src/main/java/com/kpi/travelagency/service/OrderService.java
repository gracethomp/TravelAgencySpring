package com.kpi.travelagency.service;

import java.time.LocalDate;

public interface OrderService {
    void createOrder(String tour, LocalDate dateFrom, LocalDate dateTo, String client);
    void editOrder(String order, LocalDate dateFrom, LocalDate dateTo);
    void editOrder(String order, Integer tour);
    void editOrder(String order, String user);
    void cancelOrder(String order);
}
