package edu.naukma.theme6.task1;

public class GodShopService {
    // TODO: split responsibilities into separate services.
    ShopNotificationService emailNotificationService = new ShopNotificationService();
    ShopOrderService orderService = new ShopOrderService();
    ShopReportService reportService = new ShopReportService();
    ShopUserService userService = new ShopUserService();

    public boolean payOrder(long orderId) {
        orderService.payOrder(orderId);
        emailNotificationService.sendEmail(String.valueOf(orderId), "Your order has been paid.");
        return true;
    }

}
