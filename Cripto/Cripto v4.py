pri_key = []
txtdesc = ""
wktx = []
txtcod = ""
a = []
b = 0
c = []

## path de criptografia
def criptografar():

    pri_key = []
    txtdesc = ""
    wktx = []
    txtcod = ""
    a = []
    b = 0
    c = []


    txtdesc = input("Texto que vai ser criptografado: ")
    while pri_key == [] or len(pri_key) != 8: #<--garante 8 casas 'cheias' e diferentes de zero.
        pri_key = [int(i) for i in (input("Entre sua senha (8 dígitos númericos): ").replace("0", "1"))]

    wktx = [str(ord(i)).zfill(3) for i in txtdesc] # de/para ascii do texto

    while len(wktx) % 16 != 0:
        wktx.append("000")
    
    a = [[wktx[i:i+4],wktx[i+4:i+8],wktx[i+8:i+12],wktx[i+12:i+16]] for i in range(0,len(wktx),16)] # corte em matrizes de 16 bytes (128 bits) 
    
    print(a)

    for k in pri_key:
        for i in range(0,len(a)):
            if k < 5:
                a[i][k-1].reverse()             
            elif k>4 and k<9:
                b = a[i][k-5][3]
                a[i][k-5][3] = a[i][k-5][0]
                a[i][k-5][0] = b
                b = a[i][k-5][2]
                a[i][k-5][2] = a[i][k-5][1]
                a[i][k-5][1] = b
            else:
                a[i].reverse()

    for i in range(0,len(a)):
        for j in range(0,4):
            for k in a[i][j]:
                txtcod = txtcod + str(k)
    
    print(txtcod)
    
## path de descriptografia
def descriptografia():

    pri_key = []
    txtdesc = ""
    wktx = []
    txtcod = ""
    a = []
    b = 0
    c = []

    txtdesc = input("Texto que vai ser descriptografado: ")
    
    while pri_key == [] or len(pri_key) != 8: #<--garante quatro casas 'cheias' e diferentes de zero.
        pri_key = [int(i) for i in input("Entre sua senha (8 dígitos númericos): ").replace("0", "1")]
        
    pri_key.reverse()

    wktx = [txtdesc[i:i+3] for i in range(0,len(txtdesc),3)] # de/para ascii do texto
    print(wktx)
        
    a = [[wktx[i:i+4],wktx[i+4:i+8],wktx[i+8:i+12],wktx[i+12:i+16]] for i in range(0,len(wktx),16)] # corte em matrizes de 16 bytes (128 bits) 
    print(a)

    for k in pri_key:
        for i in range(0,len(a)):
            if k < 5:
                a[i][k-1].reverse()
            elif k>4 and k<9:
                b = a[i][k-5][3]
                a[i][k-5][3] = a[i][k-5][0]
                a[i][k-5][0] = b
                b = a[i][k-5][2]
                a[i][k-5][2] = a[i][k-5][1]
                a[i][k-5][1] = b
            else:
                a[i].reverse()

    for i in range(0,len(a)):
        for j in range(0,4):
            for k in a[i][j]:
                txtcod = txtcod + chr(int(k))
    
    print(txtcod)

modo = input("modo")
if modo == "0":
    criptografar()
elif modo == "1":
    descriptografia()
