const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const arr = input.map(v => v.split('').map(el => +el));
const reverseArr = [];

for(let i = 0; i < arr.length - 1; i++){
  let reverse = '';

  for(let j = arr[i].length - 1; j >= 0; j--){
    reverse += arr[i][j];
  }

  reverseArr.push(reverse);
}

for(let k = 0; k < reverseArr.length; k++){
  if(input[k] === reverseArr[k]) console.log('yes');
  else console.log('no');
}