package com.example.skel.properties;

import com.example.skel.properties.nested.Cors;
import com.example.skel.properties.nested.SecureConfigs;
import lombok.Data;

@Data
public class AppConfigs {
    private Cors cors;
    private SecureConfigs secureConfigs;
}
