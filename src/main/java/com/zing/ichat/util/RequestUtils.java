package com.zing.ichat.util;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class RequestUtils {

    public static UUID getTokenUUID(HttpServletRequest request){
        return  UUID.fromString(request.getHeader("Authorization"));
    }
}
