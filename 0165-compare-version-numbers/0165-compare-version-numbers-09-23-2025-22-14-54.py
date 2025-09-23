class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        dots1 = list(map(int, version1.split('.')))
        dots2 = list(map(int, version2.split('.')))

        l1 = len(dots1)
        l2 = len(dots2)
        i = 0
        j = 0
        while i < l1 and j < l2:
            if dots1[i] < dots2[j]: return -1
            elif dots1[i] > dots2[j]: return 1
            i += 1
            j += 1

        if i == l1 and j == l2: return 0
        elif i < l1:
            while i < l1:
                if dots1[i] != 0: return 1
                i += 1
        else:
            while j < l2:
                if dots2[j] != 0: return -1
                j += 1

        return 0