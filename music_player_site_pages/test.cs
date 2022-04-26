
static int[] DikstraAlg(int[,] G, int n, int[] D, int[] V, int[] T, int S, int F){
    int min, i_min;
    V[S] = 1; //1. Начальная
    D[S] = 0; //установка
    T[S] = 0; //...
    int y = S; //...
    do {
        for (int x = 0; x < n; x++) {
            if (G[y, x] != 0 && V[x] == 0) {
                if (D[y] + G[y, x] < D[x])
                    D[x] = D[y] + G[y, x];
            }
        }
        min = INF; //3. Поиск минимального d(xi) и...
        i_min = INF;
        for (int x = 0; x < n; x++)
            if (V[x] == 0)
                if (D[x] < min){
                    min = D[x];
                    i_min = x;
            }
        if (min != INF) {
            pathlength += G[y, i_min];
            T[i_min] = y;
            y = i_min;
            V[i_min] = 1;
        }
        if (y == F) //4. Проверка на окончание алгоритма
            break;
    } while (min != INF) ;
    return T;
}


