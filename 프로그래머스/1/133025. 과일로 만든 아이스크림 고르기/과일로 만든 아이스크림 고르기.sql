-- 코드를 입력하세요
SELECT F.FLAVOR
FROM FIRST_HALF F
JOIN ICECREAM_INFO I ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER >= 3000 AND F.FLAVOR NOT IN ('chocolate', 'vanilla', 'mint_chocolate', 'caramel', 'white_chocolate')
ORDER BY F.TOTAL_ORDER DESC;