#### 在web项目中使用spring容器


在 Web 项目中使用 Spring 框架，首先要解决在 web 层（这里指 Servlet）中获取到 Spring
容器的问题。只要在web 层获取到了 Spring 容器，便可从容器中获取到 Service 对象。



#### 实验步骤

1. 加入servlet依赖
    jsp依赖
    spring项目相关依赖【spring-mybatis】
    spring-web 依赖 【封装好了contextLoaderListener】
2. maven 创建web项目
3. 配置web.xml

    注册监听器 ContextLoaderListener
    指定 Spring  配置文件的位置<context-param>
    注册自定义的servlet.    
    
4. 引入spring-mybatis的代码


#### spring容器保存在哪合适？

######1. 每次请求创建一个applicationContext，不合适。


######2. 在web项目启动是创建WebApplicationContext，保存到servletContext对象中

    对于 Web 应用来说，ServletContext 对象是唯一的，一个 Web 应用，只有一个
    ServletContext 对象，该对象是在 Web 应用装载时初始化的。若将 Spring 容器的创建时机，
    放在 ServletContext 初始化时，就可以保证 Spring 容器的创建只会执行一次，也就保证了
    Spring 容器在整个应用中的唯一性。
    
    将创建好的 Spring 容器，以属性的形式放入到 ServletContext 的空间中，就
    保证了 Spring 容器的全局性。


#### servletContext对象

一个web项目都会有一个全局的ServletContext，每次都保存每个Servlet共享信息。

在servlet中可以通过 getServletContext()，获取该对象。

ServletContextListener监听ServletContext对象


#### ContextLoaderListener

Spring 为该监听器接口定义了一个实现类 ContextLoaderListener，完成了两个很重要的
工作：创建容器对象，并将容器对象放入到了ServletContext 的空间中


    public class ContextLoaderListener extends ContextLoader implements ServletContextListener {
        public ContextLoaderListener() {
        }
    
        public ContextLoaderListener(WebApplicationContext context) {
            super(context);
        }
    
        public void contextInitialized(ServletContextEvent event) {
            this.initWebApplicationContext(event.getServletContext());
        }
    
        public void contextDestroyed(ServletContextEvent event) {
            this.closeWebApplicationContext(event.getServletContext());
            ContextCleanupListener.cleanupAttributes(event.getServletContext());
        }
    }


#### 在servlet中获取WebApplicationContext容器

1）web项目使用spring容器。

    String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
    WebApplicationContext context = (WebApplicationContext) getServletContext().getAttribute(attr);

2）通过工具类WebApplicationContextUtils

    WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(getServletContext());




























