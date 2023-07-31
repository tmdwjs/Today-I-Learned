const input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split('\n');

const arr = input.slice(0, input.length - 1);   // 입력 배열
const open = ["(", "["];    // 시작 괄호
const close = [")", "]"];   // 종료 괄호
const answer = [];   // 정답 배열

arr.forEach(el => {
    const stack = [];   // 스택 배열
    let isNo = false;   // 괄호가 올바르지 않으면 true 할당
                        // 바로 조건문 안 하고 바로 하는 이유?
                        // 'filter 부분'에서 isNo를 true로 해 줘야,
                        // 확실히 짝이 아니라 'no'를 배열에 넣은 case는 피할 수 있음

    // 한 문장의 길이만큼 반복문 실행
    for(let i = 0; i < el.length; i++){
        // '(' or '[' 발견하면 stack에 push
        if(open.includes(el[i])) stack.push(el[i]);

        // ')' or ']' 발견하면,
        else if(close.includes(el[i])){
            // filter 부분

            // stack에 제일 마지막(가장 최근에 들어간 시작 괄호)과
            // 현재 닫는 괄호의 close 배열에서의 인덱스와,
            // 같은 위치에 있는 시작 괄호가 아니라면
                // 예를 들면, ')'라면, '(', ']'라면, '['
            if(stack.pop() !== open[close.indexOf(el[i])]){
                answer.push("no");  // 정답 배열에 'no' push
                isNo = true;    // 반복문 종료 후 조건문에 해당되지 않게 true 재할당
                break;  // 조건문 종료
            }
        }
    }

    if(!isNo){
        // stack의 길이가 0 > 전부 짝이 맞아 떨어졌다는 의미
            // 즉, 'yes' push
        if(stack.length == 0) answer.push('yes');
        else answer.push('no'); // 그 외엔 전부 'no' push
    }
    
})

console.log(answer.join('\n')); // answer 배열에 담아 줄바꿈으로 return