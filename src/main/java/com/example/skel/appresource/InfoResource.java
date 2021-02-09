package com.example.skel.appresource;

import com.example.skel.utils.EnvironmentUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor//(onConstructor = @_(@Autowired))
public class InfoResource implements InfoContributor {
    private final EnvironmentUtils environmentUtils;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> details= new HashMap<>();
        details.put("activeProfiles", environmentUtils.getActiveProfiles());
        builder.withDetails(details);
    }
}
