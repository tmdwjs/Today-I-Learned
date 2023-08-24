# Linear Regression
> 지도 학습의 Linear Regression 예제

지도 학습 중 <code>Linear Regression</code> 예제입니다. 오존량 데이터를 활용해 보도록 하겠습니다.

## 오존량 확인

```py
# 1. 세팅
# 1) 모듈 import
import numpy as np # 넘파이
import pandas as pd # 판다스
import matplotlib.pyplot as plt # 맷플롯립
from tensorflow.keras.models import Sequential # 박스
from tensorflow.keras.layers import Flatten, Dense # 인풋, 아웃풋 레이어
from tensorflow.keras.optimizers import SGD # 옵티마이저

# 2) 데이터프레임 생성
df = pd.read_csv('./data/ozone.csv')
display(df)

# 보다시피 중간중간 NaN이 들어가 있음
# 이것들을 다 처리해야 함
# 이런 과정을 데이터 전처리라고 함
```

![](./images/2023-03-31-13-30-48.png)

```py
# 3) 오존과 온도 가져오기
df = df[['Ozone', 'Temp']]

# 4) 제일 먼저 결측치를 처리 해야 함(NaN 삭제)
df = df.dropna(how='any')
display(df, df.shape) # 116, 2
```

```py
# 2. 트레이닝 데이터셋

# 1) xdata, tdata 생성
# 전체 행, 1열 2차원으로 다시 만듦
x_data = df['Temp'].values.reshape(-1, 1)
t_data = df['Ozone'].values.reshape(-1, 1)

# 2) Model 생성
keras_model = Sequential()

# 3) Layer 생성
input_layer = Flatten(input_shape=(1, ))
output_layer = Dense(1, activation='linear')

# 4) Model에 Layer 추가
keras_model.add(input_layer)
keras_model.add(output_layer)

# 5) Model 설정
keras_model.compile(optimizer=SGD(learning_rate=1e-4), loss='mse')

# 6) Model 학습
keras_model.fit(x_data, t_data, epochs=2000, verbose=0)
```

```py
# 학습이 끝났으면 모델 평가가 이루어져야 함
# 근데 아직 우린 할 줄 모름
# 학습이 잘 이루어졌다 생각하고, 예측 진행

# 3. 예측
result = keras_model.predict([[62]]) # 화씨 62인 경우 오존량은?
print('result: ', result) # 31.814823
# 결과가 나오긴 했어도 잘 예측했는지는 알 수 없음
# 그냥 만들고 테스트만 한 것이기 때문

# 잘 만들어진 라이브러리를 사용해 값을 비교해 보자
# sklearn
```