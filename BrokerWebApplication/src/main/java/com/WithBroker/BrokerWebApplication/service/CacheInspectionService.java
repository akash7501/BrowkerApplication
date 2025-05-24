package com.WithBroker.BrokerWebApplication.service;


import com.WithBroker.BrokerWebApplication.entity.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheInspectionService {

    @Autowired
    CacheManager cacheManager;   // spring method

    public List<OwnerEntity> printCacheData(String s)
    {
         if(s!=null)
         {
             System.out.println("there is a data in cache" +cacheManager.getCacheNames());
             String name = String.valueOf(cacheManager.getCache(s));
             System.out.println(name);
         }
         else
         {
             System.out.println("no data int cacehe");
         }
        return null;
    }
}
