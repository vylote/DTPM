package vn.edu.dtpm.patterns.behavioral.strategy;

public class StrategyTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ STRATEGY PATTERN: THANH TOÁN & ĐỊNH DẠNG ---");
        System.out.println("==================================================");

        // 1. Kiểm thử chiến lược thanh toán linh hoạt
        System.out.println("1. CHIẾN LƯỢC THANH TOÁN THƯƠNG MẠI ĐIỆN TỬ:");
        CheckoutService checkout = new CheckoutService();

        // Lựa chọn VNPay QR
        checkout.setPaymentStrategy(new VNPayQRStrategy());
        checkout.processOrderPayment("DONHANG_VN_001", 350000.0);

        // Đổi sang ví MoMo
        checkout.setPaymentStrategy(new MoMoWalletStrategy());
        checkout.processOrderPayment("DONHANG_VN_002", 720000.0);

        // Đổi sang thẻ Napas 247
        checkout.setPaymentStrategy(new NapasCardStrategy());
        checkout.processOrderPayment("DONHANG_VN_003", 1500000.0);

        // 2. Kiểm thử chiến lược định dạng văn bản
        System.out.println("\n2. CHIẾN LƯỢC ĐỊNH DẠNG VĂN BẢN (TEXT FORMATTER):");
        TextEditorContext editor = new TextEditorContext();
        String sampleText = "Dự án Kiến trúc phần mềm DTPM ứng dụng 18 Design Patterns";

        editor.setFormatter(new MarkdownFormatter());
        editor.publish(sampleText);

        editor.setFormatter(new HTMLFormatter());
        editor.publish(sampleText);

        editor.setFormatter(new UpperCaseFormatter());
        editor.publish(sampleText);
    }
}

