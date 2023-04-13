const input = Number(require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim());

const fibo = (n) => {
    if(n === 1 || n === 2) return 1;
    else return (fibo(n - 1) + fibo(n - 2));
}

console.log(fibo(input), input-2);