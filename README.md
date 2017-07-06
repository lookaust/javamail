# 实现思路

![实现思路](http://upload-images.jianshu.io/upload_images/1837782-e813e99da1edf488.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
# 准备工作
- 开启SMTP服务
在 QQ 邮箱里的 设置->账户里开启 SMTP 服务

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1837782-4dc640e233f489dc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 注意开启完之后，QQ 邮箱会生成一个授权码，在代码里连接邮箱使用这个授权码而不是原始的邮箱密码，这样可以避免使用明文密码。也可以使用明文密码，但是会有密码泄露的风险。（借用原作者的图吧，省的再截图）
**注**
这里的授权码先记下来，第4步要用到。
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1837782-4195a920b91a9851.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



# 程序结构

![程序结构](http://upload-images.jianshu.io/upload_images/1837782-07c36ef3801e0a2b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 实现步骤
- 1、 建数据库、表
- 2、 User类（实体类）
- 3、 UserDao类（与数据库交互）
- 4、 SendMailUtils类（发送邮件）
- 5、 UUIDUtils（生成随机字符串code）
- 6、 RegistServlet（注册账户）
- 7、 ActiveServlet（激活账户）
- 8、 index.jsp（输入界面）
- 9、 success.jsp（成功界面）

