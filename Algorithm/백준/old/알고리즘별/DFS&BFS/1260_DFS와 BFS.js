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