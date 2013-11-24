package com.cafuc.mvc.manager;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cafuc.mvc.domain.People;
import com.seeyon.v3x.utils.UUIDLong;

public class TestMain {
	public static void main(String[] args) {
		//读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure();  
          
        //建立SessionFactory  
        SessionFactory factory = cfg.buildSessionFactory();  
          
        //取得session  
        Session session = null;  
        try {  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
            People people = new People();  
            people.setId(UUIDLong.getLong());
            people.setName("张三");  
            people.setPassword("123");  
            
              
            //保存对象  
            session.save(people);
              
            //提交事务  
            session.getTransaction().commit();  
        }catch(Exception e) {  
            e.printStackTrace();  
            //回滚事务  
            session.getTransaction().rollback();  
        }finally {  
            if (session != null) {  
                if (session.isOpen()) {  
                    //关闭session  
                    session.close();  
                }  
            }  
        }  
	}
}
