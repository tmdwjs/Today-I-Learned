const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().toUpperCase();

const result = Array(26).fill(0);

for(let i = 0; i < input.length; i++){
  result[input.charCodeAt(i) - 65]++;
}

const max = Math.max(...result);
const index = result.indexOf(max);
let isSame = false;

for(let j = 0; j < 26; j++){
  if(result[j] === max && index !== j) {
    isSame = true;
  }
}

console.log(isSame ? '?' : String.fromCharCode(index + 65));