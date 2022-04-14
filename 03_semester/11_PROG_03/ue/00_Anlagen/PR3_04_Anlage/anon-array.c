extern void foo(int a[]);

int main(void) {
  foo( (int[]) {2,4,6,8} );  // anonymer Array
  return 0;
}
