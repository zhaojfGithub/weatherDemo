package com.zhao.weather.weather_demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class WeatherUserFacility implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 设备id
     */
    private Long facilityId;

    /**
     * 是否收藏 1收  0否
     */
    private Integer collect;

    /**
     * 逻辑删除 1删  0否
     */
    private Integer isDeleted;


}
