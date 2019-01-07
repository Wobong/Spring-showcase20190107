package com.cheer.spring;

import com.cheer.spring.dao.EmpDao;
import com.cheer.spring.dao.Impl.EmpDaoImpl;
import com.cheer.spring.model.Emp;
import com.cheer.spring.model.Person;

import com.cheer.spring.service.EmpService;
import com.cheer.spring.service.Impl.EmpServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SpringTest {
    public static final Logger LOGGER= LogManager.getLogger(SpringTest.class);
    @Test
    public void aguang() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //反射方法实例化对象
        //(1),获取Class对象
        Class<?> clazz=Class.forName("com.cheer.spring.model.Person");
        //(2),创建对象
        Object obj=clazz.newInstance();
        //(3),获取对象方法
        Method setter=clazz.getDeclaredMethod("setName",String.class);
        //(4),调用对象
        setter.invoke(obj,"屎光飞");
        LOGGER.debug(obj);

        //spring实例化对象
        //获取spring应用对象
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring/spring.beans.xml");
        Person person=applicationContext.getBean(Person.class);
        LOGGER.debug(person);
    }

    @Test
    public void getEmp(){
        EmpDao empDao=new EmpDaoImpl();
        EmpService empService=new EmpServiceImpl();
        ((EmpServiceImpl) empService).setEmpDao(empDao);
        Emp emp=empService.getEmp();
        LOGGER.debug(emp);

        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring/spring.beans.xml");
        EmpService empService1=applicationContext.getBean(EmpServiceImpl.class);
        Emp emp1=empService1.getEmp();
        LOGGER.debug(emp1);
    }
}
