# platform-console
platform-console

## 一、项目结构
```
platform-console
    platform-console-control-parent     操作台control父工程
        console-control-console         操作台control
    platform-console-service-parent     操作台service父工程
        console-api-console             对外的API包
        console-service-console         操作台service
```

/save
/delete
/update
/get
/list


```yaml
spring:
  main:
    allow-bean-definition-overriding: true
  servlet:
    multipart:
      max-file-size: 100MB
      max-request-size: 100MB
      enabled: false
     
  codec:
    max-in-memory-size: 20MB
  jpa:
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
    show-sql: true
    open-in-view: false
    hibernate:
      ddl-auto: none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
  datasource:
    username: root
    password: srmdbwms
    jdbc-url: jdbc:mysql://10.10.20.40:3306/platform
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: ${spring.datasource.jdbc-url}?user=${spring.datasource.username}&password=${spring.datasource.password}&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false
  cloud:
    config:
      override-none: true
    nacos:
      discovery:
        server-addr: 10.10.20.40
        namespace: wms-dev
        group: DEFAULT_GROUP
        service: ${spring.application.name}
  elasticsearch:
    rest:
      uris: http://10.10.20.143:9200      
  redis:
    host: 10.10.20.40
    port: 6379
    password: redis888
    database: 14
    timeout: 60s
    lettuce:
      pool:
        max-active: -1
        max-idle: 15
        max-wait: -1s
        min-idle: 5
  srment:
    datasource:
      username: platform
      password: platform2040
      jdbc-url: jdbc:mysql://10.10.20.40:3306/platform
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: ${spring.srment.datasource.jdbc-url}?user=${spring.srment.datasource.username}&password=${spring.srment.datasource.password}&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8
  flyway:
    enabled: false
    primary:
      location: db/migration/${spring.datasource.username}
      table: md_schema_history
    secondary:
      location: db/migration/${spring.srment.datasource.username}
      table: md_schema_history
  sleuth:
    sampler:
      probability: 1 # 收集数据百分比，必填，0.1为（10%）、1.0为（100%）
#启用feign client的断路器
  zipkin:
    base-url: http://10.10.20.24:9411 # 服务端地址，数据传输方式为web时必填
    sender:
      type: rabbit # 数据传输方式（web、rabbit），web 表示以HTTP报文的形式向服务端发送数据，rabbit 表示以rabbitMq的形式向服务端发送数据
    rabbitmq:
      queue: zipkin # 队列名称，数据传输方式为rabbit时必填
#tomcat配置
server:
  compression:
    enabled: true
  max-http-header-size: 102400
  error:
    include-stacktrace: on-trace-param

#平台配置
platform:
  mobileplatform:
    version: ""
  zeebeConfig:
    gateWay: 10.10.20.40:26500
  version: 
  console:
    version: 
  license:
    projectNo: huiju.srm.ent
  amqp:
    route-key-suffix:  #非本机开发环境建议留空
    connection-factory:
      host: 10.10.20.40
      username: guest
      password: guest
      virtualhost: /
      automaticRecoveryEnabled: true
      topologyRecoveryEnabled: true
  i18n: 
    fields: ["companyName", "bankName", "contractTypeName", "currencyName", "groupName", "materialGroupName","materialTypeName", "paymentTermName", "paymentTypeName", "plantName", "purchasingGroupName", "purchasingOrgName","stockLocationName", "taxRateName", "tradeTermName", "unitName", "vendorTypeName", "materialName", "clientName","itemName","warehouseName", "departmentName", "documentTypeName", "noticeTypeName", "sourceBillTypeName","tradeTermName", "receiveGroupName" , "printerName", "paymentTermName", "paymentName","saleOrgName","distChanName","prodGroupName","shippingPointName","customerTypeName","cstAcctGroupName","exceptionName","accountGroupName"]

#spring boot监控
management:
  endpoint:
    health:
      show-details: always
  endpoints:
    web:
      exposure:
        include: ["*"]

  share-security-context: true
  command:
    default:
      execution:
        timeout:
          enabled: true
        isolation:
          thread:

# ribbon
ribbon:
  ConnectTimeout: 10000
  ReadTimeout: 30000
  OkToRetryOnAllOperations: false
  MaxAutoRetries: 0
  MaxAutoRetriesNextServer: 0

hystrix: 
  command: 
    default: 
      execution:  
        isolation:  
          thread:   
            timeoutInMilliseconds: 60000

ui:
  jar:
    initdata: false

##------------------------------------------以下配置待定----------------------------------------------------##
#srm
service:
  version: v1

dc:
  service:
    name: dc-deploy-
    version: v1
cmn:
  service:
    system:
      name: cmn-deploy-
      version: v1

cmc:
  service:
    name: cmc-service-
    version: v1
  control:
    name: cmc
    version: ""
report:
  service:
    name: report
    version: ""
srm:
  service:
    sourcing:
      name: srm-smd-deploy-
      version: v1
    contract:
      name: srm-ctc-deploy-
      version: v1
    auction:
      name: srm-auc-deploy-
      version: v1
    inquiry:
      name: srm-rfq-deploy-
      version: v1
    purchasing:
      name: srm-pec-deploy-
      version: v1
    vendor:
      name: srm-smc-deploy-
      version: v1
    finance:
      name: srm-fi-deploy-
      version: v1
    bidding:
      name: srm-bid-deploy-
      version: v1
    csm:
      name: srm-csm-deploy-
      version: v1

#wms
wms:
  service:
    inventory:
      name: wms-im-deploy-
      version: v1
    warehouse:
      name: wms-wm-deploy-
      version: v1
qsc:
  service: 
    op:
      name: qsc-op-deploy-
      version: v1
      
##md-service
MDM: md-service-v1
md:
  service:
    name: md-mdm-deploy-
    version: v1
    business:
      name: ${md.service.name}
      version: ${md.service.version}
    generic:
      name: ${md.service.name}
      version: ${md.service.version}
    org:
      name: md-org-deploy-
      version: v1
    #电子签章
    signature:
      name: ${md.service.name}
      version: ${md.service.version}

# mes生产前缀
#ime:
#  quality: ime-service-quality/quality
ime:
  quality: ime-quality/quality
  equipment: ime-equip/equip
  prodexec: ime-prodexec/prodexec
  prepare: ime-prepare/prepare
  abnl: ime-abnl/abnl
```