# From java image, version : 8
#指定镜像，这里用网易云仓库的java8镜像
FROM hub.c.163.com/library/java:8-jre

# 挂载test-docker目录
VOLUME /tmp

# COPY or ADD to image
COPY redis-demo-0.0.1-SNAPSHOT.jar app.jar

RUN bash -c "touch /app.jar"
#默认8080端口，我的server.port=8080
#指定项目暴露的端口号，与项目配置一样,即容器配置的暴露端口
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]