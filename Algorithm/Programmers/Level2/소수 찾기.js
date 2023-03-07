function isPrime(n){
  if(n < 2) return false;
  for(let i = 2; i <= Math.sqrt(n); i++){
      if(n % i == 0) return false;
  }
  return true;
}

function solution(numbers){
  let arr = numbers.split('');
  let answer = new Set(); // 중복 제거
  
  function permutation(num, fix){
      if(num.length){
          for(let i = 0; i < num.length; i++){
              let copyArr = [...num];
              copyArr.splice(i, 1);
              
              if(isPrime(parseInt(fix + num[i]))){
                  answer.add(parseInt(fix + num[i]));
              }
              permutation(copyArr, fix + num[i]);
          }
      }
  }
  permutation(arr, '');
  return answer.size;
}