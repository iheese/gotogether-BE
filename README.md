
## 🤝 기업 연계 프로젝트
### Go Together
좋은 사람들과의 잊을 수 없는 여행

<a href="https://iheese.github.io/project/2022/10/20/gotogether/">개인 프로젝트 회고록</a>

<br>

## 📌 프로젝트 개요
#### 프로젝트 기간
- 2022 . 09 . 06 ~ 2022 . 10 . 14

#### 프로젝트 목표
- 고투게더 여행 사이트, 관리자 페이지 설계 및 제작

#### 프로젝트 히스토리
<a href="https://www.notion.so/BE-FE2-UXUI3-_5-68fbfff1ac584f1485272b1d2a372763
">노션</a>

<a href="https://github.com/gotogether-s/gotogether-s
">FE github</a>

<a href="https://github.com/gotogether-s/gotogether-s-admin
">FE Admin github</a>

<a href="https://github.com/gotogether-s/gotogether-s-BE
">BE github</a>

<a href="https://gotogether-s-admin.vercel.app/signin">관리자 사이트</a>

<a href="https://gotogether-s.vercel.app">서비스 사이트</a>

(추후 서버 유지 비용으로 인해 연결이 불가할 수 있습니다.)

## 🛠 기술 스택

- Front
    - Next.js
    - TypeScript
    - Router from Next.js
    - Redux Tool Kit 
    - getServerSideProps, Axios
    - CSS Module
    - Scss
    - MUI

- Back
    - Java 17
    - Spring Boot , JPA
    - Spring Security, JWT
    - Gradle
    - MySQL
    - Redis
    - QueryDSL
    - AWS EC2 , ROUTE 53, RDS, S3
    - Jenkins
    - Docker

<br>

## 🙋🏻 팀원 소개

### UX/UI

| 조서우  | 송아름 |
|--------|-------|

### Frontend

| 조현아                                    | 변승훈                                             |
|----------------------------------------|-------------------------------------------------|
| [@hyeonahc](https://github.com/hyeonahc) | [@SeungHun6450](https://github.com/SeungHun6450) |

### Backend

| 김현준                                    | 이현승                                       | 김대곤                                           | 진우림                        |                                
|------------------------------------------|-------------------------------------------- |-----------------------------------------------|--------------------------------| 
| [@khjun723](https://github.com/khjun723) | [@iheese](https://github.com/iheese) | [@bbyuggyu](https://github.com/bbyuggyu) | [@jinwoorim](https://github.com/jinwoorim) | 

<br>

## Backend 업무 분담

이현승 : 사용자, 큐레이션, 관리자 기능, AWS S3

김현준 : 상품 조회(상세, 추천, 카테고리별), 검색 기능

진우림 : 예약 및 찜 기능

김대곤 : 서버 배포(AWS EC2, RDS, ROUTE 53), CI/CD, Dokcer

<br>

## :left_speech_bubble: 프로젝트 내용

![관리자](https://user-images.githubusercontent.com/88040158/196174137-105870cc-1243-4dbc-be4c-9160fd96e082.png)

- 관리자 권한이 있는 계정으로 로그인 후 상품 추가 기능 페이지로 넘어오게 됩니다. 
- 각 칸에 모든 데이터를 작성해야 상품 등록이 완료됩니다.
- 여행 상품 상세 내용 작성에는 SlateJS Editor가 사용되었습니다.

<br>

![회원가입 로그인](https://user-images.githubusercontent.com/88040158/196174165-85164c74-507f-44fe-9ef6-523ab760401a.png)

- 회원 가입과 로그인 페이지입니다.
- 로그인시 JWT 토큰(Access Token, Refresh Token)이 발행됩니다. 서버와 클라이언트가 무상태성을 유지하여 데이터를 안전하게 수송신하게 됩니다.
- 토큰이 발행되면 Refresh Token은 인메모리 데이터 저장소인 Redis에 저장되어 토큰 재발행을 빠르게 돕습니다.

<br>

![큐레이션](https://user-images.githubusercontent.com/88040158/196174161-01cf757c-168b-4aec-839f-8ef5e37d630e.png)

![설문완료후](https://user-images.githubusercontent.com/88040158/196174152-81ca783d-5f22-4143-8f67-3e998b3e36cb.png)

- 추천 상품을 위해 유저에게 큐레이션을 실시합니다.
- 로그인 상태의 회원은 큐레이션 데이터가 바로 연결되어 저장되며, 비회원은 서버의 세션에 일시적으로 저장되어 추천 상품을 띄어줍니다. 

<br>

![상세페이지](https://user-images.githubusercontent.com/88040158/196174145-f0f1f57d-d8dd-49c0-894a-d389ab6d147a.png)

- 상세 페이지에서는 여행 상품에 대한 설명을 자세히 볼 수 있습니다.

<br>

![찜하기](https://user-images.githubusercontent.com/88040158/196174159-902cd099-078c-43aa-b160-a2e7e9267e55.png)

- 상세페이지에서 상품을 찜하고 찜 목록을 확인할 수 있습니다. 

<br>

![예약 및 결제](https://user-images.githubusercontent.com/88040158/196174155-ff770ea3-6ea2-4922-9437-07127ce0ae04.png)

- 여행 상품을 예약하고 결제할 수 있습니다.
- 예약자 정보를 작성하고 옵션을 선택 후 결제를 진행할 수 있습니다. 

