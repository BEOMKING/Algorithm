'''
Python의 오픈 소스 머신 러닝 라이브러리
결 측값 대치, 범주 형 데이터 변환, 기능 엔지니어링 또는 하이퍼 파라미터 튜닝 등 모든 것을 자동화
'''
import pandas as pd
from pycaret.classification import * # pycaret 설치 및 분류 함수 불러오기

path = 'C:/DataSet/Data/open data/open data/' # 경로 설정
train = pd.read_csv(path + 'train.csv')
test = pd.read_csv(path + 'test_x.csv')
submission = pd.read_csv(path + 'sample_submission.csv')

'''pycaret에서는 모델 학습 전 setup 함수를 이용한 실험 환경 구축이 필요
진행 후에 train set과 validation 셋의 나눌 비율을 정하게 되는데 100% 훈련세트 할거면 enter 지정해서 할거면 ex 0.7'''
clf = setup(data = train, target = 'voted', ignore_features=['index'], train_size=0.7) # 정답 레이블인 voted 컬럼을 target 지정, index 컬럼인 index를 무시
'''모델 학습 및 비교
pycaret에서는 '''
best_3 = compare_models(sort = 'Recall', n_select = 3)
blended = blend_models(estimator_list = best_3, fold = 5, method = 'soft')