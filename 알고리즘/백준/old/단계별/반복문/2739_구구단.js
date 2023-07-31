const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

for(let i = 1; i <= 9; i++){
  console.log(input + ' * ' + i + ' = ' + Number(input)*i);
}