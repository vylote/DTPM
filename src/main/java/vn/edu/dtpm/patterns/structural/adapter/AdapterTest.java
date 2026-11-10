package vn.edu.dtpm.patterns.structural.adapter;

public class AdapterTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ ADAPTER PATTERN: VNPAY -> MOMO ---");
        System.out.println("==================================================");

        // Khởi tạo dịch vụ thực thi VNPay
        VNPayPayable vnpay = new VNPayImpl();

        // Sử dụng Adapter để hệ thống xem như đây là dịch vụ MoMo
        MoMoPayable adapter = new VNPayToMoMoAdapter(vnpay);

        // Client gọi theo chuẩn MoMo nhưng lõi chạy qua hạ tầng VNPay
        System.out.println("Khách hàng thực hiện thanh toán hóa đơn đơn hàng Shopee/Tiki qua MoMo:");
        adapter.processMoMoPayment(500000.0);
        adapter.processMoMoPayment(1250000.0);
    }
}

