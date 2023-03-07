const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [n, ...commands] = input;

const queue = [];
const answer = [];

for(let i = 0; i < n; i++){
  switch(commands[i]){
    case 'front':
      answer.push(queue[0] || -1);
    break;

    case 'back':
      answer.push(queue[queue.length - 1] || -1);
    break;

    case 'size':
      answer.push(queue.length);
    break;

    case 'empty':
      answer.push(queue.length ? 0 : 1);
    break;

    case 'pop':
      answer.push(queue.shift() || -1);
    break;

    default :
      queue.push(input[i].split(' ')[1]);
    break;
  }
}

console.log(answer.join('\n'))