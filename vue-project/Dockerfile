FROM node:8.11.3-alpine

WORKDIR /app

RUN apk update && \
    npm install && \
    npm install -g npm && \
    npm install -g @vue/cli

# TODO:vue-projectの作成が対話型であるのでDockerfile上で出来ないので要調査
#RUN vue create vue-project && \
#    cd vue-project && \
#    npm run serve
