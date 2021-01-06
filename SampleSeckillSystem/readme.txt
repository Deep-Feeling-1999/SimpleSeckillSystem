读取静态资源
默认是在resources根目录下可以有三个子文件夹存放
优先级从高到底为resource（子目录）->static->public

在源码中会优先检查是否有自定义的目录位置
//一般不会主动定义静态资源位置


变量${}
选择*{}
文本消息使用#{}
链接使用@{}

所有的HTML元素，都可以通过th:来使用thymeleaf来替代

<h3 th:each="u:${users}" th:text="${u}"></h3>

添加@Configuration可以成为配置类
然后实现WebMvcConfigurer则可以成为他的配置类



扩展springMVC

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/lll").setViewName("test");
    }
}

但是不能加上@EnableWebMvc，


在springboot中有非常多的配置类xxxConfiguration


thymeleaf使用链接
<link th:href="@{/css/signin.css}" rel="stylesheet">


扩展MVC部分看config包，实现国际化看index.html传参，然后通过区域解析器获取后创建区域对象

通过th:fragment=""指定重用代码块
<nav class="col-md-2 d-none d-md-block bg-light sidebar" th:fragment="sidbar">
thymeleaf用th:insert="~{}"插入
<div th:insert="~{dashboard::sidbar}"></div>

在spring-boot-starter-parent里找spring-boot-dependencies，点进去可以找到所有的默认依赖版本



