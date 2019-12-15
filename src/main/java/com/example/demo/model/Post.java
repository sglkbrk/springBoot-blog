package com.example.demo.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String url;
    private String title;
    private String message;
    private Long categ;
    private Long user;
    private String date;
    private String time;
    private String content;
    private String imgsrc;
    private Long size;
    private String active;
    private String bannerPost;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "user",  referencedColumnName = "id",insertable = false, updatable = false,nullable = false)
    @Fetch(FetchMode.JOIN)
    private User userData;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "categ",  referencedColumnName = "id",insertable = false, updatable = false,nullable = false)
    @Fetch(FetchMode.JOIN)
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCateg() {
        return categ;
    }

    public void setCateg(Long categ) {
        this.categ = categ;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public User getUserData() {
        return userData;
    }

    public void setUserData(User userData) {
        this.userData = userData;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBannerPost() {
        return bannerPost;
    }

    public void setBannerPost(String bannerPost) {
        this.bannerPost = bannerPost;
    }
}
