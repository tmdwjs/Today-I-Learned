function solution(lottos, win_nums) {
  // 배열 생성 담아 리턴
  var answer = [];
  
  // 순서 상관 없다길래 sort()로 오름차순 해서 도출하려 했는데,
  // 0이 있으면 걔네가 앞으로 가기 때문에 의미 없는 시도였음. 바로 철회.
  
  const sames = lottos.filter(lottos => win_nums.includes(lottos)).length;
  const zeros = lottos.filter(lottos => lottos === 0).length;
  
  // sames = 본인 선택 = 로또 번호
  // zeros = 본인이 선택한 거 중에 0(가려진 애들)
  
  // 최고 순위는 같은 거 + 0 개수
  // 최저 순위는 같은 거만
  // 그냥 출력하는 게 아니라 순위를 출력해야 됨
  
  // var min = sames;
  // var max = sames + zeros;
  
  var min = 7 - sames >= 6 ? 6 : 7 - sames;
  var max = min - zeros <= 1 ? 1 : min - zeros;
  
  return answer = [max, min];
}