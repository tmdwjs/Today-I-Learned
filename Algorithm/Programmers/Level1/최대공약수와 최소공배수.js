function solution(n, m) {
  let G = (a, b) => b === 0 ? a : G(b, a%b)
  let L = (a, b) => a * b / G(a, b)
  return [G(n, m), L(n, m)];
}