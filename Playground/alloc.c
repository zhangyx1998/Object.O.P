int main(){
    int *ptr, *ptx;
    ptr = malloc(10 * sizeof(int));
    // ptx = ptr;
    // ptr = malloc(10 * sizeof(int));
    // free(ptx);
    free(ptr);
    return 0;
}