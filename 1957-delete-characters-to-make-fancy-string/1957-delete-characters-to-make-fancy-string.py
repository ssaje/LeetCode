class Solution:
    def makeFancyString(self, s: str) -> str:
        count = 0
        current = ''
        answer = ""
        for char in s:
            if char != current:
                answer = answer + char
                current = char
                count = 1
            elif count < 2:
                answer = answer + char
                count += 1
        
        return answer