## TIL 2022 10 21

### Redux

당장 투두리스트 형식의 간단한 토이 프로젝트를 진행해 보면서도 props 전송 시 무관한 자식 컴포넌트를 지난다는 것을 알 수 있는데,

프로젝트 규모가 커진다는 거창한 말도 필요 없이 당장 다음 단계 사이즈만 가도 불편함을 느낄 것 같았고,

금방 전역 상태 관리의 중요성을 깨닫고 일찍이 어제 오늘 그리고 내일은 Redux를 학습하는 데 시간을 투자하고 있습니다.(당연히 알아야 할 개념들)

전역 상태 관리에는 Context API부터 redux와 recoil 등의 라이브러리까지 다양한 방법이 존재하는데요.

세상 모든 일 장단점이 있기 때문에, 이중 커뮤니티와 스터디원, 그 외 레퍼런스 등 무의식적으로 친숙하게 자리 잡은 redux를 먼저 접하게 되었습니다.

### Redux 키워드
<code>action</code> <code>action creator</code> <code>initialState</code> <code>reducer</code> <code>store</code> <code>dispatch</code> <code>subscribe</code>

#### Action(액션)

상태에 어떠한 변화가 필요할 때 이름 그대로 액션을 발생시킵니다.

#### Action type(액션 타입 정의)

```js
// 액션 타입은 대문자로 작성합니다.

const INCREASE = 'INCREASE';
const DECREASE = 'DECREASE';
```

#### Action Creator(액션 생성 함수)

```js
// 이름 그대로 액션을 생성하는 함수입니다.

function increase() {
  return {
    type: INCREASE
  }
}

// 화살표 함수로도 작성이 가능합니다.

const decrease = () => {
  return {
    type: DECREASE,
    data // 액션 안에는 type 외에 추가적인 필드를 마음대로 작성이 가능합니다.
  }
}
```

#### initialState

```js
// redux에서 관리할 상태 정의

const initialState = {
  // 내용 작성
}
```

#### Reducer(리듀서)

```js
// reducer는 state와 action 두 가지 파라미터를 받아 옵니다.

function counter(state = initialState, action) {
  switch (action.type) {
    case 'INCREASE':
      return state + 1;
    case 'DECREASE':
      return state - 1;
    default:
      return state;
  }
}
```

#### store

#### dispatch

#### subscribe

### Redux 규칙

### 참고
[벨로퍼트 리덕스](https://react.vlpt.us/redux/)
