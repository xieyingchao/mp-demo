package top.bitclick.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xie Yingchao
 * @since 2020-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EmployeeTbl对象", description="")
public class EmployeeTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private LocalDateTime date;

    @ApiModelProperty(value = "登录次数")
    private Integer singin;


}
