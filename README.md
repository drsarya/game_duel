# game_duel
Основной алгоритм выбора карт для ИИ заключается в анализе уже выбывших карт соперника. 

Если это защита, то берется  среднее значение от оставшихся карт соперника, если атака, то следующее по величине от среднего. 
То есть ход ИИ в случае защиты имеет меньшее значение, чем при атаке.

Таким образом ИИ играет почти средними значениями, что должно уравновесить результирующий счёт игры.

P.S. Тестируя программу, ИИ выигрывал некоторое количество раз.
