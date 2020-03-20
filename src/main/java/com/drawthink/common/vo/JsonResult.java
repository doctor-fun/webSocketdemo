package com.drawthink.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 176850351454067971L;
    //状态码
    private  int state;//，表示正常
    //状态码对应的信息
    private String message;
    private Object data;//用于保存结果数据实体
    public JsonResult(String message){
        this.message=message;
    }
    public JsonResult(Object data){
        this.data=data;
    }
    //如果入口参数是个e（异常类），调用这个构造函数，并执行
    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }

}
