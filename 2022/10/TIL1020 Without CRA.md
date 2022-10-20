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

<code>babel.config.json</code> 생성 후 작성

```json
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

```bash
npm install --save-dev webpack webpack-cli webpack-dev-server
```

<code>webpack</code> 핵심 작동 코드가 담겨 있는 패키지

<code>webpack-cli</code> webpack을 cli 통해 실행하기 위한 패키지

<code>webpack-dev-server</code> 개발할 때 활용하는 개발 서버를 활용하기 위한 설정을 가능하게 하는 패키지

다음은 webpack에서 사용할 loader와 플러그인을 설치합니다.

```bash
# loader
npm install --save-dev babel-loader css-loader sass sass-loader style-loader

# 플러그인
# 번들링 후 출력된 파일을 자동으로 불러오는 HTML 파일을 생성하는 데에 사용한다.
npm install --save-dev html-webpack-plugin
```

```js
// webpack.config.js

const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');

module.exports = {
  entry: './src/index.tsx', // 앱 소스코드 중 최상단 모듈의 경로로 설정하며, 대부분 src/index.js가 역할을 합니다.
  
  // 변환하고 번들링 된 파일을 어느 디렉토리에 어떤 파일명으로 저장할 지에 대한 설정입니다.
  output: {
    path: path.resolve(__dirname, 'dist'), // 경로 설정 위해 path 모듈 불러옵니다.
    filename: 'main.[hash].js',
    clean: true,
  },
  module: {
    rules: [
    // 각각의 loader를 설정합니다.
    // 구성요소는 test, exclude, use로 이루어져 있습니다.
      { // js와 react
        test: /\.(js|jsx|ts|tsx)$/,
        exclude: /(node_modules)/,
        use: 'babel-loader',
      },
      { // css
        test: /\.s?css$/,
        use: [
          { loader: 'style-loader' },
          {
            loader: 'css-loader',
            options: {
              modules: true,
            },
          },
          { loader: 'sass-loader' },
        ],
      },
      { // image
        test: /\.(png|jpe?g|gif|ico)$/,
        type: 'asset/resource',
        generator: {
          filename: 'images/[hash][ext][query]',
        },
      }
    ],
  },
  // 개발 서버 설정
  devServer: {
    static: { // static 파일 위치를 나타내며, 기본으로는 public입니다.
      directory: path.join(__dirname, 'public'),
    },
      historyApiFallback: true,
      compress: true,
      port: 3000,
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: path.resolve(__dirname, './public/index.html'),
    }),
  ],
  resolve: {
    extensions: ['.js', '.ts', '.jsx', '.tsx'],
  },
  mode: process.env.production === 'true' ? 'production' : 'development'
}
```

#### TypeScript

```bash
npm install --save-dev typescript @types/react @types/react-dom
```

<code>tsconfig.json</code>
```json
{
  "compilerOptions": {
    "target": "es5",
    "module": "es2015",
    "jsx": "react-jsx",
    "esModuleInterop": true
  },
  "include": ["src", "src/custom.d.ts"]
}
```

```typescript
// src/custom.d.ts

declare module '*.jpg' {
  const value: string;
  export = value;
}
```

#### React

```bash
npm install react react-dom
```

```html
<!-- public/index.thml -->

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <div id="root"></div>
  </body>
</html>
```

```jsx
// src/App.tsx

function App() {
  return <div>Hello World</div>;
}
export default App;
```

```jsx
// src/index.tsx

import ReactDOM from "react-dom/client";
import App from "./App";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
```

```bash
npm start
```

<img width="600" alt="image" src="https://user-images.githubusercontent.com/85447054/197007313-94d595e9-5f70-429d-81be-762656ae34c1.png">


#### ESLint, Prettier

### 참고
[CRA 없이 React 앱 설정하기](https://medium.com/@uk960214/create-react-app-cra-%EC%97%86%EC%9D%B4-react-%EC%95%B1-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0-typescript-eslint-prettier-dfa783ef0b26)
