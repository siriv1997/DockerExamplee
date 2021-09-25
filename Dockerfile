From node:13-alpine

ENV MONGO_DB_USRENAME=admin \
    MONGO_DB_PASSWORD=password

WORKDIR /app

COPY package.json /app
RUN npm install
COPY . /app
CMD node index.js
EXPOSE 3010
