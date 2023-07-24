function solution(n){
  return n.toString().split('').map(n => Number(n)).reduce((a, b) => a + b);
}