package com.ljs.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ljs
 * @since 2021/8/25 下午8:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
// @JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class ShaBean {

    @JsonProperty(value = "USER_NAME")
    private String USER_NAME;

    @JsonProperty(value = "HA_S")
    private String HA_S;

    @JsonProperty("MY_BE")
    private MyBean MY_BEAN;

    @JsonProperty("LOVE_AND")
    private String loveAnd;
}
