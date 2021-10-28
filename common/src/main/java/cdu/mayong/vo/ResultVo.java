package cdu.mayong.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ResultVo对象", description = "封装接口返回给前端的数据")
public class ResultVo {
    @ApiModelProperty(value = "状态码", dataType = "int")
    private int code;
    @ApiModelProperty(value = "响应的提示信息", dataType = "string")
    private String msg;

    @ApiModelProperty(value = "响应的具体数据", dataType = "object")
    private Object data;

}
