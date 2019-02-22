package com.my.blog.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "title", nullable = false, unique = true, updatable = false)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "text")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @Column(name = "insert_time")
    @CreatedDate
    private Date insertTime;

    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete;

    private Article(Builder builder) {
        setId(builder.id);
        setUser(builder.user);
        setTitle(builder.title);
        setContent(builder.content);
        setInsertTime(builder.insertTime);
        setUpdateTime(builder.updateTime);
        isDelete = builder.isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Article() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"user\":")
                .append(user);
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"insertTime\":\"")
                .append(insertTime).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"isDelete\":")
                .append(isDelete);
        sb.append('}');
        return sb.toString();
    }

    public static final class Builder {
        private Long id;
        private User user;
        private String title;
        private String content;
        private Date insertTime;
        private Date updateTime;
        private Boolean isDelete;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder insertTime(Date val) {
            insertTime = val;
            return this;
        }

        public Builder updateTime(Date val) {
            updateTime = val;
            return this;
        }

        public Builder isDelete(Boolean val) {
            isDelete = val;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }
}
