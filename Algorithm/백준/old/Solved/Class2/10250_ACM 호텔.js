const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input.shift();
const arr = input.map(v => v.split(' ').map(el => +el));

for(let i = 0; i < n; i++){
  const [h, w, order] = arr[i];
  let floor = 0;
  let room = 0;

  if(order % h === 0){
    floor = h * 100;
    room = Math.floor(order / h);
  }
  else {
    floor = (order % h) * 100;
    room = 1 + Math.floor(order / h);
  }

  console.log(floor + room);
}