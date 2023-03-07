// https://school.programmers.co.kr/learn/courses/30/lessons/12949

// arr1 3*2 * arr2 2*2 = arr3 3*2
// 1, 4     3, 3
// 3, 2     3, 3
// 4, 1

// arr1 3*3 * arr2 3*3 = arr3 3*3
// 2, 3, 2     5, 4, 3
// 4, 2 ,4     2, 4, 1
// 3, 1, 4     3, 1, 1

function solution(arr1, arr2) {
  const arr3 = [];

  // arr3은 첫 번째 행렬 arr1의 행과 같다.
  // 따라서 arr1의 행만큼 반복문 실행.
  for(let i = 0; i < arr1.length; i++){
    let index = [];
    
	// arr3은 두 번째 행렬 arr2의 열과 같다.
    // 마찬가지로 arr2의 열만큼 반복문 실행.
    for(let j = 0; j < arr2[0].length; j++){
      let elem = 0; // 변수 선언

      // 요소들을 곱하여 변수에 더해준다.
      for(let k = 0; k < arr1[0].length; k++){
        elem += arr1[i][k] * arr2[k][j];
      }
      
      index.push(elem);
    }

    arr3.push(index);
  }

  return arr3;
}
