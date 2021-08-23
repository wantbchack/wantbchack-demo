### @MappedSuperclass注解的使用
> 使用条件：当我们进行开发项目时，我们经常会用到实体映射到数据库表的操作，此时我们经常会发现在我们需要隐射的几个实体类中，
有几个共同的属性，例如编号ID，创建者，创建时间，修改者，修改时间，备注等。
遇到这种情况，我们可能会想到把这些属性抽象出来当成一个父类，然后再以不同的实体类来继承这个父类。
那么，我们便可以使用@MappedSuperclass注解，通过这个注解，我们可以将该实体类当成基类实体，
它不会隐射到数据库表，但继承它的子类实体在隐射时会自动扫描该基类实体的隐射属性，添加到子类实体的对应数据库表中。

**使用环境:**

1.@MappedSuperclass注解使用在父类上面，是用来**标识父类**的

2.@MappedSuperclass标识的类表示**其不能映射到数据库表**，因为其不是一个完整的实体类，但是它所拥有的属性能够隐射在其子类对用的数据库表中

3.@MappedSuperclass标识得**不能再有@Entity或@Table注解**

###@Column注解使用
>使用条件映射数据库里面的字段

**注解使用:**

1.name:数据库字段值,与数据库字段一定要相同才能映射

2.nullable: 是否能不能为空, 默认打开, 等于false为不能为空

3.updatable:是否可以更新,默认打开,等于false为不能更新

###@Temporal()注解的使用
>数据库的字段类型有date、time、datetime
 而Temporal注解的作用就是帮Java的Date类型进行格式化，一共有三种注解值：第一种：@Temporal(TemporalType.DATE)——>实体类会封装成日期“yyyy-MM-dd”的 Date类型。
 第二种：@Temporal(TemporalType.TIME)——>实体类会封装成时间“hh-MM-ss”的 Date类型。
 第三种：@Temporal(TemporalType.TIMESTAMP)——>实体类会封装成完整的时间“yyyy-MM-dd hh:MM:ss”的 Date类型。
 
 ###@CreatedDate/@LastModifiedDate注解的使用
 >@CreatedDate
  表示该字段为创建时间时间字段，在这个实体被insert的时候，会设置值
  @CreatedBy
  表示该字段为创建人，在这个实体被insert的时候，会设置值
  @LastModifiedDate
  表示该字段为更新时间时间字段，在这个实体被update的时候，会设置值
  @LastModifiedBy
  表示该字段为创建人，在这个实体被update的时候，会设置值
  
 **注解使用:**
  首先申明实体类，需要在类上加上注解@EntityListeners(AuditingEntityListener.class)，其次在application启动类中加上注解EnableJpaAuditing，同时在需要的字段上加上@CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy等注解。
  
  这个时候，在jpa.save方法被调用的时候，时间字段会自动设置并插入数据库，但是CreatedBy和LastModifiedBy并没有赋值，因为需要实现AuditorAware接口来返回你需要插入的值。
  
  
 ###@OneToMany注解使用
 
```java
package com.wantbachk.springdata.entity.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

package com.wantbchack.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wantbchack.springdata.entity.base.AbstractAuditModel;
import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.List;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/23/15:22
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name = "user")
public class User extends AbstractAuditModel {

    /**
     * username
     */
    @Column(name="username")
    private String username;

    /**
     * password
     */
    @Column(name="password")
    private String password;

    /**
     * 关联用户课程
     */
    @OneToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"user"})
    private List<UserClass> userClassList;

}
 ```
 ```java
 package com.wantbchack.springdata.entity;
 
 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 import com.wantbchack.springdata.entity.base.AbstractAuditModel;
 import lombok.*;
 
 import javax.persistence.*;
 
 /**
  * @author: fanxiaobin
  * @Date: 2021/08/23/15:54
  */
 
 @EqualsAndHashCode(callSuper = true)
 @NoArgsConstructor
 @AllArgsConstructor
 @Entity
 @Builder
 @Getter
 @Setter
 @Table(name = "user_class")
 public class UserClass extends AbstractAuditModel {
 
     /**
      * user_id
      */
     @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
     @JoinColumn(name="user_id",updatable = false)
     @JsonIgnoreProperties({"userClass"})
     private User user;
 
     /**
      * class_id
      */
     @Column(name="class_id")
     private Integer classId;
 
     /**
      * class_name
      */
     @Column(name="class_name")
     private String className;
 
 }
  ```
 **注意:** 代码存在循环引用问题,避免循环应用的方案在返回http接口层的时候将对象转换成DTO再进行传输
 