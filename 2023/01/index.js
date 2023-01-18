function outerFunc(x) {
  var y = 1;

  // innerFunc는 클로저 함수
  return function innerFunc(z) {
    y = 100;

    return x + y + z;
  };
}

var sum1 = outerFunc(1); // 외부 함수 호출은 한 번만 한다.
var sum100 = outerFunc(100);
// 이제 클로저에 x와 y의 환경이 저장됐음.

console.log(sum1(1));  // 102 = x: 1 + y: 100 + z: 1
console.log(sum1(10)); // 111 = x: 1 + y: 100 + z: 10
console.log(sum1(100)); // 201 = x: 1 + y: 100 + z: 100
console.log(sum100(1000)); // 1200 = x: 100 + y: 100 + z: 1000

//함수 실행 시 클로저에 저장된 x, y값에 접근하여 값을 계산한다.