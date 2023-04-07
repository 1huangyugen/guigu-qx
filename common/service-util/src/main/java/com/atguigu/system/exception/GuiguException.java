package com.atguigu.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shkstart
 * @date 2023/4/5-13:16
 */
//自定义异常
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiguException extends RuntimeException{
    private Integer code;
    private String msg;
}
