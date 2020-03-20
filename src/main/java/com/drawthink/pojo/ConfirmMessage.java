package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
* @author fangchen
* @date 2020/3/17 5:06 下午
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmMessage {
    private String confirmMsg;
    private String createdTime;
}
