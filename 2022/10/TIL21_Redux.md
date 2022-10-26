## TIL 2022 10 21

### Redux

당장 투두리스트 형식의 간단한 토이 프로젝트를 진행해 보면서도 props 전송 시 무관한 자식 컴포넌트를 지난다는 것을 알 수 있는데, 프로젝트 규모가 커진다는 거창한 말도 필요 없이 당장 다음 단계 사이즈만 가도 불편함을 느낄 것 같았습니다.

일찍이 전역 상태 관리의 중요성을 깨닫고 최근에는 Redux를 학습하는 데 시간을 투자하고 있는데요.(당연히 알아야 할 개념들) 전역 상태 관리에는 Context API부터 redux와 recoil 등의 라이브러리까지 다양한 방법이 존재하지만, 이중 커뮤니티와 스터디원, 그 외 구글링 등에서 무의식적으로 친숙하게 자리 잡은 redux를 먼저 접하게 되었습니다.

### Redux 규칙

#### 하나의 애플리케이션 안에는 하나의 스토어가 존재합니다.

여러 개의 스토어를 사용하는 것은 가능하나 권장하지 않습니다. 특정 업데이트가 빈번히 일어나거나, 애플리케이션의 특정 부분을 완전히 분리시킬 때는 여러 개를 만들 수는 있는데요. 이렇게 되면 개발 도구를 활용하지 못 하게 됩니다.

#### 상태는 읽기 전용입니다.

리액트는 state 업데이트 시 <code>setState</code>를 사용하고, 배열 업데이트 시 배열에 <code>push</code>가 아닌, <code>concat</code>를 사용, 객체 업데이트 시 spread 연산자 <code>(...)</code> 사용 등 원본은 건드리지 않는 형태입니다. 리덕스도 마찬가지로, <code>불변성</code>를 유지해야 하는데요. 불변성을 유지해야 하는 이유는 내부적으로 데이터가 변경되는 것을 감지해 <code>shallow equality</code> 검사를 진행하기 때문입니다.

> shallow equality는 무엇인가요?

얕은 동등성 검사라고 부르며 서로 다른 객체(a, b)인 경우 단순하게 a === b만 체크해도 다른지 알아내는 검사입니다. 객체의 변화를 감지할 때 객체의 깊은 곳까지 검사<code>deep equality</code>하지 않아 좋은 성능을 유지할 수 있습니다.

#### Reducer는 순수한 함수여야 합니다.

- 리듀서 함수는 <code>이전 상태</code>와, <code>액션 객체</code>를 파라미터로 밥습니다.
- 이전 상태는 건드리지 않고, 변화를 일으킨 새로운 상태 객체를 반환합니다.
- 똑같은 파라미터로 호출된 리듀서는 **언제나 똑같은 결과값을 반환**해야 합니다.
  
즉, 동일한 input은 동일한 output이 존재해야 합니다. 만약 <code>new Date()</code> <code>Math.Random()</code>을 사용한 랜덤한 숫자 생성 등 리듀스 함수에서는 순수하지 않은 작업으로써 리듀서 함수 바깥에서 처리를 해 줘야 합니다. 그리고 이런 것들을 하기 위해 <code>리덕스 미들웨어</code>를 사용하며 이는 다음에 다루도록 하겠습니다.

### Redux 키워드
<code>action</code> <code>action creator</code> <code>initialState</code> <code>reducer</code> <code>store</code> <code>dispatch</code> <code>subscribe</code>

#### Action(액션)

상태에 어떠한 변화가 필요할 때 이름 그대로 액션을 발생시킵니다.

#### Action type(액션 타입 정의)

액션 타입은 대문자로 작성합니다. 액션 타입을 꼭 상수로 선언하지 않아도 되지만, 제가 참고한 사이트에서는, 액션 타입이 변경될 경우 관리를 편하게 하기 위해 선언한 것으로 보입니다.

```js
const INCREASE = 'INCREASE';
const DECREASE = 'DECREASE';
```

뿐만 아니라 다음과 같은 기대 효과도 보입니다.

1. 이름 짓기가 편리합니다.
2. 기존에 생성된 타입의 목록을 PR을 통해 모든 팀원에게 공유가 가능합니다.

#### Action Creator(액션 생성 함수)

이름 그대로 액션을 생성하는 함수입니다.

```js
function increase() {
  return {
    type: INCREASE
  }
}

// 화살표 함수로도 작성이 가능합니다.
const decrease = data => ({
  type: DECREASE,
  data // 액션 안에는 type 외에 추가적인 필드를 마음대로 작성이 가능합니다.
})
```

#### initialState

redux에서 관리할 상태를 정의합니다.

```js
const initialState = {
  // 내용 작성
}
```

#### Reducer(리듀서)

reducer는 state와 action 두 가지 파라미터를 받아 옵니다.

```js
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

리덕스에서는 <code>한 애플리케이션</code> 당 <code> 하나의 스토어</code>를 만듭니다.

```js
// src/index.js

import { createStore } from 'redux';
import { Provider } from 'react-redux';

const store = createStore(rootReducer); // 스토어를 만듭니다.

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>
);
```

현재 redux 버전에서는 ~~createStore~~에 이처럼 취소선이 그어집니다. <code>@reduxjs/tooklit</code>의 사용을 권장하기 위한 유도라고 하는데요. 이를 사용하기 위해선 redux v4.2.0 버전으로 버전을 낮추는 방법이 있습니다. 가장 최신 버전으로 학습하지 않아 레거시 코드가 존재할 수 있습니다.

#### dispatch

store의 <code>내장 함수</code> 중 하나이며, 디스패치는 액션을 발생시키는 역할을 수행합니다. 디스패치라는 함수는 액션을 파라미터로 전달합니다. <code>dispatch(action)</code>

#### subscribe

store의 <code>내자 함수</code> 중 하나이며, subscribe은 함수 형태의 값을 파라미터로 받아 옵니다.

### 참고
[벨로퍼트 님 블로그](https://react.vlpt.us/redux/)
