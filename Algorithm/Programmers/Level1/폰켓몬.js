function solution(nums) {

  // 폰켓몬이 몇 마리든 반만큼 분양 가능 > nums/2
  // 들어온 같으면 안됨 > 가장 많은 종류의 포켓몬을 선택하는 것이라
  // 최대로 가져갈 수 있는 애랑 걸러진 애랑 비교하면 될 듯

  let max = nums.length / 2; // 무조건 최고로 가져갈 수 있는 값
  let filter = new Set(nums); // new Set을 이용해 중복된 애 거르기

  // mine과 filter를 비교
  // 삼항연산자 사용해 보기
  return (max < filter.size) ? max : filter.size;
}