package com.advanced.dome.spring.all;

import com.advanced.dome.spring.all.util.PropertyValues;

/**
 * @author guohong
 * 储存bean中所有元素
 */
public class BeanDefinition {
    private String id;
    private String clazz;
    private String intMethod;
    private PropertyValues propertyValues;
    private BeanReference beanReference;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getIntMethod() {
        return intMethod;
    }

    public void setIntMethod(String intMethod) {
        this.intMethod = intMethod;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanReference getBeanReference() {
        return beanReference;
    }

    public void setBeanReference(BeanReference beanReference) {
        this.beanReference = beanReference;
    }
}
