package com.lanou3g.bookstore.util;

import com.lanou3g.bookstore.user.domain.User;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


public class SendEmail {
    private String sendAddr = "1327316668";
    private String receiveAddr;
    private String pass = "prfgaizlmhfefgae";

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }




    public void send(User user,String code) throws
            MessagingException {
        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.host","smtp.qq.com");

        prop.setProperty("mail.smtp.auth","true");

        prop.setProperty("mail.smtp.port", "587");
//		prop.put("mail.transport.protocol", "smtp");

        //我们要登录一个账号,来给别人发邮件
        //现在先构建一个邮件账号，需要用邮件地址和密码

        //发件人 + 授权码  登录QQ邮箱
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication
            getPasswordAuthentication() {
                return new PasswordAuthentication(
                        sendAddr+"@qq.com",pass);
            }
        };

        //与服务器连接,这时候就连上了qq.com的服务器
        //实际上就是用java代码,登录了自己的163邮箱
        Session session = Session.getInstance(prop,auth);

        //创建一个邮件对象
        //这就是登录了邮箱之后,点击了发邮件,进入编辑邮件的窗口
        MimeMessage msg =
                new MimeMessage(session);

        //设置发件人
        msg.setFrom(new InternetAddress(
                sendAddr+"@qq.com"));

        //设置收件人
        msg.setRecipients(Message.RecipientType.TO,
                user.getEmail()
                        + "@163.com");
        //添加主题
        msg.setSubject(
                user.getEmail ()+"@163.com的用户"+"正在注册商城,您的用户名为"
                        +user.getUsername ()
                        +"确认本人操作后,请点击激活注册"+"再次确定");

        //添加内容,第二个参数表示这是html的内容
        msg.setContent("<br/><a href=\"http://localhost:8080/bookS" +
                "tore/user?method=active&code="
                + code+ "\" + >点击继续注册</a>","text/html;charset=utf-8");
        //这个是送邮箱服务器发送
        Transport.send(msg);
    }


}
