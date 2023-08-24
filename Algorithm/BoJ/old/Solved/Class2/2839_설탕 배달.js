let input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

input = +input; // input 숫자로 받기
let cnt = 0; // 카운트

// 반복문
// 일정 조건 시 break;

// 최대한 적은 봉지를 들고 가려면,
// 5부터 빼고 안 되면 3을 빼는 게 맞음
// 0이면 개수 체크하고, 0으로 안 되면 -1 return
// 근데, 6이나 9일 땐 5부터 빼 버리면 0이 나오는 조건에서도 0으로 안 나눠 떨어짐
// 따라서 5로 나눴을 때 0이 아니라면, 3을 빼고 +1을 함
// 계속 안 나눠지면 애초부터 3으로 나눴어야(뺐어야) 할 애였고
// 어느 순간부터 나눠 떨어지면 최소 개수를 구해야 하니 5로 우다다 나누기


while(true){
    // 5의 배수가 들어오면,
    // 기존에 증가한 count와 5의 배수를 5로 나눈 몫과 더해서 return
    // 0이 들어오면, 3으로 계속 빼면서 카운트 한 수를 return
    if(input % 5 === 0){
        console.log((input / 5) + cnt);
        break;
    }

    // 3씩 계속 빼다가, 0 미만이 돼 버리면 -1 return
    if(input < 0){
        console.log(-1);
        break;
    }

    input -= 3;
    cnt++;
}