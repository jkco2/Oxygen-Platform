package com.ethercraft.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperty {

    private String secret;

    private Long expire;

}
