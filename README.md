## 1 作品概述

1.1简介

>>    [Theseed](http://www.theseed.cn) 是一个是一款基于微信的智能网课学习平台。
>
>
>>    主库地址:https://github.com/

1.2 项目特点

- [x] 项目使用springboot构建
- [x] 界面简洁，美观，交互性良好

##2 作品用到的相关技术概述

 2.1 前端

| 框架               | 描述     |
| ---------------- | ------ |
| bootstarp        | 布局与组件  |
| jquery           | DOM操作  |
| ...              |        |                                          |

2.2 后端

| 框架                         | 描述         
| :-------------------------- | ------------------------- | 
| spring boot     | 项目架构          | 
| maven           | 依赖管理          | 
| mybatis plus    | mybatis增强工具 | 
| freemarker      | 后端模板引擎      | 
| ...             |             |



## 3 设计过程

3.1 项目结构

![系统架构图](https://school-1258358792.cos.ap-beijing.myqcloud.com/system/%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg)

> Theseed系统由三个子系统组成。分别为后台子系统，课程推荐子系统，用户客户端子系统。
>图中字母 A 代表后台子系统；字母 B 代表课程推荐子系统；字母 C 代表用户客户端子系统；
>数字 1 代表学生管理；数字 2 代表教师管理；数字 3 代表教学管理；数字 4 代表权限管理；数字 5 代表个人 信息；数字 6 代表课程学习；数字 7 代表信息查询；数字 8 代表回答问题；数字 9 代表发布通知；数字 10 代表学生考勤。  

3.2 数据库设计

![database](https://school-1258358792.cos.ap-beijing.myqcloud.com/system/ER.jpg)

> 通过需求分析得 出，学生，教师，课程，专业，学院，通知等实体以及对应属性。根据实体之间的依赖关系，设计系统 概念模型，遵循了完整性约束，三范式原则。

- t_stu_user  学生基本信息表

- t_teacher_user  教师基本信息表

- t_college  学院信息表

- t_major  专业信息表

- t_class  班级信息表

- t_course_classify  课程类别表

- t_curriculum  课程表

- t_course_section 课程章/节表

- t_course_comment  课程评论&答疑

- t_user_course_section  用户学习章节表
- **. . . . . .**



## 4 上手指南

4.1更改配置文件

1. 修改配置文件application.yml，数据库相关配置
2. MySQL导入sql文件
3. 启动项目并打开浏览器访问可访问后台管理系统  输入网址： http://localhost:端口号/admin  用户名：admin 密码：admin。

4.2配置小程序

1. 微信公众平台下载安装微信web开发者工具
2. 导入seed小程序项目源码。编译运行即可。（注意：新用户通过授权后没有相关课程推荐。）

## 后端涉及作者
 
* **KAI** - *软件后台管理系统设计，数据传输以及前后台交互* - [Kai-Maker1](https://github.com/Kai-Maker1)
* **AOAO** - *微信小程序后台设计，数据传输以及前后台交互* - [aoao-github](https://github.com/aoao-github)
* **Luo** - *软件创意以及API设计* - [aoao-github](https://github.com/1025946443)
* **Lee** - *软件原型图设计，模型图设计以及UI设计* - [Lee](https://github.com/MiracleYee/Lee)
 
See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.
 
## 版权声明
 
该作品已经申请软件著作权且作为参赛作品，仅供学习交流使用。

## 联系微信
<img src="https://github.com/Kai-Maker1/Theseed-Front-end/blob/master/images2/971583505208_.pic.jpg" width=24% height=25%>



