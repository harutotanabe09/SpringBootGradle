SELECT
  *
FROM
  public.web_origins
WHERE
/*%if criteria.clientId != null */
  client_id = /* criteria.clientId */1
/*%end*/
ORDER BY
  client_id ASC