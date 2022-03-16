
#include <stdio.h>
#include <stdlib.h>
struct node {
    int value;
    node * next;
};
node* copy(node* head){
    if( head == NULL) return NULL;
    
    node * new_head = (node*)malloc(sizeof(node));
    new_head->value = head->value;

    node * prev = new_head;

    while (head->next->next != NULL) {
        node * next = (node*)malloc(sizeof(node));
        next->value = head->value;

        prev->next = next;
        head= head->next;

    }
    return new_head;
}


int main(void){
    node head = {0, NULL};
    node one = {1, NULL};
    node two = {2, NULL};

    head.next = &one;
    one.next = &two;

    printf("head: value=%d addr=%p next=%p", head.value, (void *)&head, (void *)head.next);
    printf("\none: value=%d addr=%p next=%p", one.value, (void *)&one, (void *)one.next);
    printf("\ntwo: value=%d addr=%p next=%p", two.value, (void *)&two, (void *)two.next);

    node *co = copy(&head);
    printf("\n\ncopy: value=%d addr=%p next=%p", co->value, (void *)&co, (void *)co->next);
    printf("\ncopy-next: value=%d addr=%p next=%p", co->next->value, (void *)(co->next), (void *)co->next->next);

    printf("\n\nändere value von one");
    one.value = 10;
    printf("\nvalue von copy->next bleibt: %d", co->next->value);
}