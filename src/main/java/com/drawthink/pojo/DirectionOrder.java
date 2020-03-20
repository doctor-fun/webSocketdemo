package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectionOrder {
    private Integer direction;//0就是停止,1左，2右，3上，4下
    private float angle;
}
