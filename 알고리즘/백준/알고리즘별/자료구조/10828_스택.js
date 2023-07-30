const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().split('\n');

const N = Number(input.shift());

const stack = [];
const answer = [];

for(let i = 0; i < N; i++){
  switch(input[i]){
    case 'pop' :
      answer.push(stack.pop() || -1);
      break;

    case 'top' :
      answer.push(stack[stack.length-1] || -1);
      break;

    case 'size' :
      answer.push(stack.length);
      break;

    case 'empty' :
      answer.push(stack[0] ? 0 : 1);
      break;

    default :
      stack.push(input[i].split(' ')[1]);
      break;
  }
}

console.log(answer.join('\n'));

// case문 더 잘 사용해 보기