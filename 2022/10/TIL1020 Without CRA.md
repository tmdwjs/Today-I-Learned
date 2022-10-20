## TIL 2022 10 20

### Create React App 없이 리액트 환경 세팅

[이전 글 보기](https://github.com/BaikSeungJeon/TIL/blob/main/2022/10/TIL1019%20Webpack%20Babel.md)

#### 리액트 앱 구성 요소
- React, React Dom
- React 기반으로 작성된 코드를 번들링 할 번들러(웹팩)
- 번들러에서 리액트의 JSX를 JS로 변환해 줄 트랜스파일러(바벨)

추가적으로
- 타입스크립트
- ESLint와 Prettier

와 같이 존재합니다.

#### npm init

리액트 앱 설정 과정에서 npm 패키지 매니저를 사용할 것이기 때문에,

<code>npm init</code> 명령어를 사용하여 <code>package.json</code>을 생성하고 패키지를 설치 관리합니다.

#### babel

```bash
npm install --save-dev @babel/core @babel/cli @babel/preset-env @babel/preset-react @babel/preset-typescript
```
<code>@babel/cor</code> 실제 babel의 작동을 위한 코드를 담고 있는 핵심 패키지

<code>@babel/cli</code> cli를 이용해 직접 babel을 가동해 트랜스파일을 하기 위해서 필요한 패키지

<code>@babel/preset-env</code> 가장 기본이 되는 패키지.

<code>@babel/preset-react</code> React 사용을 위해 필요한 패키지.

<code>@babel/preset-typescript</code> TypeScript > JavaScript로 변환하기 위해 필요한 패키지

이후 Babel이 정상 작동할 수 있도록 설정을 해 주어야 합니다.

<code>babel.config.json</code>를 생성해 주시고,

```bash
# babel.config.json

{
  "presets": [
    "@babel/preset-env",
    ["@babel/preset-react", { "runtime": "automatic" }],
    "@babel/preset-typescript"
  ],
  "targets": "> 0.5%, not dead"
}
```

> 🙋‍♂️ 왜 <code>@babel/preset-react</code>만 배열 형태인가요?

리액트 17에서 추가된 기능으로, <code>automatic</code>로 설정 시, JSX에서 리액트를 실제 import 해 오지 않더라도 자동으로 해석해 주기 때문입니다.

#### Webpack



#### TypeScript


#### React


### Redux


### 참고
[CRA 없이 React 앱 설정하기](https://medium.com/@uk960214/create-react-app-cra-%EC%97%86%EC%9D%B4-react-%EC%95%B1-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0-typescript-eslint-prettier-dfa783ef0b26)

[벨로퍼트 님 블로그](https://react.vlpt.us/redux/01-keywords.html)
