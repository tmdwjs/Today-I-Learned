# Multiple Linear Regression

```py
# 다중선형회귀 구현
# 오존데이터 가지고 모델 생성

# 1. 모듈 임포트
import numpy as np # 넘파이
import pandas as pd # 판다스
from sklearn.preprocessing import MinMaxScaler # 정규화 해야 하니, 사이킷 런의 해당 모듈 임포트
# 텐서플로우
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Flatten, Dense
from tensorflow.keras.optimizers import Adam
```

```py
# 2. 로우데이터 로딩
raw_data = pd.read_csv('./data/ozone.csv')
display('[raw_data]', raw_data, raw_data.shape) # (153, 6)

# 1) 결측치 처리 -> 삭제 or 수정 중, 삭제 하기로
raw_data = raw_data.dropna(how='any')
display('[raw_data] 결측치 처리', raw_data, raw_data.shape) # (111, 6) -> 너무 많이 날라감. 원래는 이러면 하면 안됨 -> 데이터 왜곡 때문에

# 2) 이상치 처리 -> 여기서는 하지 않는다고 함

# 3) 정규화 진행 -> 대신 정규화는 진행해야 함
# (1) x, t 데이터 정규화 진행
scaler_x = MinMaxScaler()
scaler_t = MinMaxScaler()

# (2) scaler한테 최대값과 최소값을 알려줘야, 그 정보를 가지고 정규화를 진행
scaler_x.fit(raw_data[['Solar.R', 'Wind', 'Temp']].values) 
scaler_t.fit(raw_data[['Ozone']].values.reshape(-1, 1)) # 오존 한 개는 시리즈이기 때문에, reshape으로 2차원으로 변경해줘야 함
```

```py
# 3. 트레이닝 데이터 셋(학습 데이터 뽑아내기)
# 1) x_data, t_data
x_data = scaler_x.transform(raw_data[['Solar.R', 'Wind', 'Temp']].values)
# print('[x_data] ', x_data)
t_data = scaler_t.transform(raw_data['Ozone'].values.reshape(-1, 1))
# print('[t_data] ', t_data)

# 2) 모델
model = Sequential()

# 3) 레이아웃
model.add(Flatten(input_shape=(3, )))
model.add(Dense(1, activation='linear')) # Dense는 동그라미 1 나옴, activation은 linear 잡아줌

# 4) 모델 설정
model.compile(optimizer=Adam(learning_rate=1e-4), loss='mse') # 우리는 Adam이라는 옵티마이저 사용할 것

# 5) 모델 학습
model.fit(x_data, t_data, epochs=2000, verbose=0)
```

```py
# 우리 모델이 잘 만들어졌는지, 좋은 모델인지 평가해야 함
# 현재는 적당한 평가 기준이 없음
# 4. 모델 평가

```

```py
# 5. 모델 예측
```