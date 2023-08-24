const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

// 풀이 1
// const arr = input.map(v => +v);
// const copied = [...arr];

// if(arr.sort((a, b) => a - b).join('') === copied.join('')) console.log('ascending');
// else if(arr.sort((a, b) => b - a).join('') === copied.join('')) console.log('descending');
// else console.log('mixed');

// 풀이 2
const answer = {
	'1 2 3 4 5 6 7 8': 'ascending',
	'8 7 6 5 4 3 2 1': 'descending'
}[input]

console.log(answer || 'mixed');