const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [n, a, m, b] = input.map(v => v.split(' ').map(el => +el));
a.sort((a, b) => a - b);

const binarySearch = (list, target, left, right, mid) => {
  mid = Math.floor((left + right) / 2);

  if (right < left) {
    return list[mid] == target ? 1 : 0;
  }

  if (list[mid] > target) {
    right = mid - 1;
  } else {
    left = mid + 1;
  }

  return binarySearch(list, target, left, right, mid);
}

const answer = b.map(v => binarySearch(a, v, 0, a.length-1, 0));

console.log(answer.join('\n'));