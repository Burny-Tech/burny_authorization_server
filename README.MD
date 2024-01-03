6. 简单测试
1. 拼接url，访问授权接口
   http://127.0.0.1:8080/oauth2/authorize?client_id=messaging-client&response_type=code&scope=message.read&redirect_uri=https%3A%2F%2Fwww.baidu.com

2. 授权接口检测到未登录，重定向至登录页面


3. 输入AuthorizationConfig中配置的账号密码
   账号：admin, 密码：123456

4. 登录成功后跳转至授权确认页面
   登录成功跳转至第1步的授权接口，授权接口检测到用户未确认授权，跳转至授权确认页面



选择对应的scope并提交确认权限

5. 提交后重定向至第1步的授权接口
   授权接口生成code并重定向至第1步请求授权接口时携带的redirectUri地址，重定向时携带上参数code和state，我这里省略掉了state参数，重定向之后只会携带code参数；state用来防止CSRF攻击，正式请求需生成并携带state参数。

6. 用户确认授权后携带code跳转至redirectUri
   一般来说配置的回调地址都是客户端的接口，接口在接收到回调时根据code去换取accessToken，接下来我会用postman模拟客户端发起一个http请求去换取token 不知道为什么在手机浏览器上看回调至百度的图片在平台显示违规，这里放一张另一个回调地址的替代图片

7. 根据code换取AccessToken
   请求/oauth2/token接口

1. 设置Basic Auth
   之前客户端设置的认证方式是CLIENT_SECRET_BASIC，所以需将客户端信息添加至请求头



2. 添加表单数据，发起POST请求
   下列表单数据可添加至form-data也可添加至url params  参数中的code就是第6步回调时携带的code

注意：添加url params时redirect_uri参数要经过encodeURIComponent函数对回调地址进行编码



8. 参数解释
   markdown
   复制代码
1. client_id: 客户端的id
2. client_secret: 客户端秘钥
3. redirect_uri：申请授权成功后的回调地址
4. response_type：授权码模式固定参数code
5. code_verifier：一段随机字符串
6. code_challenge：根据指定的加密方式将code_verifier加密后得到的字符串
7. code_challenge_method：加密方式
8. scope：客户端申请的授权范围
9. state：跟随authCode原样返回，防止CSRF攻击
10. grant_type：指定获取token 的方式：
    1. refresh_token：刷新token
    2. authorization_code：根据授权码模式的授权码获取
    3. client_credentials：客户端模式获取
