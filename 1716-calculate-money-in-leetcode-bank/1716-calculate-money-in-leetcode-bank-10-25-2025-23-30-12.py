class Solution:
    def totalMoney(self, n: int) -> int:
        money = 0
        answer = 0
        for i in range(0, n):
            if i % 7 == 0:
                money = i // 7 + 1
            else:
                money += 1
            answer += money

        return answer