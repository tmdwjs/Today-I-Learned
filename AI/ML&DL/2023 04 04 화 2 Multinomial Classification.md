# Multinomial Classification
> Binary Classification을 여러 개 모아놓은 것

<code>Multinomial Classification</code>에서 나오는 중요한 키워드 두 개가 있습니다. <code>Softmax</code>와 <code>One-hot Encoding</code> 입니다.

## 1. 모듈 임포트

```py
# 1. 모듈 임포트
# 1) 기본
import numpy as np # 넘파이
import pandas as pd # 판다스

# 2) 학습 데이터와 테스트 데이터 분리(7:3 or 8:2)
from sklearn.model_selection import train_test_split

# 3) 정규화
from sklearn.preprocessing import MinMaxScaler

# 4) 결측치, 이상치 처리 -> 해당 데이터는 없어서 스킵

# 5) 텐서플로우
from tensorflow.keras.models import Sequential # 모델
from tensorflow.keras.layers import Flatten, Dense # 레이어
from tensorflow.keras.optimizers import Adam # 옵티마이저

# 6) 다중 분류 위한 One-hot encoding 작업
import tensorflow as tf
```

## 2. 로우 데이터 로딩

### 1) CSV 파일 불러오기

```py
# 2. 로우 데이터 로딩
# 1) csv 파일 불러오기
df = pd.read_csv('./data/bmi.csv', skiprows=3)
display(df, df.shape) # (20000, 3)
```

### 2) 데이터 분리
> 학습 데이터와 테스트 데이터를 나누자

```py
# 2) 데이터 분리
# 학습 데이터와 테스트 데이터
# 이 데이터는 튜플인데, 튜플은 괄호 생략 가능하니 다음과 같이 작성하는 것
x_data_train, x_data_test, t_data_train, t_data_test = \
train_test_split(df[['height', 'weight']].values,
                 df['label'].values,
                 test_size=0.3)
print(x_data_train, x_data_train.shape) # (14000, 2)
```

### 3) 정규화 진행

```py
# 3) 정규화 진행
scaler = MinMaxScaler()
scaler.fit(x_data_train)
x_data_train_norm = scaler.transform(x_data_train) # x_data_train_norm = 스케일러를 통해 정규화를 시킨 데이터를 의미
x_data_test_norm = scaler.transform(x_data_test)
print(x_data_train_norm, x_data_train_norm.shape)
```

### 4) one-hot 인코딩

```py
# 4) one-hot 인코딩
# print(t_data_train) # 현재 1차원인데, One-hot으로 바꾸면 2차원 됨

# depth는 class의 수 -> 분류의 개수
t_data_train_onehot = tf.one_hot(t_data_train, depth=3).numpy() # 뒤에 numpy() 붙이면, 앞에 붙는 tf.tensor 제거하고 출력 가능
t_data_test_onehot = tf.one_hot(t_data_test, depth=3).numpy()
```

## 3. 모델 생성

```py
# 3. 모델 생성
# 1) 모델
model = Sequential()

# 2) 모델에 레이어 추가
model.add(Flatten(input_shape=(2, )))
model.add(Dense(3, activation='softmax'))

# 3) 모델 설정
model.compile(optimizer=Adam(learning_rate=1e-4), # 일반적으로 10의 -4승을 줌. 이후 조금씩 조정
              loss='categorical_crossentropy',
              metrics=['accuracy']
             )

# 4) 모델 학습
model.fit(x_data_train_norm, # 학습 시키고, 정규화 시킨 애를 밀어넣어야 함
          t_data_train_onehot, # onehot으로 한 tdata를 넣어야 함
          epochs=500, # 데이터 많으니 반복 횟수는 500번만
          validation_split=0.2, # 트레이닝 데이터를 다시 8:2로 쪼갬
          verbose=0 # verbose 옵션 1로 주면 출력이 나옴
         )
```

## 4. 모델 평가

```py
# 4. 모델 평가
print(model.evaluate(x_data_test_norm, t_data_test_onehot)) # [0.2767546474933624, 0.9750000238418579] 약 97.5%
```

## 5. 모델 예측

```py
# 5. 모델 예측
predict_date = np.array([[177, 77]])
scaled_predict_data = scaler.transform(predict_date)
print(model.predict(scaled_predict_data)) # 말랐을 확률, 표준일 확률, 돼지일 확률
```

![](./images/2023-04-04-13-28-48.png)

## onehot 인코딩 제거

<code>onehot</code> 인코딩 과정을 생략할 수도 있습니다.

### onehot 인코딩 제거

```py
# 4) one-hot 인코딩
# print(t_data_train) # 현재 1차원인데, One-hot으로 바꾸면 2차원 됨

# depth는 class의 수 -> 분류의 개수
# t_data_train_onehot = tf.one_hot(t_data_train, depth=3).numpy() # 뒤에 numpy() 붙이면, 앞에 붙는 tf.tensor 제거하고 출력 가능
# t_data_test_onehot = tf.one_hot(t_data_test, depth=3).numpy()
```

### model.compile 수정

```py
# 3. 모델 생성
# (1) 모델
model = Sequential()

# (2) 모델에 레이어 추가
model.add(Flatten(input_shape=(2, )))
model.add(Dense(3, activation='softmax'))

# (3) 모델 설정
model.compile(optimizer=Adam(learning_rate=1e-4),
              loss='sparse_categorical_crossentropy', # sparse_categorical_corssentropy로 변경
              metrics=['accuracy']
             )

# (4) 모델 학습
model.fit(x_data_train_norm,
          t_data_train, # onehot 제거했으니 기존 tdata 삽입
          epochs=500,
          validation_split=0.2,
          verbose=0
         )
```

### 결과 확인

![](./images/2023-04-04-13-42-42.png)

비슷하게 출력되는 것을 확인할 수 있습니다.