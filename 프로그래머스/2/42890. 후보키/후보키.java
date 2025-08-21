import java.util.*;

class Solution {
    List<Integer> candidateKeys = new ArrayList<>();
    int rowCount, colCount;
    String[][] table;

    public int solution(String[][] relation) {
        table = relation;
        rowCount = relation.length;
        colCount = relation[0].length;

        // 모든 컬럼 조합을 비트마스크로 탐색
        for (int bitmask = 1; bitmask < (1 << colCount); bitmask++) {
            if (isUnique(bitmask) && isMinimal(bitmask)) {
                candidateKeys.add(bitmask);
            }
        }

        return candidateKeys.size();
    }

    // 유일성 검사: 해당 컬럼 조합으로 모든 행이 구분되는지
    private boolean isUnique(int bitmask) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < colCount; j++) {
                if ((bitmask & (1 << j)) != 0) {
                    key.append(table[i][j]).append(",");
                }
            }
            if (!seen.add(key.toString())) {
                return false;
            }
        }

        return true;
    }

    // 최소성 검사: 이미 등록된 후보키가 현재 조합의 부분집합이면 안 됨
    private boolean isMinimal(int bitmask) {
        for (int key : candidateKeys) {
            if ((key & bitmask) == key) {
                return false;
            }
        }
        return true;
    }
}
