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
| 기능     | Method | URL       | Request             | Response | Status code |
|--------|--------|-----------|---------------------|-------|-------------|
| 일정 생성  | POST   | /schedule | [등록 요청](#등록 요청)     |       | 200: 정상등록   |
| 일정 조회  | GET    | /schedule | [조회 요청](#조회 요청)     | [조회 정보](#조회 정보) | 200: 정상조회   |
| 일정 수정  | PATCH  | /schedule | [수정 요청](#수정 요청)     |       | 200: 정상수정|
| 일정 삭제 | PUT    | /schedule | [삭제 요청](#삭제 요청)     |       | 200: 정상삭제 |                                                    

#### 등록 요청
```json 
{
   "works":        할일(TEXT),
   "writer":      작성자명(VARCHAR(10)),
   "password":    비밀번호(VARCHAR(20),
}
```


#### 조회 요청
```http request
// writer(optional):       VARCHAR(10)
// updatedAt(optional):    DATE(YYYY-MM-DD)
?writer=[작성자명]&updatedAt=[YYYY-MM-DD]
```


#### 조회 정보
```json
[
   { 
      "scheduleID":  식별번호(LONG), 
      "works":        할일(TEXT), 
      "writer":      작성자명(VARCHAR(10)), 
      "createdAt":   등록일(DATETIME), 
      "updatedAt":   수정일(DATETIME)
   },
   ...,
   {...}
]
```


#### 수정 요청
```json
{ 
   "password":          비밀번호(VARCHAR(20)), 
   "works(optional)":    할일(TEXT), 
   "writer(optional)":  작성자명(VARCHAR(10))
}
```

#### 삭제 요청
```json
{
   "scheduleID":  식별번호(ID), 
   "password":    비밀번호(VARCHAR(20))
}
```