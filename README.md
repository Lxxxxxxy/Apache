# apache

#### 介绍

阿佩奇二手交易平台

#### 使用技术

使用了主流的ssm框架（Spring+Spring MVC+MyBatis）,使用maven管理jar包，有的界面还使用了freemarker来对页面模板进行渲染，针对每一个Controller，大都使用ajax来和Controller返回的json数据进行交互，使用bootstrap对前端页面进行布局，对数据表的操作全都开启了事务管理。

软件架构说明

#### 文件说明

测试图片：Images.zip

SQL文件：apache.sql

#### 安装说明

1.图片映射路径配置：需要在tomcat的conf文件夹server.xml配置文件中，Host标签下添加一条下面表格中的标签，不能修改，否则可能会出现图片无法正常显示问题。
Linux：
在home文件夹创建Images文件夹，把Apache目录放入。

```xml
<Context path="/Apache/upload" docBase="/home/Images/Apache/upload" debug="0" reloadbale="true"/>
```

Windows:
在D盘创建Images文件夹，把Apache目录放入。

```xml
<Context path="/Apache/upload" docBase="D:\Images\Apache\upload" reloadable="true" debug="0"/>
```

2.数据库配置：提供了一个sql.sql文件，里面保存了项目所需要的最基本的数据表，在项目中resources文件夹中有一个db.properties文件，里面必须修改数据库的一些配置数据，比如数据库账号密码。
4.管理员账号admin，管理员密码admin。
**注：不支持IE浏览器**