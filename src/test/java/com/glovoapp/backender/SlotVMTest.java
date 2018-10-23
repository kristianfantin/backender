package com.glovoapp.backender;

import com.glovoapp.backender.domain.services.SlotService;
import com.glovoapp.backender.domain.viewer.SlotVM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SlotVMTest {

    @Autowired
    private SlotService slotService;

    @Test
    void initSlots() {
        List<SlotVM> list = slotService.getSlotVM();
        assertTrue(list.size() > 1);
    }
}
