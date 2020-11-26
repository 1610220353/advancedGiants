package com.advanced.dome.spring;

import com.advanced.dome.util.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author guohong
 * // IOC 的实现类
 * 加载 xml 配置文件，遍历其中的 <bean> 标签
 * 获取<bean>标签中的 id 和 class 属性，加载 class 属性对应的类，并创建 bean
 * 遍历 <bean> 标签中的 <property> 标签，获取属性值，并将属性值填充到 bean 中
 * 将 bean 注册到 bean 容器中
 */
public class SimpleIoc {
    private Map<String,Object> beanMap = new HashMap<>();

//    private Logger logger = Logger.getLogger("SimpleIoc");

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + name);
        }

        return bean;
    }
    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }
    /**
     * 加载xml配置文件<bean></bean>
     */
    private void loadBeans(String location)  throws Exception{

        InputStream inputStream = new FileInputStream(location);
        //解析xml文件
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document parse = documentBuilder.parse(inputStream);
        Element documentElement = parse.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {

            Node item = childNodes.item(i);
            if (item instanceof Element){
                Element ele = (Element) item;
                //获取xml中的内容
                String id = ele.getAttribute("id");
                String aClass = ele.getAttribute("class");
//                logger.info( "读取xml文件----> id为："+id +"----------------" + "class 为：" +aClass);

                //通过反射获取bean的 位置
                Class beanClass = null;
                try {
                    beanClass = Class.forName(aClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                //创建bean
                Object bean = beanClass.newInstance();

                //循环遍历出<property>
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);

                    if (propertyNode instanceof Element) {
                        Element propertyEle = (Element) propertyNode;

                        String name = propertyEle.getAttribute("name");
                        String value = propertyEle.getAttribute("value");

                        //利用反射将bean相关权限开设置为可访问
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() >0 ){
                            //将属性填充到相关字段中去
                            declaredField.set(bean,value);
                        } else {
                            //获取引用对象
                            String ref = propertyEle.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            declaredField.set(bean,getBean(ref));
                        }
                        //将bean注入到bean容器
                        registerBean(id, bean);
                    }
                }

            }
        }

    }

    public static void main(String[] args) throws Exception {

        SimpleIoc simpleIoc = new SimpleIoc();
        simpleIoc.loadBeans(SimpleIoc.class.getClassLoader().getResource("spring-context.xml").getFile());
        Car car = (Car) simpleIoc.getBean("car");
        System.out.println(car.getName());


    }

}
