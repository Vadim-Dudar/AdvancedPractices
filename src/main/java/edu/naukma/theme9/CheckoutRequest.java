package edu.naukma.theme9;

import lombok.Builder;
import java.util.List;

@Builder
public class CheckoutRequest {
    private Long userId;
    private List<Long> itemIds;
    private String shippingAddress;
}
