## TIL 2022 10 31

### 백준

#### 문제

[DFS와 BFS(자바스크립트/1260번)](https://www.acmicpc.net/problem/1260)

#### 코드

```text
입력

4 5 1
1 2
1 3
1 4
2 4
3 4
```

```js
const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

// 노드 개수, 간선 개수, 시작 노드 할당
const [nodeLen, edgeLen, start] = input.shift().split(' ').map(v => Number(v));

const graph = new Array(nodeLen + 1); // 노드 개수만큼 그래프를 만들고,

// 빈 배열로 채워줌
for(let i = 0; i < graph.length; i++) graph[i] = [];

// 반복문을 돌며 짝 지어 담기(?)
for(let i = 0; i < edgeLen; i++){
  // from = 시작 노드, to = 하위 노드
  let [from, to] = input[i].split(' ').map(v => Number(v));
  
  graph[from].push(to);
  graph[to].push(from);
}

// 오름차순
graph.forEach(v => v.sort((a, b) => a - b));

// 방문, 0으로 초기화, 방문 시 1, 평소 0
let visited = new Array(nodeLen + 1).fill(0);
// 정답 배열
let answer_dfs = [];

// dfs
const dfs = (start) => {
  if(visited[start]) return; // 방문했었으면 ㅌ ㅌ
  
  visited[start] = 1; // 방문 표시
  answer_dfs.push(start);

  for(let i = 0; i < graph[start].length; i++) {
    const next = graph[start][i];
    if(visited[next] === 0) dfs(next);
  }
}
dfs(start);
console.log(answer_dfs.join(' '));

// 초기화
let answer_bfs = [];
visited.fill(0);

// bfs
const bfs = (start) => {
  let queue = [start]; // 시작 노드 할당

  // 큐 존재 시 반복문 실행. 최종적으로 큐는 다 비워질 예정
  while(queue.length){
    let x = queue.shift();

    if(visited[x] === 1) continue;
    visited[x] = 1;
    answer_bfs.push(x);

    for(let i = 0; i < graph.length; i++) {
      const next = graph[x][i];

      if(visited[next] === 0) queue.push(next);
    }
  }
}

bfs(start);
console.log(answer_bfs.join(' '));
```

### DFS와 BFS

깊이 우선 탐색인 DFS(Depth First Search)와 너비 우선 탐색인 BFS(Breadth First Search)는 그래프 탐색 알고리즘의 대표적인 유형입니다.

> 그래프란?

여기서 그래프란 <code>정점(node)</code>과 그 정점을 연결하는 <code>간선(edge)</code>으로 이루어진 자료 구조입니다.

다시 본론으로 돌아와 DFS와 BFS를 쉽게 드라마를 보는 유형에 비유해서 설명하면, <code>DFS</code>는 종결 후 몰아보는 유형, 즉 한 놈만 패는 유형이면 <code>BFS</code>는 매일 매일 방영할 때마다 여러 개의 드라마를 한 화씩
보는 유형이라고 생각하면 쉽습니다. 저 역시 한 유튜버가 위처럼 설명해줘서 훨씬 이해하기가 빨랐습니다.

위 두 알고리즘의 대표적인 문제 유형은 다음과 같습니다.

1. 경로 탐색 유형(최단거리, 시간)
2. 네트워크 유형(연결)
3. 조합 유형(모든 조합 만들기)

<table>
  <th>DFS</th>
  <th>BFS</th>
  
  <tr>
    <td>스택</td>
    <td>큐</td>
  </tr>
  <tr>
    <td>재귀 함수 사용</td>
    <td>큐 자료 구조 사용</td>
  </tr>
</table>
