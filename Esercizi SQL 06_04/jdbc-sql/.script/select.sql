SELECT * FROM prodotti p
LEFT JOIN varianti v on p.id = v.prodotto_id
WHERE v.attributo = 'colore';