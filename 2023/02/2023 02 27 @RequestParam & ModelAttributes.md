## @RequestParam

평소 request를 보낼 땐 클라이언트에서 서버로 리퀘스트가 가요 라고 표현을 했지만, 사실 3가지 큰 덩어리로 날라갑니다.

client -> server
1. protocol, method, url
2. Header
3. requestBody

get으로 보내게 되면 requestBody에 데이터가 안 들어감 
get 왜 씀? 간단하고 빠르고 쉬우니까
post를 선호하긴 함 