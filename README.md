PLANK HELPER
======================
### 개요
집에서 플랭크를 할 때 스마트폰의 제조사 기본 스탑워치 어플을 통해 시간을 잽니다.<br>
하다보니 1분 넘게 하는데, 마냥 시계만 보면서 하는 게 지루해 인터넷도 보고 웹툰도 보게 됐습니다.<br>
하지만 다른 작업 중 시간이 얼마나 지났는지 편하게 알 수 없어 불편해 알림창을 통해 제어하고자 개발하게 됐습니다.<br>

----------------------
### 완료
- [x] NavigationDrawer 와 ViewPager를 통한 UI 구성
- [x] 스탑워치, 타이머의 실행, LAP, 종료 
- [x] 알림을 통해서도 스탑워치, 타이머 실행, LAP, 종료 가능
- [x] 앱의 상태와 알림 상태를 바인드 서비스, 액션을 통해 동기화 
- [x] 플랭크 기록과 그 기록의 LAP 기록을 데이터베이스에 저장
- [x] 통계 화면 틀 완성: 지속적인 추가/수정
- [x] 설정 화면 틀 완성: 지속적인 추가/수정

### 진행 중
- [ ] 플랭크: (최우선) 스탑워치, 타이머, 서비스, 알림 간 데이터 전송 관련 코드 최적화 20170605~
- [ ] 공통: UI 정리
- [ ] 공통: 앱 아이콘 추가
- [ ] 플랭크: 타이머가 완료되면 진동과 함께 알림 구현
- [ ] 플랭크: 각 플랭크가 종료될 때 저장을 묻는 프롬프트 구현 20170605~
- [ ] 통계: 달력에 플랭크 수행 날짜 강조
- [ ] 통계: 달력의 플랭크 수행한 날을 누르면 밑에 해당하는 날짜의 플랭크 기록 통계 표시
- [ ] 통계: 차트 옵션에 기간 설정 추가
- [ ] 통계: 차트를 통해 플랭크 기록 통계 표시
- [ ] 통계: 차트 위의 플랭크 기록을 누르면 상세 기록 통계 표시
- [ ] 기록: 기록 옵션에 기간 설정 추가
- [ ] 기록: AdvancedRecyclerView 를 통해 재구현
- [ ] 기록: 개별 기록의 밀어내기를 통한 삭제 구현
- [ ] 설정: 예약 시간에 알림 표시 실제 구현
- [ ] 설정: 타이머 종료 전 진동 실제 구현

### 진행 예정
- [ ] 플랭크 운동과 해당 앱에 대한 정보를 알려주는 스플래시 화면 추가
- [ ] 플랭크 운동에 대한 정보 추가
- [ ] 플랭크 완료 시 대략적인 소모 칼로리 표시 추가
- [ ] 구글 로그인을 통한 앱 데이터 백업/복구
----------------------
### 알려진 버그
- LAP 추가 시 바로 알림에 적용하기 위해 알림을 업데이트하지만, 이 때 Builder를 새로 생성하기 때문에 새로운 알림을 생성해 렉이 발생하는 문제. 현재 바로 알림을 업데이트 하지 않음으로 임시 대처. 코드 최적화를 통해 같이 해결 예정
----------------------
### 사용한 오픈소스 라이브러리 
각 라이선스는 현재 앱-설정-오픈소스 라이선스 에서 열람하실 수 있습니다.
- [ButterKnife](https://github.com/JakeWharton/butterknife)
- [MaterialViewPager](https://github.com/florent37/MaterialViewPager)
- [MaterialCalendarView](https://github.com/prolificinteractive/material-calendarview)
- [MaterialDialogs](https://github.com/afollestad/material-dialogs)
- [AdvancedRecyclerView](https://github.com/h6ah4i/android-advancedrecyclerview)
- [HelloChart](https://github.com/lecho/hellocharts-android)
----------------------
> Last updated: 2017.06.06<br>
> 이 프로젝트는 2017년 4월 15일부터 개발됐습니다.
