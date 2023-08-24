function solution(a, b) {
  let day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  let date = new Date('2016-' + a + '-' + b);
  return day[date.getDay()];
}