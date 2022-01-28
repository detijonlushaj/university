#include<stdio.h>
#include <stdlib.h>

//a.)
struct node{
    int value;
    node * next;
};

//b.) 
node * create(int x){
    node* cre = (node*)malloc(sizeof(node));
    cre->value = x;
    cre->next = NULL;
    return cre;
}

int insert_head(node ** head, node * einzufueg){
    if (head == NULL || einzufueg == NULL) return -1;
    
    einzufueg->next = (*head);

    *head = einzufueg;
    return 0;
}

void print(node * head){
    while(head != NULL){
        printf("%d ", head->value);
        head = head->next;
    }
}

int main(void) {   
    node* head = NULL; /* leere Liste */   
    int error = insert_head(&head, create(5));   
    error |= insert_head(&head, create(3));   
    error |= insert_head(&head, create(1));   
    if (error != 0) {     
        printf("Fehler\n");   
    } else {     
        print(head); /* Gewünschte Ausgabe: 1 3 5 */   
    }   
    return 0; 
}
