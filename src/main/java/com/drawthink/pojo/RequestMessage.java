package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author fangchen
* @date 2020/3/16 2:34 下午
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
//用于springmvc接收消息
public class RequestMessage   {
    private static final long serialVersionUID = 2119098649603472347L;
    private Integer message_id;
    private Integer robot_id;
    private Integer status;//用于表示机器人的当下状态
    //比如 我已经往左走了n步，请继续指示
    private String messagebody;
}
