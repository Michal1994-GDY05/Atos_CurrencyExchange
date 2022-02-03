package pojo;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    private String currency;
    private BigDecimal rate;
}
