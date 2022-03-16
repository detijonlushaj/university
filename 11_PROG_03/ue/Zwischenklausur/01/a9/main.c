#include <stdio.h>
#include <stdlib.h>

struct point {
    float x;
    float y;
};

int main(void){
    int n = 0;
    scanf("%d",&n);

    struct point* array[] = { NULL};

    for(int i = 0; i < n; i++) {
        array[i] = (struct point*)malloc(sizeof(struct point));
        scanf("%f %f",&array[i]->x,&array[i]->y);
    }
    return 0;
}