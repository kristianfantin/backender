package com.glovoapp.backender.domain.services;

import com.glovoapp.backender.config.BeanUtil;
import com.glovoapp.backender.domain.viewer.ViewOrder;

import java.util.List;

public enum OrderBy {

    VIP(SortByVipService.class),
    FOOD(SortByFoodService.class),
    VIP_FOOD(SortByVipAndFoodService.class),
    FOOD_VIP(SortByFoodAndVipService.class);

    public static OrderBy getValue(String value) {
        if (value.equals("VIP_FOOD"))
            return VIP_FOOD;
        if (value.equals("FOOD_VIP"))
            return FOOD_VIP;

        return null;
    }

    List<ViewOrder> getSort(List<ViewOrder> viewOrderList) {
        return getService().getSort(viewOrderList);
    }

    private Class clazz;

    <T extends SortService> OrderBy(Class<?> serviceClass) {
        this.clazz = serviceClass;
    }

    private SortService getService() {
        return (SortService) BeanUtil.getBean(this.clazz);
    }

}
