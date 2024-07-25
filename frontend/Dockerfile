FROM 	node:current-slim

WORKDIR /usr/app/

# pnpm 설치
RUN		apt-get update \
		&& npm install -g pnpm

# 패키지 설치
COPY	package.json .
RUN 	pnpm install

# 소스코드 복사 및 빌드
COPY	. .
RUN		pnpm run build


# 프로덕션 서버 실행
CMD    ["pnpm", "run", "start"]

# 컨테이너 디버깅
# CMD    ["sleep", "infinity"]

# 개발서버 실행
# CMD    ["pnpm", "run", "dev"]