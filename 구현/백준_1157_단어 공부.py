from collections import Counter

#단어를 입력받고 단어들을 대문자로 변환
Alpha = input().upper()
#단어에 구성된 알파벳과 그 개수를 딕셔너리 형태로 받음
MaxFre = Counter(Alpha)
#딕셔너리의 값을 리스트 형태로 변환
Val = list(MaxFre.values())
ValMax = max(Val)
Val.remove(ValMax)
if ValMax in Val:
    print('?')
else:
    Max = max(MaxFre, key=MaxFre.get)
    print(Max)

# words = input().lower()
# words_list = list(set(words))
# word_count = list()
#
# for i in words_list:
#     count = words.count(i)
#     word_count.append(count)
#
# if(word_count.count(max(word_count)) >= 2):
#     print('?')
# else:
#     print(words_list[(word_count.index(max(word_count)))].upper())