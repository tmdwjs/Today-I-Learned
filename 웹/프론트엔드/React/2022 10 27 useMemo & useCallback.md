# useMemo vs useCallback

## 리렌더링

리액트에서 리렌더링이 일어나는 경우는 다음과 같습니다.

- 자신의 state가 변경되었을 때
- 부모 컴포넌트로부터 전달 받은 props가 변경될 때
- 부모 컴포넌트가 리렌더링 될 때

```js
// App.js의 자식 컴포넌트 Button.js

function Button(){
  return(
    <>
      <button> Click </button>
    <>
  )
}

export default Button;
```

리액트에서는 이처럼 항상 같은 값을 return 하는 컴포넌트도 부모 컴포넌트가 리렌더링 되면서 같이 불필요한 리렌더링이 일어나게 됩니다. 그리고 이러한 리렌더링은 <code>React.memo</code>를 사용하여 불필요한 리렌더링을 막을 수 있습니다.

# React.memo

React.memo는 컴포넌트를 <code>메모이제이션</code>해 줍니다. 부모 컴포넌트로 넘겨 받는 props가 같다면 메모이제이션 해 둔 렌더링 결과를 가져오는 건데요. 메모이제이션 한 결과를 재사용 하여 렌더링 시 가상 DOM에서 달라진 부분을 확인하지 않아 성능상에 이점이 생기게 됩니다.

```js
// App.js의 자식 컴포넌트 Button.js

function Button(){
  return(
    <>
      <button> Click </button>
    <>
  )
}

export default React.memo(Button);
```

그런데 실제로 해당 버튼에 부모 컴포넌트인 <code>App.js</code>에서 <code>onClick</code> 함수를 만들어 자식 컴포넌트인 <code>Button.js</code>에 넘겨줄 시, 당연히 버튼은 동작하지만, 이때 또 다시 리렌더링이 되는 현상을 발견할 수 있습니다.

그 이유는 리렌더링 발생 시 해당 컴포넌트의 모든 객체들이 다시 생성이 되는데, JavaScript에서는 객체는 참조 타입으로 완전히 동일한 값을 가지고 있어도 참조하는 주소가 다르면 서로 다른 객체로 취급하기 때문입니다.

```js
const a = {a: 1, b: 2};
const b = a;

a === b // true
a === {a: 1, b: 2} // false
```

b는 a의 주소값을 복사하였기 때문에 동일한 객체로 인식하지만, a와 값이 완벽히 일치하는 객체는 a와 주소값이 달라 다른 객체로 판단합니다. 따라서 컴포넌트가 리렌더링 될 때마다 **새로운 함수를 계속 생성하며(함수도 객체이기 때문)** 부모 컴포넌트로부터 넘겨 받은 props가 변경되었다 생각하고 리렌더링이 발생하는 것입니다.

즉, 부모 컴포넌트의 리렌더링으로 인한 자식 컴포넌트의 리렌더링을 <code>React.memo</code>로 막을 수 있었지만, props 변경 시 다시 리렌더링이 되는 문제가 야기되는 것이고, 이러한 점을 개선하고자 <code>useMemo</code>와 <code>useCallback</code>를 사용하는 것입니다.

# useMemo

> 메모이제이션 된 값을 반환합니다.

```js
useMemo(param => v, [deps])
```

# useCallback

> 메모이제이션 된 함수를 반환합니다.

```js
useCallback(fn, [deps])
```

비슷하면서도 다른 둘의 차이점이라고 하면 앞서 말한 대로 <code>useMemo</code>는 의존성 배열의 값의 변경을 감지하여 캐싱된 값을 메모이제이션 하여 반환해주는 반면,
<code>useCallback</code>은 의존성 배열의 값의 변경을 감지하여 캐싱된 함수 자체를 차이입니다. 

이처럼 이론만 알고 간다면 적절한 상황에서 알맞은 사용이 가능한데요. 면접 준비용으로만 그치지 않고 직접 사용하여 실전 능력도 키울 필요가 있어 보입니다.

# 참고

https://ykss.netlify.app/web/storage_session_cookie/

https://leego.tistory.com/entry/React-useCallback%EA%B3%BC-useMemo-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0#:~:text=useCallback%20%EA%B3