-- 33cm 이상인 물고기를 종류별로 분류해서
-- 잡은 수, 최대 길이, 물고기 종류 출력
-- 종류에 대해 오름차 정렬
-- 10cm 이하는 10cm로 취급

SELECT 
    COUNT(*) as FISH_COUNT, 
    MAX(ifnull(LENGTH, 10)) as MAX_LENGTH, 
    FISH_TYPE
FROM FISH_INFO 
GROUP BY FISH_TYPE
HAVING AVG(ifnull(LENGTH, 10)) >= 33
ORDER BY FISH_TYPE
;