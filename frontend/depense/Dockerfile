FROM node:10.14.1

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json /app/package.json
RUN npm install

COPY . /app

EXPOSE 4200
EXPOSE 4201

CMD npm start -- --host 0.0.0.0
