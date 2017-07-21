Law And Tax demand system
======
##项目使用的技术
------------
1.springboot作为整个后台框架

2.shiro作权限认证

3.spring jpa持久化层

4.beetl模板引擎，后期添加

###安装
----------
1.安装jdk、mysql服务器；

2.新建数据库（任意命名），运行sql文件创建地区表；

3.项目修改配置文件，打jar包运行（运行后会自动建立系统需要的其他表结构）；

4.浏览器、app访问host:port测试；

###接口文档使用说明
--------
前端只需查看com.hidear.law.modular.controller中的api说明；

访问路径是 类注解+方法 注解；

参数名和对应类的属性名相同；
