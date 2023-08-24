function solution(n) {
  return n.toString().split('').reverse().map(n => Number(n));
}