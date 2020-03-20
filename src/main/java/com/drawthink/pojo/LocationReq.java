package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationReq {
    /**
     * 想要的点的Id是？；
     */
    private Integer locationId;
    private String createTime;



}
