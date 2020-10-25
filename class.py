
class lol:
    def __init__(self, name, difficulty):
        self.name = name
        self.difficulty = difficulty

    def __del__(self):
        print("챔피언 정보를 삭제시킵니다")

    def show_info(self):
        print("챔피언 : ", self.name, "\n난이도 : ", self.difficulty)

    def set_name(self, name):
        self.name = name

    def set_difficulty(self, difficulty):
        self.difficulty = difficulty

lol1 = lol("가렌", "쉬움")
lol1.set_name("갈리오")
lol1.set_difficulty("어려움")
lol1.show_info()
del lol1

