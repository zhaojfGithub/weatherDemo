package com.zhao.weather.weather_demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WeatherFacility implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备主键
     */
    @TableId(value = "facility_id", type = IdType.ASSIGN_ID)
    private Long facilityId;

    /**
     * 设备位置
     */
    private String facilitySite;

    /**
     * 设备uuid
     */
    private String facilityUuid;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
