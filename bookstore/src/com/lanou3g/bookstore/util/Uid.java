package com.lanou3g.bookstore.util;

import java.util.UUID;

public class Uid {

    public String getUid(){
        UUID uuid  =  UUID.randomUUID();
        String uids = UUID.randomUUID().toString();
       String uid = uids.replaceAll("\\-", "");
        return  uid;
    }



    public String getCode(){
        UUID uuid  =  UUID.randomUUID();
        String uids = UUID.randomUUID().toString()+ UUID.randomUUID().toString();
        String code = uids.replaceAll("\\-", "");
        return code;
    }
}
