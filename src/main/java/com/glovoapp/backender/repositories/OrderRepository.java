package com.glovoapp.backender.repositories;

import com.glovoapp.backender.domain.Order;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {
    private static final String ORDERS_FILE = "/orders.json";
    private static final List<Order> orders;

    static {
        try (Reader reader = new InputStreamReader(OrderRepository.class.getResourceAsStream(ORDERS_FILE))) {
            Type type = new TypeToken<List<Order>>() {
            }.getType();
            orders = new Gson().fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    public Order findById(String orderId) {
        return orders.stream()
                .filter(order -> orderId.equals(order.getId()))
                .findFirst()
                .orElse(null);
    }

}
