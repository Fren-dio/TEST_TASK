# TEST_TASK
Test SHIFT's task 

# Инструкция по запуску
## 1 вариант
### Запуск jar файла

создать jar файл

Пример запуска утилиты

java -jar util.jar -s -a -p sample- in1.txt in2.txt

util.jar - название созданного jar файла


## 2 вариант
### Запуск из среды Intellij Idea

Проект необходимо открыть в приложении. 

После в edit configuration указать необходимые входные параметры
![image](https://github.com/user-attachments/assets/2880bbc7-e9b9-4289-9636-7b88620feccd)
Пример входных параметров для запуска


# Параметры программы
По умолчанию файлы результатов перезаписываются. С помощью флага -a можно задать режим добавления в существующие файлы. Если файлы не существуют, они будут созданы заново.

Флаги -s и -f выводят краткую или полную статистику по записанным файлам соответственно.

В полной дополнительно к заданию содержатся: самая короткая и самая длинная строки

С помощью опции -o можно задать путь, куда будут сохраняться результаты.

Опция -p задает префикс имен выходных файлов




## JDK 21
## Bundled (Maven 3) (Version 3.8.1)
