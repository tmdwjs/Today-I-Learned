function solution(price, money, count) {
  var cost = 0;
  for(let i = 1; i <= count; i++) cost += price * i;
  return cost <= money ? 0 : cost - money;
}