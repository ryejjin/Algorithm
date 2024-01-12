-- 코드를 입력하세요
SELECT user_id, nickname,
    CONCAT(city,' ',street_address1,' ', street_address2) as 전체주소,
    REGEXP_REPLACE(TLNO, '(.{3})(.{4})(.{4})', '$1-$2-$3') 전화번호
FROM USED_GOODS_BOARD as B INNER JOIN used_goods_user as U
ON B.WRITER_ID = U.USER_ID
GROUP BY USER_ID
HAVING COUNT(USER_ID) >= 3
ORDER BY USER_ID DESC;