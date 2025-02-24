Лабораторная №1, ПнаЯВУ, группа 334701, Вариант №13
----

Пример запроса для перевода
```http://localhost:8080/getTranslation?srcL=en&targetL=ru&text=Hello+World```

Параметрв `srcL`, `targetL`, `text` отвечают за язык оригигнала, желаемый язык и текст запроса соответственно.


Пример вывода

```
[
  "[[[\"Привет, мир\",\"Hello World\",null,null,10]],null,\"en\",null,null,null,null,[]]"
]
```