function solution(n) {
  let sqrt = Math.sqrt(n);
  return sqrt % 1 !== 0 ? -1 : Math.pow(sqrt + 1, 2);
}