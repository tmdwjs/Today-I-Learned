const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

// 너무 당연하게 시간 초과...
// const arr = Array.from({length : input}, (v, i) => i + 1);

// while(true){
//   arr.shift();
//   arr.push(arr.shift());

//   if(arr.length === 1) break;
// }


// console.log(arr[0]);

// https://velog.io/@yoseoplee/JS%EB%A1%9C-%ED%91%B8%EB%8A%94-%EB%B0%B1%EC%A4%80-2164.-%EC%B9%B4%EB%93%9C2
// 연결리스트로 구현해서 풀어야 한다.
const N = +input;

class Node {
  constructor(val) {
      this.val = val;
      this.next = null;
      this.prev = null;
  }
}

// LinkedList 클래스 설정
class LinkedList {
  constructor() {
      this.head = null;
      this.tail = null;
      this.length = 0;
  }

  push(val) {
      const newNode = new Node(val);

      if (!this.head) {
          this.head = newNode;
      } else {
          this.tail.next = newNode;
          newNode.prev = this.tail;
      }

      this.tail = newNode;
      this.length++;

      return newNode;
  }

  getHead() { // 첫 노드(head) 가져오기
      return this.head.val;
  }

  removeHead() { // 첫 노드(head)를 연결리스트에서 지우기
      this.head = this.head.next;
      this.head.prev = null;
      this.length--;
  }

  getLength() { // 연결리스트의 길이 알기
      return this.length;
  }
}

const cards = new LinkedList();

for (let i = 1; i <= N; i++) {
  cards.push(i);
}

while (cards.getLength() !== 1) { // 길이가 0 이 아니라면.
  cards.removeHead(); // 맨 앞 노드를 지우고
  cards.push(cards.getHead()); // 맨 앞 노드를 맨뒤로 붙이고
  cards.removeHead(); // 다시 맨 앞 노드를 지우고
}
console.log(cards.getHead());