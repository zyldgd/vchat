package com.zing.ichat;

import com.zing.ichat.filter.CrossDomainFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;


public class RestApplication extends ResourceConfig {
    public RestApplication() {
        // 资源类所在的包路径
        packages("com.zing.ichat.resources");

        // 注册 MultiPart
        register(MultiPartFeature.class);

        // 注册CORS过滤器
        register(CrossDomainFilter.class);
    }
}
