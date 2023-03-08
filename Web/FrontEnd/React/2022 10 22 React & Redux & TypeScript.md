# Counter App

## 데모 영상

<img src='https://user-images.githubusercontent.com/85447054/197348101-5fb48b70-4556-4e7b-9773-f16ea67702c6.gif' width='600' >

## 작성 코드

```js
// src/modules/counter.ts

// action
// as const를 지정해 줌으로써, 액션 객체에서 action.type을 만들 때
// string이 아닌, 실제 문자열 값으로 추론 되게끔 해 줍니다.
const INCREASE = 'counter/INCEASE' as const;
const DECREASE = 'counter/DECREASE' as const;
const INCREASE_BY = 'counter/INCREASE_BY' as const;

// action 생성 함수
export const increase = () => ({
  type: INCREASE
})
export const decrease = () => ({
  type: DECREASE
})
export const increaseBy = (diff: number) => ({
  type: INCREASE_BY,
  payload: diff
})

// action과 state의 type(typescript)
type CounterAction =
  | ReturnType<typeof increase>
  | ReturnType<typeof decrease>
  | ReturnType<typeof increaseBy>;

type CounterState = {
  count: number;
};

// initial State
const initialState: CounterState = {
  count: 0
};

// reducer
function counter(
  state: CounterState = initialState,
  action: CounterAction):CounterState {
    switch(action.type){
      case INCREASE:
        return {
          count: state.count + 1
        }

      case DECREASE:
        return {
          count: state.count - 1
        }

      case INCREASE_BY:
        return {
          count: state.count + action.payload
        }

      default:
        return state
    }
}

export default counter;
```

```js
// src/modules/index.ts

import { combineReducers } from "redux"; // root Reducer
import counter from "./counter"; // counter module

const rootReducer = combineReducers({
  counter
  // 추후 module 개발 시 계속 추가
});

export default rootReducer;

// CounterContainer에서 사용 위해 export
export type RootState = ReturnType<typeof rootReducer>;
```

```js
// src/index.tsx

import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createStore } from 'redux'; // createStore
import { Provider } from 'react-redux'; // Provider
import rootReducer from './modules'; // rootReducer

const store = createStore(rootReducer);

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <Provider store={store}>
    <React.StrictMode>
      <App />
    </React.StrictMode>
  </Provider>
);

...
```

```js
// src/components/Counter.tsx

import React from 'react';

type CounterProps = {
  count: number;
  onIncrease: () => void;
  onDecrease: () => void;
  onIncreaseBy: (diff: number) => void;
}

function Counter({ count, onIncrease, onDecrease, onIncreaseBy }: CounterProps) {
  return (
    <div>
      <h1>{count}</h1>
      <button onClick={onIncrease}>+1</button>
      <button onClick={onDecrease}>-1</button>
      <button onClick={() => onIncreaseBy(10)}>+10</button>
    </div>
  );
}

export default Counter;
```

```js
// src/containers/CounterContainer.tsx

import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../modules';
import { increase, decrease, increaseBy } from '../modules/counter';
import Counter from '../components/Counter';

const CounterContainer = () => {
  // 상태를 조회합니다.
  // 상태를 조회 할 때에는 state의 타입을 RootState 로 지정해 줘야 합니다.
  const count = useSelector((state: RootState) => state.counter.count);
  const dispatch = useDispatch(); // 디스패치 함수를 가져 옵니다.

  // action들을 dispatch 하는 함수입니다.
  const onIncrease = () => dispatch(increase());
  const onDecrease = () => dispatch(decrease());
  const onIncreaseBy = (diff: number) => dispatch(increaseBy(diff));

  return (
    <Counter
      count={count}
      onIncrease={onIncrease}
      onDecrease={onDecrease}
      onIncreaseBy={onIncreaseBy}
    />
  );
};

export default CounterContainer;
```

```js
// src/App.tsx

import React from 'react';
import CounterContainer from './containers/CounterContainer';

function App() {
  return (
    <div className="App">
      <CounterContainer /> {/* Component Container */}
    </div>
  );
}

export default App;
```

# 참고

https://react.vlpt.us/using-typescript/05-ts-redux.html