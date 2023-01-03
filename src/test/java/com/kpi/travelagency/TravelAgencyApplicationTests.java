package com.kpi.travelagency;

import com.kpi.travelagency.constants.Status;
import com.kpi.travelagency.entity.User;
import com.kpi.travelagency.entity.Voucher;
import com.kpi.travelagency.service.TourServiceImpl;
import com.kpi.travelagency.service.UserService;
import com.kpi.travelagency.service.VoucherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelAgencyApplicationTests {
    @Autowired
    VoucherService voucherService;
    @Autowired
    TourServiceImpl tourService;
    @Autowired
    UserService userService;
    @Test
    void VoucherServiceTest() {
        Voucher voucher = new Voucher();
        voucher.setId(23);
        voucher.setTotalPrice(2000.0);
        voucher.setStatus(Status.IN_PROGRESS);
        voucherService.save(voucher);
        Assertions.assertEquals(voucher, voucherService.getVoucherByID(23));
    }
    @Test
    void TourServiceTest() {
        Voucher voucher = new Voucher();
        voucher.setId(27);
        Assertions.assertEquals(tourService.findById(Long.valueOf(voucherService.getTourByVaucher(voucher))),
                tourService.findById(1L));
    }
    @Test
    void UserServiceTest() throws Exception {
        User user = new User();
        user.setId("2324");
        user.setName("l");
        user.setBirthDate("1993-05-27:");
        user.setPassportID("GT54345");
        user.setEmail("ertl@mail.com");
        user.setPhoneNumber("+32445435");
        userService.saveUser(user);
        Assertions.assertEquals(userService.findUserByID("2324"), user);
    }

}
