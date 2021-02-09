package com.example.skel.configs;

import com.example.skel.properties.AppConfigs;
import com.example.skel.properties.Logging;
import com.example.skel.properties.Server;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

//why require prefix
@ConfigurationProperties(prefix = "default")
@Data
public class ApplicationProperties implements PriorityOrdered {
    private Logging logging;
    private Server server;
    private AppConfigs appConfigs;
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
