package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
* @author fangchen
* @date 2020/3/18 11:05 上午
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskPointBean {
    private Integer pointId;
    private Double x;
    private Double y;
    private Double z;
    private float direction;
    private Integer stayTime;
    private String speak;//介绍文字内容
    //希望机器人要做的动作是什么
    private Integer actionId;
    //控制设备列表
    private List<TaskPointDevice> devices;


}
