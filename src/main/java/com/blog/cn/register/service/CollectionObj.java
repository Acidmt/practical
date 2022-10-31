package com.blog.cn.register.service;

import com.blog.cn.primer.pojo.BlogMessagePojo;
import com.blog.cn.primer.pojo.BlogPathPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionObj {

//    public List<CollectionPojo> CollectionList(List<BlogPathPojo> blogPathPojos, List<BlogMessagePojo> blogMessagePojos){
//        CollectionPojo collectionPojos=new CollectionPojo();
//        List<CollectionPojo> collectionPojoLists;
//        for (int i = 0; i < blogPathPojos.size(); i++) {
//            collectionPojos.setBlogId(collectionPojos.getBlogId());
//        }
//
//    }
//

    public static Map<BlogPathPojo,BlogMessagePojo> BlogMap(List obj1,List obj2){
        Map<BlogPathPojo,BlogMessagePojo> map = new HashMap<>();
        int max= Math.max(obj1.size(), obj2.size());
        if (max!=0){
            for (int j = 0; j < max; j++) {
                map.put((BlogPathPojo)obj1.get(j),(BlogMessagePojo)obj2.get(j));
            }
            return map;
        }
        return null;
    }


}
