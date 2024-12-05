## 일정 관리 앱 

### 커밋 컨벤션
아래와 같은 형식을 따라 커밋하세요.

<b><타입>: <제목>

<본문>

<꼬리말><b>
1. 커밋 타입
   🆕: 새 기능 추가

   🔧: 기능 수정 & 개선

   🐛: 버그 수정

   📝: 문서 수정

   🎨: 코드 스타일 변경(들여쓰기 등)

   🏭: 코드 리팩토링(기능 변경 없이 구조만 개선한 경우)

   📁: 파일 구조 변경

2. 제목
   이 커밋에 대한 간략한 설명

예) Main 클래스 리팩토링

3. 본문(선택 사항)
   이 커밋에 대한 추가 설명

4. 꼬리말(선택 사항)
   기타 참고사항 기술


### ERD
추가 예정

### API 명세서
| 기능     | Method | URL                    | Request                     | Response                    | Status code |
|--------|--------|------------------------|-----------------------------|-----------------------------|-------------|
| 일정 생성  | POST   | /schedule              | [일정 등록 요청](#일정 등록 요청)       | [일정 등록 결과](#일정 등록 결과)       | 200: 정상등록   |
| 일정 조회  | GET    | /schedule              | [일정 조회 요청](#일정 조회 요청)       | [일정 조회 정보](#일정 조회 정보)       | 200: 정상조회   |
| 단일 일정 조회 | GET | /schedule/{scheduleID} | [단일 일정 조회 요청](#단일 일정 조회 요청) | [단일 일정 조회 정보](#단일 일정 조회 정보) | 200: 정상조회 |
| 일정 수정  | PATCH  | /schedule              | [일정 수정 요청](#일정수정 요청)        | [일정 수정 결과](#일정 수정 결과)       | 200: 정상수정|
| 일정 삭제 | PUT    | /schedule              | [일정 삭제 요청](#일정 삭제 요청)       | [일정 삭제 결과](#일정 삭제 결과)       | 200: 정상삭제 |                                                    

| 기능        | Method | URL                    | Request             | Response              | Status code |
|-----------|--------|------------------------|---------------------|-----------------------|-------------|
| 작성자 생성    | POST | /writer | [작성자 등록 요청](#작성자 등록 요청) | [작성자 등록 결과](#작성자 등록 결과) | 200: 정상등록
| 단일 작성자 조회 | GET | /writer/{writerID| | [단일 작성자 조회 요청](#단일 작성자 조회 요청) | [단일 작성자 조회 정보](#단일 작성자 조회 정보) | 200: 정상등록 |

#### 일정 등록 요청
```json 
{
   "works":        할일(TEXT),
   "writer":      작성자번호(INT),
   "password":    비밀번호(VARCHAR(20),
}
```

#### 일정 등록 결과

```json
{
   "message": 등록 결과(STRING)
}
```

#### 일정 조회 요청
```http request
// writer(optional):       INT
// updatedAt(optional):    DATE(YYYY-MM-DD)
?writer=[작성자번호]&updatedAt=[YYYY-MM-DD]
```

#### 일정 조회 정보
```json
[
   { 
      "scheduleID":  식별번호(INT), 
      "works":        할일(TEXT), 
      "writer":      작성자번호(INT), 
      "createdAt":   등록일(DATETIME), 
      "updatedAt":   수정일(DATETIME)
   },
   ...,
   {...}
]
```

#### 단일 일정 조회 요청
```http request
// scheduleID:  INT
/schedule/{{scheduleID}}
```

#### 단일 일정 조회 정보
```json
{
   "scheduleID":  식별번호(INT),
   "works":        할일(TEXT),
   "writer":      작성자번호(INT),
   "createdAt":   등록일(DATETIME),
   "updatedAt":   수정일(DATETIME)
}
```

#### 일정 수정 요청
```json
{ 
   "password":          비밀번호(VARCHAR(20)), 
   "works(optional)":    할일(TEXT), 
   "writer(optional)":  작성자번호(INT)
}
```

#### 일정 수정 결과
```json
{
   "message": 등록 결과(STRING)
}
```

#### 일정 삭제 요청
```json
{
   "scheduleID":  식별번호(ID), 
   "password":    비밀번호(VARCHAR(20))
}
```

#### 일정 삭제 결과
```json
{
   "message": 등록 결과(STRING)
}
```

#### 작성자 등록 요청
```json
{
   "writerName": 작성자 이름(VARCHAR(15))
   "email": 이메일(VARCHAR(75))
}
```

#### 작성자 등록 결과
```json
{
   "message": 등록 결과(STRING)
}
```

#### 단일 작성자 조회 요청
```http request
// writerID: 작성자 번호(INT)
/writer/{writerID}
```

#### 단일 작성자 조회 정보
```json
{
   "writerID": 작성자 번호(INT),
   "writerName": 작성자 이름(VARCHAR(15),
   "email": 이메일(VARCHAR(75)),
   "createdAt": 등록일(DATETIME),
   "updatedAt": 수정일(DATETIME)
}
```