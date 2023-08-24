// https://school.programmers.co.kr/learn/courses/30/lessons/17680

// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
// cache miss -> 참조하고자 하는 메모리가 캐시에 존재 X -> +5
// cache hit -> 참조하고자 하는 메모리가 캐시에 존재 -> +1

function solution(cacheSize, cities) {
  let answer = 0;
  const cache = [];
  // 도시 배열을 소문자 or 대문자로 통일해줘야 한다.
  const lcCities = cities.map(v => v.toLowerCase());

  for(let i = 0; i < lcCities.length; i++){
    
    // cache miss의 경우,
    if(!cache.includes(lcCities[i])){
      answer += 5; // 5를 더해주고,
      cache.push(lcCities[i]); // 배열에 현재 도시 추가.

      // 배열의 크기가 캐시 사이즈보다 커지면, 맨 처음 요소 삭제.
      if(cache.length > cacheSize) cache.shift();
      
    // cache hit의 경우,
    }else {
      answer += 1; // 1을 더해주고,
      
      // 배열 내의 중복하는 도시를 찾아서 삭제해주고,
      cache.splice(cache.indexOf(lcCities[i]), 1);
      cache.push(lcCities[i]); // 배열에 현재 도시 추가.
    }
  }

  return answer;
}

// LRU: Least Recently Used의 약자로 캐시 교체 알고리즘 중 하나입니다. 이름 그대로 가장 오랫동안 참조되지 않은 페이지를 교체하는 기법입니다.
// Cache miss(캐시 미스): 참조하고자 하는 메모리가 캐시에 존재하지 않음.
// Cache hit(캐시 히트): 참조하고자 하는 메모리가 캐시에 존재.