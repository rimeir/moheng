FROM node:current-slim

WORKDIR /usr/app/

RUN     apt-get update \
        && npm install -g pnpm

COPY	. .

RUN     pnpm install
RUN     pnpm run build

# 디버깅용
# CMD    ["sleep", "infinity"]

# 개발서버 실행
# CMD    ["pnpm", "run", "dev"]

# 프로덕션 서버 실행
CMD    ["pnpm", "run", "start"]