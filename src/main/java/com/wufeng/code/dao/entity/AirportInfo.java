package com.wufeng.code.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author niuyq
 * @since 2021-12-13
 */
@Getter
@Setter
@TableName("airport_info")
@ApiModel(value = "AirportInfo对象", description = "")
public class AirportInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("城市中文名")
    private String cityNname;

    @ApiModelProperty("城市英文名")
    private String cityEname;

    @ApiModelProperty("机场名中文名")
    private String airportNname;

    @ApiModelProperty("机场英文名")
    private String airportEname;

    @ApiModelProperty("机场 IATA 代码")
    private String iata;

    @ApiModelProperty("机场 ICAO 代码")
    private String icao;

    @ApiModelProperty("国家")
    private String contry;

    @ApiModelProperty("国家英文名")
    private String contryEname;


}
