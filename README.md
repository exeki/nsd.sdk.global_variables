# nsd_global_variables

Предоставляет классы, содержащие статические поля, имитирующие глобальные переменные скриптов NSD.
Для подключения при разработке в IDE нужно произвести их статический импорт.
```groovy
import static ru.ekazantsev.nsd_global_variables.ApiPlaceholder.*
import static ru.ekazantsev.nsd_global_variables.GlobalVariablesPlaceholder.*
```
Собрано на основании документации Naumen.
Библиотека используется для написания скриптов в IDE (для автодополнения) 
и не предназначена для запуска в IDE и/или компиляции, написанные с 
ней скрипты возможно запустить только к среде NSD (консоль, ДПС и тд).