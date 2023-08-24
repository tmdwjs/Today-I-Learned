function solution(arr, divisor) {
  const answer = arr.filter(element => element % divisor == 0)
  return answer.length == 0 ? [-1] : answer.sort((a, b) => a - b)
}