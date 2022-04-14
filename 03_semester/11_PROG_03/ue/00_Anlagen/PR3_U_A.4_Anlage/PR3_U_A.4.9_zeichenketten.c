#include <stdio.h>
#include <string.h>

/*
 * The strlen() function calculates the length of the string pointed to by s,
 * excluding the terminating null byte ('\0').
 */
size_t mystrlen(const char *s)
{
  /* Ihr Code. */
}

/*
 * The strcpy() function copies the string pointed to by src, including the
 * terminating null byte ('\0'), to the buffer pointed to by dest.
 * The strings may not overlap, and the destination string dest must be
 * large enough to receive the copy.
 * The strcpy() function returns a pointer to the destination string dest.
 */
char *mystrcpy(char *dest, const char *src)
{
  /* Ihr Code. */
}

/*
 * The strcat() function appends the src string to the dest string,
 * overwriting the terminating null byte ('\0') at the end of dest, and then
 * adds a terminating null byte. The strings may not overlap, and the dest
 * string must have enough space for the result.
 * The strcat() function returns a pointer to the resulting string dest.
 */
char *mystrcat(char *dest, const char *src)
{
  /* Ihr Code. */
}

/*
 * The strrchr() function returns a pointer to the last occurrence of the
 * character c in the string s. Here "character" means "byte".
 * The strrchr() function returns a pointer to the matched character or NULL if
 * the character is not found. The terminating null byte is considered part of
 * the string, so that if c is specified as '\0', these functions return a
 * pointer to the terminator.
 */
char *mystrrchr(char *s, int c)
{
  /* Ihr Code. */
}

/*
 * The strstr() function finds the first occurrence of the substring needle in
 * the string haystack. The terminating null bytes ('\0') are not compared.
 * These functions return a pointer to the beginning of the located substring,
 * or NULL if the substring is not found.
 */
char *mystrstr(char *haystack, char *needle)
{
  /* Ihr Code (optional). */
}


int main(void)
{
  char s1[] = "Dies ist ein Teststring!";
  char s2[] = "Und dies noch einer.";
  char buffer1[2000];
  char buffer2[2000];

  printf("mystrlen:  %s\n", mystrlen(s1) == strlen(s1) ? "Richtig" : "Falsch");

  mystrcpy(buffer1, s1);
  printf("mystrcpy:  %s\n", strcmp(buffer1, s1) == 0 ? "Richtig" : "Falsch");

  mystrcpy(buffer1, s1);
  mystrcat(buffer1, s2);
  strcpy(buffer2, s1);
  strcat(buffer2, s2);
  printf("mystrcat:  %s\n", strcmp(buffer1, buffer2) == 0 ? "Richtig" : "Falsch");

  printf("mystrrchr: %s\n", mystrrchr(s1, 'i') == strrchr(s1, 'i') ? "Richtig" : "Falsch");

  printf("mystrstr:  %s\n", mystrstr(s1, "Test") == strstr(s1, "Test") ? "Richtig" : "Falsch");

  return 0;
}

