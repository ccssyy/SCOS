package es.source.code.model;

import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by SamChen on 2017/10/22.
 */

public class MailInfo {
    private String mailServerHost;    // 发送邮件的服务器的IP
    private String mailServerPort;    // 发送邮件的服务器的端口
    private String fromAddress;       // 邮件发送者的地址
    private String toAddress;         // 邮件接收者的地址
    private String userName;          // 登陆邮件发送服务器的用户名
    private String password;          // 登陆邮件发送服务器的密码
    private boolean validate = true;  // 是否需要身份验证
    private String subject;           // 邮件主题
    private String content;           // 邮件的文本内容
    //private String[] attachFileNames; // 邮件附件的文件名

    //邮件会话属性
    public Properties getProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host",this.mailServerHost);
        properties.put("mail.smtp.port",this.mailServerPort);
        properties.put("mail.smtp.auth",validate ? "true":"false");

        //!!!开启安全协议!!!
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        return properties;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }*/
}
