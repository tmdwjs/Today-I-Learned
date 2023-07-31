const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [nodeLen, edgeLen, start] = input.shift().split(' ').map(v => Number(v));
const graph = Array.from({ length: nodeLen + 1}, () => []);
for(let i = 0; i < edgeLen; i++){
  const [from, to] = input[i].split(' ').map(v => Number(v));
  graph[from].push(to);
  graph[to].push(from);
}
graph.forEach(v => v.sort((a, b) => a - b));

// bfs
const bfs = (start) => {
  const visited = Array(nodeLen + 1).fill(0);
  let count = 1;

  const queue = [start];
  visited[start] = count;
  
  while(queue.length){
    const cur = queue.shift();

    for(let node of graph[cur]){
      if(visited[node]) continue;

      count += 1;
      visited[node] = count;
      queue.push(node);
    }
  }

  console.log(visited.slice(1).join('\n'));
}

bfs(start);