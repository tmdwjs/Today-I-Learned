process.stdin.setEncoding('utf8');
        process.stdin.on('data', data => {

            const n = data.split(" ");
            const a = Number(n[0])
            const b = Number(n[1]);
            // console.log(a); // 5
            // console.log(b); // 3
            
            // a, b가 *로 치환? > a와 b만큼 *으로 반복(repeat)
            // a가 b만큼 repeat 하면 됨
            
            let row = '*'.repeat(a);
            // console.log(row) // 5 = *****
            
            for(let i = 1; i <= b; i++) {
                console.log(row)
            }
            
        });