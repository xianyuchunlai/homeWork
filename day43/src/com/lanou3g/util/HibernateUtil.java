package com.lanou3g.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static SessionFactory SF;

    static {
        SF = new Configuration().configure().buildSessionFactory();
    }

    // 事务的提交与关闭
    public static <T> T handle(ResultHandler<T> rh){
        Session session = SF.openSession();
        Transaction t = session.beginTransaction();
        // 执行我们需要做的业务逻辑
        T tt = rh.resultHandle(session);
        t.commit();
        session.close();
        return tt;
    }

    public interface ResultHandler<T> {
        T  resultHandle(Session session);
    }

}
