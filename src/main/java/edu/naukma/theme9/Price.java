package edu.naukma.theme9;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class Price {
    BigDecimal amount;
    String currency;
}