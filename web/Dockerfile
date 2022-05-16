FROM node:17

WORKDIR /app/web

ENV PATH /app/web/node_modules/.bin:$PATH

COPY package.json /app/web
COPY package-lock.json /app/web
RUN npm install

COPY . /app/web

EXPOSE 3000

ENTRYPOINT ["npm", "start"]