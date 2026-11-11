package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Concrete Strategy 1B: Thanh toán qua Ví điện tử MoMo.
 */
public class MoMoWalletStrategy implements PaymentStrategy {
    @Override
    public String getStrategyName() {
        return "Ví Điện Tử MoMo (Tích điểm hoàn tiền)";
    }

    @Override
    public void pay(double amount, String orderId) {
        System.out.println(String.format(
            "   [Ví MoMo] Khấu trừ ví MoMo cho đơn [%s] | Số tiền: %,.0f VNĐ -> Giao dịch thành công, tích 25 điểm MoMo Rewards!",
            orderId, amount
        ));
    }
}
