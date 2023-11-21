# 클디서 합동 세미나 - 모바일8조 [네이버페이]

## 🧸 Team

|                             박예준                             |                                                                현예진                                                                 |
| :----------------------------------------------------------: |:----------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/SOPT-33RD-APP-NAVERPAY/NaverPay-Server/assets/80024278/a5b6fe21-ee43-4442-95b8-f00654c3ba88" width="300"/> | <img src="https://github.com/SOPT-33RD-APP-NAVERPAY/NaverPay-Server/assets/80024278/f38b7a70-1bf3-48b6-ad8a-05a1deb165be" width="300"/> |
|              [jun02160](https://github.com/jun02160)               |                                             [eeddiinn](https://github.com/eeddiinn)



| 담당 역할              |   Role   |
|:-------------------|:--------:|
| 프로젝트 초기 세팅       |   현예진    |
| 배포                  |   박예준    |
| DB 구축 (RDS)         |   박예준    |
| ERD 설계              | 박예준, 현예진 |
| API 개발              | 박예준, 현예진 |


## 🛠️ 개발 환경

| 통합 개발 환경 | IntelliJ |
| --- | --- |
| Spring 버전 | 3.0.12 |
| 데이터베이스 | AWS RDS(MySQL) |
| 배포 | AWS EC2(Ubuntu) |
| Project 빌드 관리 도구 | Gradle |
| ERD 다이어그램 툴 | ERDCloud, MySQL Workbench |
| Java version | Java 17 |
| 패키지 구조 | 계층형 패키지 구조 |


### API 명세서

### 데이터베이스 ERD

![image](https://github.com/SOPT-33RD-APP-NAVERPAY/NaverPay-Server/assets/80024278/27797a30-a964-48e5-9db1-6dfaa3bbd44c)


# 👥 Backend Convention

## 브랜치 컨벤션

- [feat] : 기능 추가
- [fix] : 에러 수정, 버그 수정
- [refactor] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [modify] : 코드 수정 (기능의 변화가 있을 때)
- [chore] : gradle 세팅, 위의 것 이외에 거의 모든 것

### 브랜치 명 예시

`ex) feat/#issue번호-user-APi`

## 커밋 컨벤션

- ✅ `[CHORE]` : 동작에 영향 없는 코드 or 변경 없는 변경사항(주석 추가 등)
- ✨ `[FEAT]` : 새로운 기능 구현
- ➕ `[ADD]` : Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성
- 🔨 `[FIX]` : 버그, 오류 해결
- ⚰️ `[DEL]` : 쓸모없는 코드 삭제
- 📝 `[DOCS]` : README나 WIKI 등의 문서 수정
- ✏️ `[CORRECT]` : 주로 문법의 오류나 타입의 변경, 이름 변경시
- ⏪️ `[RENAME]` : 파일 이름 변경시
- ♻️ `[REFACTOR]` : 전면 수정
- 🔀 `[MERGE]`: 다른 브랜치와 병합

### 커밋 예시

`ex ) git commit -m "[FEAT] 회원가입 기능 완료 #이슈번호"`

## 이슈 컨벤션

- [FEAT] : 기능 추가
- [FIX] : 에러 수정, 버그 수정
- [CHORE] : gradle 세팅, 위의 것 이외에 거의 모든 것
- [DOCS] : README, 문서
- [REFACTOR] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [MODIFY] : 코드 수정 (기능의 변화가 있을 때)

***이슈/PR 생성 시 제목 형식은 위의 형식을 따를 것! → Assignees / Labels 선택**

## 코드 컨벤션

1. 기본적으로 네이밍은 **누구나 알 수 있는 쉬운 단어**를 선택한다.
    - 우리는 외국인이 아니다. 쓸데없이 어려운 고급 어휘를 피한다.
2. 변수는 CamelCase를 기본으로 한다.
    - userEmail, userCellPhone ...
3. URL, 파일명 등은 kebab-case를 사용한다.
    - /user-email-page ...
4. 패키지명은 단어가 달라지더라도 무조건 소문자를 사용한다.
    - frontend, useremail ...
5. ENUM이나 상수는 대문자로 네이밍한다.
    - NORMAL_STATUS ...
6. 함수명은 소문자로 시작하고 **동사**로 네이밍한다.
    - getUserId(), isNormal() ...
7. 클래스명은 **명사**로 작성하고 UpperCamelCase를 사용한다.
    - UserEmail, Address ...
8. 객체 이름을 함수 이름에 중복해서 넣지 않는다. (= 상위 이름을 하위 이름에 중복시키지 않는다.)
    - line.getLength() (O) / line.getLineLength() (X)
9. 컬렉션은 복수형을 사용하거나 컬렉션을 명시해준다.
    - List ids, Map<User, Int> userToIdMap ...
10. 이중적인 의미를 가지는 단어는 지양한다.
    - event, design ...
11. 의도가 드러난다면 되도록 짧은 이름을 선택한다.
    - retreiveUser() (X) / getUser() (O)
    - 단, 축약형을 선택하는 경우는 개발자의 의도가 명백히 전달되는 경우이다. 명백히 전달이 안된다면 축약형보다 서술형이 더 좋다.
12. 함수의 부수효과를 설명한다.
    - 함수는 한가지 동작만 수행하는 것이 좋지만, 때에 따라 부수 효과를 일으킬 수도 있다.
        
        ```
        fun getOrder() {
          if (order == null) {
              order = Order()
          }
        return order
        }
        ```
        
    - 위 함수는 단순히 order만 가져오는 것이 아니라, 없으면 생성해서 리턴한다.
    - 그러므로 getOrder() (X) / getOrCreateOrder() (O)
13. LocalDateTime -> xxxAt, LocalDate -> xxxDt로 네이밍
14. 객체를 조회하는 함수는 JPA Repository에서 findXxx 형식의 네이밍 쿼리메소드를 사용하므로 개발자가 작성하는 Service단에서는 되도록이면 getXxx를 사용하자.

[캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java/)
