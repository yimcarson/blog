package com.my.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "username", nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "insert_time")
    @CreatedDate
    private Date insertTime;

    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete;

    private User(Builder builder) {
        setId(builder.id);
        setNickname(builder.nickname);
        setUsername(builder.username);
        setPassword(builder.password);
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
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
        private String nickname;
        private String username;
        private String password;
        private Date insertTime;
        private Date updateTime;
        private Boolean isDelete;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder nickname(String val) {
            nickname = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
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

        public User build() {
            return new User(this);
        }
    }
}
