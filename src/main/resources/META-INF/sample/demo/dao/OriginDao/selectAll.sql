SELECT
    *
FROM
    public.web_origins
WHERE
    1 = 1
/*%if criteria.clientId != null */
AND client_id = /* criteria.clientId */1
/*%end*/