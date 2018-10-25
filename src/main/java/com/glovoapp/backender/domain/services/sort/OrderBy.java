package com.glovoapp.backender.domain.services.sort;

import com.glovoapp.backender.config.BeanUtil;
import com.glovoapp.backender.domain.viewer.SlotVM;

import java.util.List;

public enum OrderBy {

    VIP(SortByVipService.class),
    FOOD(SortByFoodService.class),
    VIP_FOOD(SortByVipAndFoodService.class),
    FOOD_VIP(SortByFoodAndVipService.class);

    public static OrderBy getValue(String value) {
        try {
            return valueOf(value);
        }
        catch (Exception e) {
            return null;
        }
    }

    public List<SlotVM> getSlots(List<SlotVM> list) {
        return getService().getSlots(list);
    }

    private Class clazz;

    <T extends SortService> OrderBy(Class<?> serviceClass) {
        this.clazz = serviceClass;
    }

    private SortService getService() {
        return (SortService) BeanUtil.getBean(this.clazz);
    }

}
