# nsd_global_variables

Предоставляет классы, содержащие статические поля, имитирующие глобальные переменные скриптов NSD.
Данная библиотека используется только в связке с nsd_upper_level_classes: https://github.com/exeki/nsd_upper_level_classes

Для подключения в скрипт при разработке в IDE нужно произвести их статический импорт.
```groovy
import static ru.ekazantsev.nsd_global_variables.ApiPlaceholder.*
import static ru.ekazantsev.nsd_global_variables.GlobalVariablesPlaceholder.*
```
Данные импорты не запустятся ни в IDE, ни в NSD, при закуске кода в NSD их нужно удалить.

Библиотека собрана на основании документации Naumen.
Библиотека используется для написания скриптов в IDE (для автодополнения) 
и не предназначена для запуска в IDE и/или компиляции, написанные с 
ней скрипты возможно запустить только к среде NSD (консоль, ДПС и тд).