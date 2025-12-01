package com.example.clothingstore.enums;

public enum OrderStatusEnum {

    PLACED, // Đã đặt hàng

    PREPARING, // Đang chuẩn bị

    SHIPPED, // Đang giao hàng

    DELIVERED, // Đã giao hàng

    CANCELED, // Đã hủy

    RETURNED // Đã trả hàng

}


// Nếu là đã giao hàng thì chỉnh sửa thanh toán thành đã thanh toán luôn

// Nếu là trả hàng thì chỉnh sửa thanh toán thành đã hoàn tiền luôn

// Nếu làm vậy thì nó sẽ xảy ra 1 vấn đề là code có if else cách fix như nào để tránh lặp code
// Cách fix: Tạo 1 phương thức trong service để xử lý việc cập nhật trạng thái đơn hàng và trạng thái thanh toán cùng lúc
// Ví dụ: updateOrderStatusAndPaymentStatus(Integer orderId, OrderStatusEnum orderStatus, OrderPaymentStatusEnum paymentStatus)
// Mã giả:
// public void updateOrderStatusAndPaymentStatus(Integer orderId, OrderStatusEnum orderStatus, OrderPaymentStatusEnum paymentStatus) {
//     Order order = orderRepository.findById(orderId).or
//         .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
//     order.setStatus(orderStatus);
//     order.setPaymentStatus(paymentStatus);
//     orderRepository.save(order);
// }

// Nếu làm vậy thì việc ràng buộc nó bị lỏng lẻo vì nếu status gửi lên là đang giao hàng mà orderPayment lại đổi thành đã hoàn tiền thì sao 
// Cách fix: Trong phương thức updateOrderStatusAndPaymentStatus, thêm logic kiểm tra tính hợp lệ của sự kết hợp giữa trạng thái đơn hàng và trạng thái thanh toán trước khi cập nhật
// Mã giả:
// public void updateOrderStatusAndPaymentStatus(Integer orderId, OrderStatusEnum orderStatus, OrderPaymentStatusEnum paymentStatus) {
//     // Kiểm tra tính hợp lệ của sự kết hợp giữa orderStatus và paymentStatus
//     if ((orderStatus == OrderStatusEnum.DELIVERED && paymentStatus != Order
//         .PaymentStatusEnum.PAID) ||
//         (orderStatus == OrderStatusEnum.RETURNED && paymentStatus != OrderPaymentStatusEnum.REFUNDED)) {
//         throw new IllegalArgumentException("Invalid combination of order status and payment status");
//     }
//     Order order = orderRepository.findById(orderId).or
//         .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
//     order.setStatus(orderStatus);
//     order.setPaymentStatus(paymentStatus);
//     orderRepository.save(order);
// }


// vậy nếu mở rộng thì cứ if else thì k tốt 
// Cách fix: Sử dụng một cấu trúc dữ liệu như Map để định nghĩa các trạng thái hợp lệ và kiểm tra dựa trên đó
// Mã giả:
// private static final Map<OrderStatusEnum, OrderPaymentStatusEnum> validStatusCombinations = Map.of(
//     OrderStatusEnum.DELIVERED, OrderPaymentStatusEnum.PAID,
//     OrderStatusEnum.RETURNED, OrderPaymentStatusEnum.REFUNDED
// );
// public void updateOrderStatusAndPaymentStatus(Integer orderId, OrderStatusEnum orderStatus, OrderPaymentStatusEnum paymentStatus) {
//     // Kiểm tra tính hợp lệ của sự kết hợp giữa orderStatus và paymentStatus
//     if (validStatusCombinations.containsKey(orderStatus)) {
//         if (validStatusCombinations.get(orderStatus) != paymentStatus) {
//             throw new IllegalArgumentException("Invalid combination of order status and payment status");
//         }
//     }

//     Order order = orderRepository.findById(orderId).or
//         .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
//     order.setStatus(orderStatus);
//     order.setPaymentStatus(paymentStatus);
//     orderRepository.save(order);
// }