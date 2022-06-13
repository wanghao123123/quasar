package com.example.quasar.envent;

import com.example.quasar.annotation. Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/**
 * @author hao.wong
 * @create 2022/3/24
 */
@Component
@Slf4j
public class ApplicationStartedProcessorEvent {

    public static Map<Integer, Method> idToMethod =new ConcurrentHashMap<>(100);
    public static Map<Integer, Object> idToClass =new ConcurrentHashMap<>(100);

    @EventListener(ApplicationStartedEvent.class)
    public void started(ApplicationStartedEvent event) {
        Map<String, Object> beansWithAnnotation = event.getApplicationContext().getBeansWithAnnotation(Service.class);

        beansWithAnnotation.values().forEach(o-> ReflectionUtils.doWithMethods(o.getClass(), m->{
            if(m.isAnnotationPresent(Processor.class)){
                Processor annotation = m.getAnnotation(Processor.class);
                if(idToMethod.containsKey(annotation.serviceType())){
                    log.error("类名：【{}】，方法：【{}】，ServiceType已存在",o.getClass().getSimpleName(),m.getName());
                }
                idToClass.put(annotation.serviceType(),o);
                idToMethod.put(annotation.serviceType(),m);
            }
        }));

    }
}
