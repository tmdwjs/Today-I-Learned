function solution(brown, yellow) {
  const carpet = brown + yellow;
  
  for(let h = 3; h <= brown/2; h++){
    if(carpet % h === 0){
      let w = carpet / h;
      
      if((h-2)*(w-2) === yellow){
          return [w, h];
      }
    }
  }
}