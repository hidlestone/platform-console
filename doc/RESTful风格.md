# RESTful风格.md

## 一、简介
 一种软件架构风格、设计风格，而不是标准，只是提供了一组设计原则和约束条件。它主要用于客户端和服务器交互类的软件。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。
 
### 1.1、URL定义
资源：互联网所有的事物都可以被抽象为资源   
资源操作：使用POST、DELETE、PUT、GET，使用不同方法对资源进行操作。   
分别对应：添加、 删除、修改、查询。   

### 1.2、传统方式操作资源 
http://127.0.0.1/item/queryUser.action?id=1         查询,GET   
http://127.0.0.1/item/saveUser.action               新增,POST   
http://127.0.0.1/item/updateUser.action             更新,POST   
http://127.0.0.1/item/deleteUser.action?id=1        删除,GET或POST  

### 1.3、请求方式
可以通过 GET、 POST、 PUT、 PATCH、 DELETE 等方式对服务端的资源进行操作。
- GET 用于查询资源
- POST 用于创建资源
- PUT 用于更新服务端的资源的全部信息
- PATCH 用于更新服务端的资源的部分信息
- DELETE 用于删除服务端的资源

### 1.4、使用RESTful操作资源 
- 【GET】 /users              # 查询用户信息列表
- 【GET】 /users/1001         # 查看某个用户信息
- 【POST】 /users             # 新建用户信息
- 【PUT】 /users/1001         # 更新用户信息(全部字段)
- 【PATCH】 /users/1001       # 更新用户信息(部分字段)
- 【DELETE】 /users/1001      # 删除用户信息
















https://www.ruanyifeng.com/blog/2011/09/restful.html  
https://blog.csdn.net/qq_27026603/article/details/82012277  
