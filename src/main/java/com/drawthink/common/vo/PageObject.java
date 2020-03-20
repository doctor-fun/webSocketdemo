package com.drawthink.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = -4104203823598123156L;
    private List<T> records;
    /**当前页的页码值*/
    private Integer pageCurrent=1;
    /**页面大小*/
    private Integer pageSize=3;
    /**总行数(通过查询获得)*/
    private Integer rowCount=0;
    /**总页数(通过计算获得)*/
    private Integer pageCount=0;


    /**
     * 当前页记录
     * @param records
     * @param rowCount
     * @param pageCurrent
     * @param pageSize
     */
    public PageObject(List<T> records,Integer rowCount, Integer pageCurrent, Integer pageSize) {
        this.records = records;
        //总行数
        this.rowCount = rowCount;
        //当前页面的页面值
        this.pageCurrent = pageCurrent;
        //页面大小
        this.pageSize = pageSize;
        //总页数
        this.pageCount=(rowCount-1)/pageSize+1;
    }
}
