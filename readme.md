## 打包项目, 生成镜像
mvn clean package

## 运行 redis
docker run --name redis-server -p 6379:6379 -d redis

## 运行 redis-demo
docker run --name redis-demo -p 8080:8080 -d --link redis-server saysky/redis-demo

