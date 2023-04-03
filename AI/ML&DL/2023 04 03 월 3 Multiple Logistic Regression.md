# Multiple Logistic Regression

이제 <code>Multiple</code>이란 단어는 사용하지 않을 것입니다. 왜냐하면 당연히 독립 변수가 여러 개인 <code>Multiple</code> 형태이기 때문입니다. 지금부터 알아볼 건 <code>Logistic Regression</code>입니다.

<code>Logistic Regression</code>는 데이터가 바뀐, 다시 말해 독립 변수가 아닌 종속 변수의 형태가 바뀐 것을 의미합니다. 아래는 간단한 예시입니다.

<pre>
시간    연수    합격여부
x1     x2       t
--------------------
1       1       0
3       1       0
2       3       1
10      1       1 
5       2       1
</pre>

이처럼 <code>t data</code>가 0과 1로 돼 있으면 <code>Linear Regression</code>으로 해결할 수가 없습니다. 이런 것을 <code>binary classification</code>이라고 합니다. 이 문제를 처음에는 <code>Linear Regression</code>으로 해결하려고 노력해 봤지만 안 됐습니다. 그럼 어떻게 하면 될까요? <code>Sigmoid</code>라는 수학 식(<code>1 / (1 + exp(-x))</code>)이 있는데, 이를 이용해 모델을 만들면 된다고 생각을 하게 됩니다.

앞에서 작성한 식(<code>1 / (1 + exp(-x))</code>)의 <code>x</code>에 <code>Linear Regresiion Model</code>을 밀어넣어 새로운 수학식을 만들어 새로운 모델을 만들어 냅니다.

기존 <code>Linear Regression</code>은 모델 <code>y = xw + b</code>의 식에서 더욱 좋은 예측치를 출력하려는 것이 목적입니다. 그 예측치가 좋은지 아닌지는 저희가 가지고 있는 실제값이랑 비교를 하는 것이고, 그 비교하는 것을 <code>loss</code>라고 합니다. 그리고 그 <code>loss</code>로 <code>MSE</code>를 사용합니다.

<code>Logistic Regression</code>은 모델이 <code>y = 1 / 1 + e^-(xw + b)</code> 식의 형태를 가지고 있습니다. 이 모델 역시 예측치와 실제값을 비교해보려 시도했지만 그것에 실패한 것이고요. 하지만 저희는 <code>loss</code>를 계산하긴 해야 하기 때문에 <code>MSE</code>가 아닌 다른 수식을 찾고자 합니다. 그 수식이 <code>Cross Entropy</code>입니다. 수식은 <code>y = - Σi p(xi) * log(q(xi))</code>로 나타낼 수 있습니다.

예측치는 0과 1 사이의 값이 나오게 됩니다. 만약 0.3이 나온다면 1이 될 확률이 30%, 0.7이 나온다면 1이 될 확률은 70%로 볼 수 있습니다. 즉, 예측치는 확률값으로 나오게 됩니다.

```py
# ㅎㅇㅎㅇ
```

## Evalueation
> 평가

<code>Logistic Regression</code>으로 넘어가면서, 평가를 진행하게 됩니다. <code>Linear Regression</code>도 평가를 진행해야 하지만, 보통 <code>Logistic Regression</code>으로 넘어가면서 평가 이야기가 나오는 편입니다.

### 1. 평가 방법(데이터 관점)

<code>Training Data Set</code> 우리가 가지고 있는 데이터를 의미합니다. 위 예제를 기준으로 약 400개가 있다고 가정해 보겠습니다. 이를 일반적으로 7:3 혹은 8:2 비율로 데이터를 자릅니다. 이때 7 혹은 8 비율을 학습 데이터(<code>Training Data Set</code>), 나머지 비율을 시험 데이터(<code>Test Data Set</code>)이라고 합니다. 시험 데이터는 최종 단계에서 딱 한 번 사용합니다.

7의 비율 중, 또 약 7:3 정도로 나눠, 7이 <code>Training Data Set</code>, 나머지를 <code>Validation Data Set</code>라고 합니다. <code>Validation Data Set</code>은 학습이 진행되면서 학습이 잘 진행되는지 아닌지를 확인하기 위한 평가용 데이터 셋을 의미합니다.

### 2. 평가 기준(Metric)

![](2023-04-03-13-45-34.png)

이를 <code>Confusion Matrix</code>라고 합니다.