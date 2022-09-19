package com.xyc.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1 on 2021/5/11.
 */
@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "username",length = 64)
    private String username;

    @Column(name = "usercode",length = 32)
    private String usercode;

    @Column(name = "OBJECT_VERSION" )
    //@Version
    private Integer objectVersion;

    @Column(name = "CREATED_BY" ,length = 32)
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_DATE",columnDefinition = "date")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDate;

    @Column(name = "LAST_UPDATED_BY" ,length = 32)
    @LastModifiedBy
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE",columnDefinition = "date")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdatedDate;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", usercode='" + usercode + '\'' +
                ", objectVersion=" + objectVersion +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
