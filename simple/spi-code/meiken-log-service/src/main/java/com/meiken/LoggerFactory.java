package com.meiken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class LoggerFactory {
    private static final LoggerFactory loggerFactory = new LoggerFactory();
    private static final Logger logger;

    static {
        ServiceLoader<Logger> loader = ServiceLoader.load(Logger.class);

        List<Logger> loggerList = new ArrayList<>();

        Iterator<Logger> loggerIterator = loader.iterator();
        while(loggerIterator.hasNext()){
            Logger providerLogger = loggerIterator.next();
            loggerList.add(providerLogger);
        }

        if(loggerList.size() != 0){
            logger = loggerList.get(0);
        }else {
            logger = new DefaultLogger();
        }
    }

    public static Logger getLogger(){
        return logger ;
    }

}
