package com.drawthink.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage   {
    private static final long serialVersionUID = 5858131565182217048L;
    //序列化id To do
    private Integer messageid;
    private String direction;


}
