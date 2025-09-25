SELECT f1.id, n.fish_name, f1.length
    FROM FISH_INFO f1, FISH_NAME_INFO n
    WHERE f1.fish_type = n.fish_type
    AND f1.length =
        (SELECT MAX(length)
            FROM FISH_INFO f2
            WHERE f1.fish_type = f2.fish_type
        )
    ORDER BY f1.id
;