package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskPointDevice {
    private Integer deviceId;//设备id
    private Integer deviceCommandId;//通信协议ID
    private String deviceAddress;//设备地址 ip;端口
    private String createdTime;




}
