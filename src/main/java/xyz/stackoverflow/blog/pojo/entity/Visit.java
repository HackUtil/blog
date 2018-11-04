package xyz.stackoverflow.blog.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 访问量实体类
 *
 * @author 凉衫薄
 */
public class Visit implements Serializable {

    protected String id;
    protected String url;
    protected Integer status;
    protected String ip;
    protected String agent;
    protected Date date;

    public Visit(){

    }

    public Visit(String id, String url, Integer status, String ip, String agent, Date date) {
        this.id = id;
        this.url = url;
        this.status = status;
        this.ip = ip;
        this.agent = agent;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
