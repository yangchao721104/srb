
<a name="paths"></a>
## 资源

<a name="f861e730900677635dcac1d4c3bfc159"></a>
### 积分等级管理
Admin Integral Grade Controller


<a name="getbyidusingget"></a>
#### 根据id获取积分等级
```
GET /admin/core/integralGrade/get/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|数据id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[R](#r)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/admin/core/integralGrade/get/1
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="listallusingget"></a>
#### 积分等级列表
```
GET /admin/core/integralGrade/list
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[R](#r)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/admin/core/integralGrade/list
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="removebyidusingdelete"></a>
#### 根据id删除数据记录
```
DELETE /admin/core/integralGrade/remove/{id}
```


##### 说明
逻辑删除数据记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|数据id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[R](#r)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/admin/core/integralGrade/remove/100
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="saveusingput"></a>
#### 新增积分等级
```
PUT /admin/core/integralGrade/save
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**integralGrade**  <br>*必填*|积分等级对象|[IntegralGrade对象](#5fa22c167cb84f1c7a943bc9670829cd)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[R](#r)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/admin/core/integralGrade/save
```


###### 请求 body
```
json :
{
  "borrowAmount" : 0.0,
  "createTime" : "2022-07-11 15:00:00",
  "deleted" : true,
  "id" : 0,
  "integralEnd" : 0,
  "integralStart" : 0,
  "updateTime" : "2022-07-11 15:00:00"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="updatebyidusingpost"></a>
#### 更新积分等级
```
POST /admin/core/integralGrade/update
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**integralGrade**  <br>*必填*|积分等级对象|[IntegralGrade对象](#5fa22c167cb84f1c7a943bc9670829cd)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[R](#r)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/admin/core/integralGrade/update
```


###### 请求 body
```
json :
{
  "borrowAmount" : 0.0,
  "createTime" : "2022-07-11 15:00:00",
  "deleted" : true,
  "id" : 0,
  "integralEnd" : 0,
  "integralStart" : 0,
  "updateTime" : "2022-07-11 15:00:00"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```



