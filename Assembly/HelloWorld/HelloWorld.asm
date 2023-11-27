section .data
    msg db 'Hello World!', 0  ;string to be printed
    len equ $ - msg           ;length of the string

section .text
    global _start

_start:
    ; write the string to stdout
    mov eax, 4            ; syscall number for sys_write
    mov ebx, 1            ; file descriptor 1 is stdout
    mov ecx, msg          ; pointer to the string
    mov edx, len          ; length of the string
    int 0x80              ; make syscall

    ; exit the program
    mov eax, 1            ; syscall number for sys_exit
    xor ebx, ebx          ; exit code 0
    int 0x80              ; make syscall
