const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [n, ...commands] = input;

const deque = [];
const answer = [];

for(let i = 0; i < n; i++){
  switch(commands[i]){
    case 'front':
      answer.push(deque[0] || -1);
    break;

    case 'back':
      answer.push(deque[deque.length - 1] || -1);
    break;

    case 'size':
      answer.push(deque.length);
    break;

    case 'empty':
      answer.push(deque.length ? 0 : 1);
    break;

    case 'pop_front':
      answer.push(deque.shift() || -1);
    break;

    case 'pop_back':
      answer.push(deque.pop() || -1);
    break;

    default :
      if(commands[i].split('_')[1].split(' ')[0] === 'front'){
        deque.unshift(commands[i].split('_')[1].split(' ')[1]);
      }else {
        deque.push(commands[i].split('_')[1].split(' ')[1]);
      }
    break;

    
  }
  // console.log('deque: ', deque, 'answer: ', answer);
  
}

console.log(answer.join('\n'));